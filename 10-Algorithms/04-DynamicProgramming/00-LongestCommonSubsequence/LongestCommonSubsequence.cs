using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _00_LongestCommonSubsequence
{
    public class LongestCommonSubsequence
    {
        public static void Main()
        {
            var firstStr = Console.ReadLine(); // "tree";
            var secondStr = Console.ReadLine();  // "team";

            var lcs = FindLongestCommonSubsequence(firstStr, secondStr);

            Console.WriteLine("Longest common subsequence:");
            Console.WriteLine("  first  = {0}", firstStr);
            Console.WriteLine("  second = {0}", secondStr);
            Console.WriteLine("  lcs    = {0}", lcs);
        }

        public static string FindLongestCommonSubsequence(string firstStr, string secondStr)
        {
            int firstLen = firstStr.Length + 1;
            int secondLen = secondStr.Length + 1;
            var lcs = new int[firstLen, secondLen];

            for (int row = 1; row < firstLen; row++)
            {
                for (int col = 1; col < secondLen; col++)
                {
                    if (firstStr[row - 1] == secondStr[col - 1])
                    {
                        // LCS = LCS(sell to the left and up) + 1
                        lcs[row, col] = lcs[row - 1, col - 1] + 1;
                    }
                    else
                    {
                        // LCS = max(LCS(cell above), LCS(cell to the left))
                        lcs[row, col] = Math.Max(lcs[row - 1, col], lcs[row, col - 1]);
                    }
                }
            }

            return RetrieveLCS(firstStr, secondStr, lcs);
        }

        private static string RetrieveLCS(string firstStr, string secondStr, int[,] lcs)
        {
            List<char> sequence = new List<char>();

            int row = firstStr.Length ;
            int col = secondStr.Length;

            while (row > 0 && col > 0)
            {
                if (firstStr[row - 1] == secondStr[col - 1])
                {
                    // Add character to the list and move up and to the left
                    sequence.Add(firstStr[row - 1]);
                    row--;
                    col--;
                }
                else if (lcs[row, col] == lcs[row - 1, col])
                {
                    // Move up
                    row--;
                }
                else
                {
                    // Move to the left
                    col--;
                }
            }
            sequence.Reverse();

            return new string(sequence.ToArray());
        }
    }
}
