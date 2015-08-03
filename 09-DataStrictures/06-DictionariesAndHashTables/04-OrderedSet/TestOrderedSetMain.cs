using System;

class TestOrderedSetMain
{
    static void Main()
    {
        var tree = new OrderedSet<int>();
        Console.WriteLine("Add: 29, 11, 35, 7, 16, 23, 37, 17");
        tree.Add(29);
        tree.Add(11);
        tree.Add(35);
        tree.Add(7);
        tree.Add(16);
        tree.Add(23);
        tree.Add(37);
        tree.Add(17);

        Console.WriteLine();

        Console.WriteLine("In-order print: ");
        tree.PrintInorder(tree.Root);

        Console.WriteLine();
        Console.WriteLine();

        Console.WriteLine("Foreach: ");
        foreach (var item in tree)
        {
            Console.Write(item + " ");
        }

        Console.WriteLine();
        Console.WriteLine();

        Console.WriteLine("EachInOrder(Action<T> action): ");
        tree.EachInOrder(n => Console.Write(n + " "));

        Console.WriteLine();
        Console.WriteLine();

        Console.WriteLine("Insert 23: ");
        tree.Add(23);
        tree.EachInOrder(n => Console.Write(n + " "));

        Console.WriteLine();
        Console.WriteLine();

        Console.WriteLine("Remove 16: ");
        tree.Remove(16);
        tree.EachInOrder(n => Console.Write(n + " "));

        Console.WriteLine();
        Console.WriteLine();

        Console.WriteLine("Find 7: ");
        var find7 = tree.Find(7) != null ? "7" : "null";
        Console.WriteLine(find7);


        Console.WriteLine();

        Console.WriteLine("Find 200: ");
        var find200 = tree.Find(200) != null ? "200" : "null";
        Console.WriteLine(find200);

        Console.WriteLine();

        Console.WriteLine("Contains 7: ");
        var contains7 = tree.Contains(7) == true ? "true" : "false";
        Console.WriteLine(contains7);

        Console.WriteLine();

        Console.WriteLine("Contains 200: ");
        var contains200 = tree.Contains(200) == true ? "true" : "false";
        Console.WriteLine(contains200);

        Console.WriteLine();

        Console.WriteLine("Count:");
        Console.WriteLine(tree.Count);

        Console.WriteLine(
            "Count after Add and Remove: Add 1, Remove 23, Add 5, " +
            "Add 14, Add 108, Remove 5, Remove 12 (no such value)");
        tree.Add(1);
        tree.Remove(23);
        tree.Add(5);
        tree.Add(14);
        tree.Add(108);
        tree.Remove(5);
        tree.Remove(12);// no such value
        Console.WriteLine("Count: {0}", tree.Count); 
        tree.EachInOrder(n => Console.Write(n + " "));

        Console.WriteLine();
        Console.WriteLine();

        Console.WriteLine("Min value: {0}", tree.Min());

        Console.WriteLine();

        Console.WriteLine("Min value: {0}", tree.Max());

        Console.WriteLine();

        tree.Clear();
        Console.WriteLine("Clear: {0} (Count)", tree.Count);

    }
}

