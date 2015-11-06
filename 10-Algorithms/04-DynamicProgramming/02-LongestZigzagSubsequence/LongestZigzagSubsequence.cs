using System;
using System.Collections.Generic;
using System.Linq;

namespace _02_LongestZigzagSubsequence
{
    public static class LongestZigzagSubsequence
    {
        static void Main()
        {
            string input = Console.ReadLine();
            int[] arr = input.Split(',').Select(s => int.Parse(s)).ToArray();  
  
            Console.WriteLine(string.Join(" ", GetLongestZigZag(arr)));
        }

        public static int[] GetLongestZigZag(int[] sequence)
        {
            int n = sequence.Length;
            int[,] help = new int[n, 2];
            int[] prevPath = new int[sequence.Length];
            help[0, 0] = help[0, 1] = 1;
            int bestLength = 1;
            int bestIndex = 0;

            for (int currIndex = 1; currIndex < n; currIndex++)
            {
                int value = 0;
                for (int prevIndex = 0; prevIndex < currIndex; prevIndex++)
                {
                    if (sequence[prevIndex] < sequence[currIndex] && 
                        help[prevIndex, 1] + 1 > help[currIndex, 0])
                    {
                        help[currIndex, 0] = help[prevIndex, 1] + 1;
                        value = prevIndex;
                    }
                    if (sequence[prevIndex] > sequence[currIndex] &&
                      help[prevIndex, 0] + 1 > help[currIndex, 1])
                    {
                        help[currIndex, 1] = help[prevIndex, 0] + 1;
                        value = prevIndex;
                    }

                    int posibleBest = Math.Max(bestLength, Math.Max(help[currIndex, 0], help[currIndex, 1]));

                    if (posibleBest >= bestLength)
                    {
                        prevPath[currIndex] = value; 
                        if (posibleBest > bestLength)
                        {
                            bestIndex = currIndex;
                        }
                    } 
                    bestLength = posibleBest;
                }
            }

            return RestorePath(prevPath, sequence, bestIndex);
        }

        private static int[] RestorePath(int[] prevPath, int[] sequence, int endIndex)
        {
            var result = new Stack<int>();
            while (endIndex > 0)
            {
                result.Push(sequence[endIndex]);
                endIndex = prevPath[endIndex];
            }
            result.Push(sequence[0]);
            return result.ToArray();
        }
    }
}
