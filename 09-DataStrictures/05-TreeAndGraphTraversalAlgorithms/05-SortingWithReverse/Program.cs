﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_SortingWithReverse
{
    class Program
    {
        private class Sequence
        {
            public int[] Value { get; set; }
            public Sequence Previous { get; set; }

            public Sequence(int[] value, Sequence previous)
            {
                this.Value = value;
                this.Previous = previous;
            }
        }

        private static Queue<Sequence> canditatesQueue = new Queue<Sequence>();
        private static Sequence sortedSequence = null;
        private static HashSet<int> uniqueSet = new HashSet<int>();
        private static int reverseFactor;
        static bool found = false;
  
        static void Main()
        {
            int count = int.Parse(Console.ReadLine());
            int[] initialSequence = Console.ReadLine().Split(' ').Select(s => int.Parse(s)).ToArray();
            reverseFactor = int.Parse(Console.ReadLine());
            canditatesQueue.Enqueue(new Sequence(initialSequence, null));
            Console.WriteLine();

            if (!IsSorted(initialSequence))
            {
                while (canditatesQueue.Count > 0)
                {
                    if (found)
                    {
                        break;
                    }
                    GenerateAllSequencesWithSingleReverse(canditatesQueue.Peek());
                    uniqueSet.Add(GetHashCode(canditatesQueue.Dequeue().Value));
                }
                PrintResult(sortedSequence);
            }
            else
            {
                Console.WriteLine(0);
            }
        }

        private static void PrintResult(Sequence sortedSequence)
        {
            int operations = -1;
            var path = new List<String>();
            while (sortedSequence != null)
            {
                operations++;
                path.Add(string.Join(" ", sortedSequence.Value));
                sortedSequence = sortedSequence.Previous;
            }
            Console.WriteLine(operations);
            Console.WriteLine();
            Console.WriteLine(string.Join(" -> ", path.ToArray().Reverse()));
        }

        private static void GenerateAllSequencesWithSingleReverse(Sequence sequence)
        {
            for (int i = 0; i < sequence.Value.Length - reverseFactor + 1; i++)
            {
                int[] candidate = ReverseSequence(i, sequence.Value);
                //Console.WriteLine(string.Join(", ", candidate));
                if (IsSorted(candidate) || IsSorted(canditatesQueue.Peek().Value))
                {
                    sortedSequence = new Sequence(candidate, canditatesQueue.Peek());
                    found = true;
                    return;
                }
                int key = GetHashCode(candidate);
                if (!uniqueSet.Contains(key))
                {
                    uniqueSet.Add(key);
                    canditatesQueue.Enqueue(new Sequence(candidate, canditatesQueue.Peek()));
                }
            }
        }

        private static bool IsSorted(int[] sequence)
        {
            for (int i = 1; i < sequence.Length; i++)
            {
                if (sequence[i] < sequence[i - 1])
                {
                    return false;
                }
            }
            return true;
        }

        private static int[] ReverseSequence(int start, int[] sequence)
        {
            int[] reversed = new int[sequence.Length];
            Array.Copy(sequence, reversed, sequence.Length);
            int[] temp = new int[reverseFactor];
            Array.Copy(sequence, start, temp, 0, reverseFactor);
            Array.Reverse(temp);
            Array.Copy(temp, 0, reversed, start, reverseFactor);

            return reversed;
        }

        private static int GetHashCode(int[] arr)
        {
            int pow = 1;
            int hashCode = 0;
            foreach (var num in arr)
            {
                hashCode += pow * num;
                pow *= 10;
            }
            return hashCode;
        }
    }
}
