using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Markup;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace _05_SumWithLimitedAmountOfCoins.Tests
{
    [TestClass]
    public class SumWithLimitedAmountOfCoinsTests
    {
        [TestMethod]
        public void TestWith_sum_6_and_coins_1_2_2_3_3_4_6()
        {
            List<int> coins = new List<int>{1, 2, 2, 3, 3, 4, 6};
            int targetSum = 6;
            int[,] values = new int[targetSum + 1, targetSum + 1];

            int count = SumWithLimitedAmountOfCoins.GetCount(coins, targetSum, coins.Count - 1, values);

            Assert.AreEqual(4, count);
        }

        [TestMethod]
        public void TestWith_sum_5_and_coins_1_2_2_5()
        {
            List<int> coins = new List<int> { 1, 2, 2, 5 };
            int targetSum = 5;
            int[,] values = new int[targetSum + 1, targetSum + 1];

            int count = SumWithLimitedAmountOfCoins.GetCount(coins, targetSum, coins.Count - 1, values);

            Assert.AreEqual(2, count);
        }

        [TestMethod]
        public void TestWith_sum_13_and_coins_1_2_2_5_5_10()
        {
            List<int> coins = new List<int> { 1, 2, 2, 5, 5, 10 };
            int targetSum = 13;
            int[,] values = new int[targetSum + 1, targetSum + 1];

            int count = SumWithLimitedAmountOfCoins.GetCount(coins, targetSum, coins.Count - 1, values);

            Assert.AreEqual(2, count);
        }

        [TestMethod]
        public void TestWith_sum_100_and_coins_50_20_20_20_20_20_10()
        {
            List<int> coins = new List<int> { 50, 20, 20, 20, 20, 20, 10 };
            int targetSum = 100;
            int[,] values = new int[targetSum + 1, targetSum + 1];

            int count = SumWithLimitedAmountOfCoins.GetCount(coins, targetSum, coins.Count - 1, values);

            Assert.AreEqual(2, count);
        }
    }
}
