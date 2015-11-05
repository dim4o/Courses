namespace SumOfCoins
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class SumOfCoins
    {
        public static void Main()
        {
            var availableCoins = new[] { 1, 2, 5, 10, 20, 50 };
            var targetSum = 923;

            var selectedCoins = ChooseCoins(availableCoins, targetSum);

            Console.WriteLine("Number of coins to take: {0}", selectedCoins.Values.Sum());
            foreach (var selectedCoin in selectedCoins)
            {
                Console.WriteLine("{0} coin(s) with value {1}", selectedCoin.Value, selectedCoin.Key);
            }
        }

        public static Dictionary<int, int> ChooseCoins(IList<int> coins, int targetSum)
        {
            var sortedCoins = coins.OrderByDescending(c => c).ToList();
            var result = new Dictionary<int, int>();
            int index = 0;
            while (targetSum > 0 && index < sortedCoins.Count)
            {
                if (targetSum >= sortedCoins[index])
                {
                    int counsCount = targetSum / sortedCoins[index];
                    targetSum = targetSum % sortedCoins[index];
                    result.Add(sortedCoins[index], counsCount);
                }
                
                index++;
            }
            if (targetSum > 0)
            {
                throw new InvalidOperationException(
                    "Gready algorithm cannot produce desired sum with specified coins.");
            }
            return result;
        }
    }
}