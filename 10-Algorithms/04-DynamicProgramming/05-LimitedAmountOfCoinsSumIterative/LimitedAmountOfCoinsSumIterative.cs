using System;
using System.Collections.Generic;
using System.Linq;

namespace _05_LimitedAmountOfCoinsSumIterative
{
    class LimitedAmountOfCoinsSumIterative
    {
        static void Main()
        {
            Console.Write("S = ");
            int targetSum = int.Parse(Console.ReadLine());
            Console.Write("Coins = ");
            string input = Console.ReadLine();
            List<int> coins = input.Split(new char[] { '{', '}', ',' }, StringSplitOptions.RemoveEmptyEntries)
                .Select(int.Parse).ToList();
            int[,] memo = new int[coins.Count, targetSum  +1];
            coins.Sort();

            if (coins[0] < targetSum)
            {
                memo[0, coins[0]] = 1;
            }
            for (int row = 1; row < memo.GetLength(0); row++)
            {
                for (int col = 1; col < memo.GetLength(1); col++)
                {
                    if (coins[row] > col)
                    {
                        memo[row, col] = memo[row - 1, col];
                        continue;
                    }
                    if (coins[row] == col)
                    {
                        memo[row, col] = 1;
                    }
                    int prevNonEqualCoin = row;
                    while (prevNonEqualCoin >= 0 && coins[row] == coins[prevNonEqualCoin])
                    {
                        prevNonEqualCoin--;
                    }
                    memo[row, col] += memo[row - 1, col - coins[row]] + memo[prevNonEqualCoin, col];
                }
            }

            Console.WriteLine(memo[coins.Count-1, targetSum]);
        }
    }
}
