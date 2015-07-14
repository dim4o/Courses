using System;
using _07_LinkedQueue;
using System.Collections.Generic;


class Tests
{
    static void Main()
    {
        var queue = new LinkedQueue<int>();

        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);

        //queue.Dequeue();
        //queue.Dequeue();
        //queue.Dequeue();
        var arr = queue.ToArray();
        Console.WriteLine(string.Join(", ", arr));
    }
}

