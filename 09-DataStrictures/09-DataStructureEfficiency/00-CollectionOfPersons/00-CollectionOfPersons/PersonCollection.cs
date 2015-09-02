using System;
using System.Collections.Generic;
using Wintellect.PowerCollections;

public class PersonCollection : IPersonCollection
{
    private Dictionary<string, Person> personsByEmail = 
        new Dictionary<string, Person>(); 

    private Dictionary<string, SortedSet<Person>> personsByEmailDomain = 
        new Dictionary<string, SortedSet<Person>>();
 
    private Dictionary<Tuple<string, string>, SortedSet<Person>> personsByNameAndTown =
        new Dictionary<Tuple<string, string>, SortedSet<Person>>();

    private OrderedDictionary<int, OrderedSet<Person>> personsByAge =
        new OrderedDictionary<int, OrderedSet<Person>>();

    private Dictionary<string, OrderedDictionary<int, SortedSet<Person>>> personsByTownAndAge =
        new Dictionary<string, OrderedDictionary<int, SortedSet<Person>>>(); 


    public bool AddPerson(string email, string name, int age, string town)
    {
        var person = new Person()
        {
            Email = email, Name = name, Age = age, Town = town
        };
        if (FindPerson(email) != null)
        {
            return false;
        }

        // Add by email
        this.personsByEmail.Add(email, person);

        // Add by emial domain
        var emailDomain = this.ExtractEmailDomain(email);
        this.personsByEmailDomain.AppendValueToKey(emailDomain, person);

        // Add by name and town
        var nameAndTown = new Tuple<string, string>(name, town);
        this.personsByNameAndTown.AppendValueToKey(nameAndTown, person);

        // Add by age
        this.personsByAge.AppendValueToKey(age, person);

        // Add by town and age
        this.personsByTownAndAge.EnsureKeyExists(town);
        this.personsByTownAndAge[town].AppendValueToKey(age, person);
        return true;
    }

    private string ExtractEmailDomain(string email)
    {
        var domain = email.Split('@')[1];
        return domain;
    }

    public int Count
    {
        get { return this.personsByEmail.Count; }
    }

    public Person FindPerson(string email)
    {
        Person person;
        var personExists = this.personsByEmail.TryGetValue(email, out person);

        return person;  
    }

    public bool DeletePerson(string email)
    {
        var person = FindPerson(email);
        if (person == null)
        {
            return false;
        }
        // Delete person from personsByEmail
        var personDeleted = this.personsByEmail.Remove(email);

        // Delete person from personsByEmailDomain
        var emailDomain = this.ExtractEmailDomain(email);
        this.personsByEmailDomain[emailDomain].Remove(person);

        // Delete person from personsByNameAndTown
        var nameAndTown = new Tuple<string, string>(person.Name, person.Town);
        personsByNameAndTown[nameAndTown].Remove(person);

        // Delete person by personsByAge
        this.personsByAge[person.Age].Remove(person);

        // Delete person by personsByTownAndAge
        this.personsByTownAndAge[person.Town][person.Age].Remove(person);

        return true;
    }

    public IEnumerable<Person> FindPersons(string emailDomain)
    {
        //SortedSet<Person> persons;
        //var personExist = this.personsByEmailDomain.TryGetValue(emailDomain, out persons);
        return this.personsByEmailDomain.GetValuesForKey(emailDomain);

        //return persons;
    }

    public IEnumerable<Person> FindPersons(string name, string town)
    {
        var nameAndTown = new Tuple<string, string>(name, town);
        return this.personsByNameAndTown.GetValuesForKey(nameAndTown);
    }

    public IEnumerable<Person> FindPersons(int startAge, int endAge)
    {
        var personsInRange = this.personsByAge.Range(startAge, true, endAge, true);
        foreach (var personByAge in personsInRange)
        {
            foreach (var person in personByAge.Value)
            {
                yield return person;
            }
        }
       
    }

    public IEnumerable<Person> FindPersons(
        int startAge, int endAge, string town)
    {
        if (!this.personsByTownAndAge.ContainsKey(town))
        {
            // Return an empty sequence of persons
            yield break;    
        }

        var personsInRange = this.personsByTownAndAge[town].Range(startAge, true, endAge, true);

        foreach (var personByAge in personsInRange)
        {
            foreach (var person in personByAge.Value)
            {
                yield return person;
            }
        }
    }
}
