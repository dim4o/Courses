using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace _04_SumwithUnlimitedAmountOfCoins.Tests
{
    [TestClass]
    public class SumwithUnlimitedAmountOfCoinsTests
    {
        [TestMethod]
        public void TestWith_sum_6_and_coins_1_2_3_4_6()
        {
            int[] coins = new int[] {1, 2, 3 ,4 ,6};
            int targetSum = 6;

            int count = SumWithUnlimitedAmountOfCoins.GetCount(targetSum, coins);

            Assert.AreEqual(10, count);
        }

        [TestMethod]
        public void TestWith_sum_6_and_coins_2_3_4_6()
        {
            int[] coins = new int[] { 2, 3, 4, 6 };
            int targetSum = 6;

            int count = SumWithUnlimitedAmountOfCoins.GetCount(targetSum, coins);

            Assert.AreEqual(4, count);
        }

        [TestMethod]
        public void TestWith_sum_5_and_coins_1_2_5()
        {
            int[] coins = new int[] { 1, 2, 5 };
            int targetSum = 5;

            int count = SumWithUnlimitedAmountOfCoins.GetCount(targetSum, coins);

            Assert.AreEqual(4, count);
        }

        [TestMethod]
        public void TestWith_sum_13_and_coins_1_2_5_10()
        {
            int[] coins = new int[] { 1, 2, 5, 10 };
            int targetSum = 13;

            int count = SumWithUnlimitedAmountOfCoins.GetCount(targetSum, coins);

            Assert.AreEqual(16, count);
        }

        [TestMethod]
        public void TestWith_sum_100_and_coins_1_2_5_10_20_50_100()
        {
            int[] coins = new int[] { 1, 2, 5, 10, 20, 50, 100 };
            int targetSum = 100;

            int count = SumWithUnlimitedAmountOfCoins.GetCount(targetSum, coins);

            Assert.AreEqual(4563, count);
        }
    }
}
