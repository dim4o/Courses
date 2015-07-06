using System;

class ReversedListTest
{
    static void Main()
    {
        Console.WriteLine();
        // creates GenericList<int>
        ReversedList<int> list = new ReversedList<int>();

        //empry list test
        Console.WriteLine(list);

        // adding test
        for (int i = 0; i < 10; i++)
        {
            list.Add(i);
            Console.WriteLine(list);
        }
        Console.WriteLine(list);
        // removing element by index test
        for (int i = 9; i >= 0; i--)
        {
            list.Remove(i);
            Console.WriteLine(list);
        }

        list.Add(6);
        list.Add(1);
        list.Add(7);
        list.Add(5);
        list.Add(9);
        list.Add(2);
        list.Add(8);
        list.Add(0);
        list.Add(3);
        list.Add(4);
        Console.WriteLine(list);

        //Console.WriteLine(list[6]);

        foreach (var item in list)
        {
            Console.WriteLine(item);
        }
        

        //// accessing element by index test
        //Console.WriteLine(list[3]);
        //Console.WriteLine(list[6]);
        //Console.WriteLine(list[9]);
        //Console.WriteLine();

        ////finding element index by given value test
        //Console.WriteLine(list.Find(3));
        //Console.WriteLine(list.Find(6));
        //Console.WriteLine(list.Find(9));
        //Console.WriteLine(list.Find(15));
        //Console.WriteLine(list.Find(-15));
        //Console.WriteLine();

        //// contains test
        //Console.WriteLine(list.Contains(3));
        //Console.WriteLine(list.Contains(6));
        //Console.WriteLine(list.Contains(9));
        //Console.WriteLine(list.Contains(15));
        //Console.WriteLine(list.Contains(-15));
        //Console.WriteLine();

        //// finding the minimal element test
        //Console.WriteLine(list.Min());
        //Console.WriteLine(list.Max());
        //Console.WriteLine();

        ////ToString() text
        //Console.WriteLine(list.ToString());

        //// clearing the list
        //list.Clear();
        //Console.WriteLine(list);
    }
}

