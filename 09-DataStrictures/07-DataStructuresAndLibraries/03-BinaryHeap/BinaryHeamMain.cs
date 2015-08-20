using System;

namespace _03_BinaryHeap
{
    class BinaryHeamMain
    {
        static void Main()
        {
            var b = new BinaryHeap<int>();
            b.Enqueue(9);
            b.Enqueue(5);
            b.Enqueue(11);
            b.Enqueue(7);
            b.Enqueue(3);
            b.Enqueue(14);
            b.Enqueue(7);

            Console.WriteLine(b.Dequeue());
            Console.WriteLine(b.Dequeue());
            Console.WriteLine(b.Dequeue());
            Console.WriteLine(b.Dequeue());
            Console.WriteLine(b.Dequeue());
            Console.WriteLine(b.Dequeue());
            Console.WriteLine(b.Dequeue());

            Console.WriteLine(b.Count);
        }
    }
}
