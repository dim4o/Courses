using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;

namespace _00_LongestIncreasingSubsequence
{
    public class LongestIncreasingSubsequence
    {
        public static void Main()
        {
            //var sequence = new[] { 3, 14, 5, 12, 15, 7, 8, 9, 11, 10, 1 }; // 6
            //var sequence = new[] { 4, 1, 3, 2, 0, 8 }; // 3
            //var sequence = new[] { 7, 3, 5, 8, -1, 6, 7 }; // 4
            //var sequence = new[] { 11, 12, 13, 3, 14, 4, 15, 5, 6, 7, 8, 7, 16, 9, 8 }; // 7
            //var sequence = new[] { 3, 14, 5, 12, 15, 7, 8, 9, 11, 10, 1 }; // 6
            //var sequence = new[] { 30, 1, 20, 2, 3, -1 };
            //var sequence = new int[0] {};
            //var sequence = new[] { 24, 5, 31, 3, 3, 342, 51, 114, 52, 55, 56, 58 }; // 6
            var sequence = Console.ReadLine()
                .Split()
                .Select(int.Parse)
                .ToArray();

            var longestSeq = FindLongestIncreasingSubsequence(sequence);
            Console.WriteLine("Longest increasing subsequence (LIS)");
            Console.WriteLine("  Length: {0}", longestSeq.Length);
            Console.WriteLine("  Sequence: [{0}]", string.Join(", ", longestSeq));
        }

        public static int[] FindLongestIncreasingSubsequence(int[] sequence)
        {
            int[] help = new int[sequence.Length];
            int[] prevPath = new int[sequence.Length];
            int globalMax = 0;
            int endPosition = 0;

            for (int i = 0; i < help.Length; i++)
            {
                int maxLen = 1;
                int value = -1;
                for (int prev = 0; prev < i; prev++)
                {
                    if (sequence[prev] < sequence[i] && help[prev] > maxLen)
                    {
                        maxLen = help[prev];
                        value = prev;
                    }
                }
                prevPath[i] = value;
                help[i] = maxLen + 1;

                if (help[i] > globalMax)
                {
                    globalMax = help[i];
                    endPosition = i;
                }
            }

            return RestorePath(prevPath, sequence, endPosition);
        }

        private static int[] RestorePath(int[] prevPath, int[] sequence, int endPosition)
        {
            var result = new Stack<int>();

            while (prevPath.Length > 0 && endPosition != -1)
            {
                result.Push(sequence[endPosition]);
                endPosition = prevPath[endPosition];
            }

            return result.ToArray();
        }
    }
}
