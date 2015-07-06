function findYoungestPerson(persons) {
    persons.sort(function (a, b){return a['age'] - b['age']});
    var i = 0;
    while(persons[i]['age'] == undefined){
        if (i < persons.length - 1) {
            i++;
        } else {
            break;
        }
    }
    return persons[i];
}
function printResult(persons) {
    var youngest = findYoungestPerson(persons);
    if (youngest['age'] == undefined) {
        console.log('No youngest person');
    } else {
        console.log('The youngest person is ' +
        youngest.firstname +' '+ youngest.lastname);
    }
}
//tests
printResult([
        { firstname : 'George', lastname: 'Kolev', age: 32},
        { firstname : 'Bay', lastname: 'Ivan', age: 81},
        { firstname : 'Baba', lastname: 'Ginka', age: 18}]
);
console.log();
printResult([
        { firstname : 'George', lastname: 'Kolev', age: undefined},
        { firstname : 'Bay', lastname: 'Ivan', age: 15},
        { firstname : 'Baba', lastname: 'Ginka', age: 40}]
);
console.log();
printResult([
        { firstname : 'George', lastname: 'Kolev', age: undefined},
        { firstname : 'Bay', lastname: 'Ivan', age: undefined},
        { firstname : 'Baba', lastname: 'Ginka', age: undefined}]
);
console.log();
var persons = [
  { firstname : 'George', lastname: 'Kolev', age: 32}, 
  { firstname : 'Bay', lastname: 'Ivan', age: 81},
  { firstname : 'Baba', lastname: 'Ginka', age: 40}]
printResult(persons);

