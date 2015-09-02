using System;
using System.Collections.Generic;
using System.Linq;

namespace _02_BiDictionary
{
    internal static class BiDictionaryMain
    {
        private static void Main()
        {
            var distances = new BiDictionary<string, string, int>();
            distances.Add("Sofia", "Varna", 443);
            distances.Add("Sofia", "Varna", 468);
            distances.Add("Sofia", "Varna", 490);
            distances.Add("Sofia", "Plovdiv", 145);
            distances.Add("Sofia", "Bourgas", 383);
            distances.Add("Plovdiv", "Bourgas", 253);
            distances.Add("Plovdiv", "Bourgas", 292);

            var distancesFromSofia = distances.FindByKey1("Sofia");
            PrintDistances(distancesFromSofia);

            var distancesToBourgas = distances.FindByKey2("Bourgas");
            PrintDistances(distancesToBourgas);

            var distancesPlovdivBourgas = distances.Find("Plovdiv", "Bourgas");
            PrintDistances(distancesPlovdivBourgas);

            var distancesRousseVarna = distances.Find("Rousse", "Varna");
            PrintDistances(distancesRousseVarna);

            var distancesSofiaVarna = distances.Find("Sofia", "Varna");
            PrintDistances(distancesSofiaVarna);

            Console.WriteLine(distances.Remove("Sofia", "Varna"));

            var distancesFromSofiaAgain = distances.FindByKey1("Sofia");
            PrintDistances(distancesFromSofiaAgain);

            var distancesToVarna = distances.FindByKey2("Varna");
            PrintDistances(distancesToVarna);

            var distancesSofiaVarnaAgain = distances.Find("Sofia", "Varna");
            PrintDistances(distancesSofiaVarnaAgain);

            Console.WriteLine(distances.Remove("Sofia", "Lovech"));
        }

        private static void PrintDistances(IEnumerable<int> distances)
        {
            Console.WriteLine("[" + string.Join(", ", distances) + "]");
        }
    }
}
