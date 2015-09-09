using System;

namespace _03_CollectionОfProducts
{
    static class Program
    {
        static void Main()
        {
            // For more tests look at 03-CollectionОfProducts.Tests project !
            var products = new CollectionOfProducts();

            products.Add("01", "Product1", "Supplier1", 1300);
            products.Add("02", "Product1", "Supplier1", 1200);
            products.Add("03", "Product1", "Supplier1", 7800);
            products.Add("04", "Product1", "Supplier1", 4000);
            products.Add("05", "Product1", "Supplier1", 1800);
            products.Add("06", "Product1", "Supplier1", 1100);
            products.Add("3", "FirstProduct", "Lida", 4);
            products.Add("1", "SecondProduct", "Lida", 5);
            products.Add("1", "FirstProduct", "Pepsi", 500);
            //Console.WriteLine(products.Count);
            
            Console.WriteLine("---------");
            var productsByTitle1 = products.FindProductsByTitle("Product1");
            foreach (var currentProduct in productsByTitle1)
            {
                Console.WriteLine("{0} - {1}", currentProduct.Id, currentProduct.Title);
            }
            Console.WriteLine("---------");

            Console.WriteLine("---------");
            var productsByTitle2 = products.FindProductsByTitle("SecondProduct");
            Console.WriteLine("empry" + productsByTitle2);
            Console.WriteLine("---------");
        }
    }
}
