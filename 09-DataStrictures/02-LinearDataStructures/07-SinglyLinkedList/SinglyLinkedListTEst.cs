using System;

class SinglyLinkedListTEst
{
    static void Main()
    {
        SinglyLinkedList<int> list = new SinglyLinkedList<int>();

        list.AddLast(1);
        list.AddLast(2);
        list.AddLast(3);
        list.AddLast(4);
        list.AddLast(5);
        list.AddLast(6);

        Console.WriteLine(list.Count);
        list.Remove(0);

        foreach (var item in list)
        {
            Console.WriteLine(item);
        }
    }
}

