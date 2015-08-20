using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Wintellect.PowerCollections;

namespace _02_ProductsInPriceRange
{
    class ProductsInPriceRangeMain
    {
        private static OrderedBag<Product> productsMap = new OrderedBag<Product>();
        private const int MaximumPrice = 500000;
        private const int NumberOfSearches = 10000;
        private static readonly Random Rand = new Random();

        static void Main()
        {
            Console.Write("Initializing products...");
            GenerateProducts(MaximumPrice);
            Console.Write("done\n");
            Console.Write("Generating {0} price searches...", NumberOfSearches);

            var sw = new Stopwatch();
            sw.Start();
            using (System.IO.StreamWriter file = new StreamWriter(@"../../result.txt"))
            {
                for (int i = 0; i < NumberOfSearches; i++)
                {
                    int firstPrice = Rand.Next(MaximumPrice);
                    int secontPrice = Rand.Next(firstPrice, MaximumPrice);
                    file.WriteLine("[{0}, {1}]", firstPrice, secontPrice);
                    var currentRange = productsMap.Range(
                        new Product(null, firstPrice), true,
                        new Product(null, secontPrice), true);
                    if (currentRange.Count == 0)
                    {
                        file.WriteLine("No products in this price range!");
                        continue;
                    }
                    foreach (var product in currentRange.Take(20))
                    {
                        file.WriteLine("{0} - {1}", product.Name, product.Price);
                    }
                    file.WriteLine();
                }
            }
            
            sw.Stop();

            Console.Write("done\n");
            Console.WriteLine("Time: \t{0}", sw.Elapsed);
            Console.WriteLine("You can see the result in \"[CurrentProjectFolder]/result.txt]\"");
        }

        public static void GenerateProducts(int numberOfProducts)
        {
            for (int i = 0; i < numberOfProducts; i++)
            {
                string productName = "product_" + i;
                int productPrice = Rand.Next(MaximumPrice);

                productsMap.Add(new Product(productName, productPrice));
            }
        }
    }
}
