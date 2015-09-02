using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using _03_CollectionОfProducts;

namespace _03_CollectionOfProducts.Tests
{
    [TestClass]
    public class CollectionOfProductsTests
    {
        //[TestInitialize]
        private CollectionOfProducts InitializeCollectionOfProducts()
        {
            var product01 = new Product()
            {
                Id = "11aa33",
                Title = "Laptop Lenovo ThinkPad",
                Price = 1800,
                Supplier = "SuperTech"
            };
            var product02 = new Product()
            {
                Id = "bb33cc",
                Title = "HP ProBook 450G1",
                Price = 1500,
                Supplier = "MegaTech"
            };
            var product03 = new Product()
            {
                Id = "dd00gg",
                Title = "Nexus 5",
                Price = 550,
                Supplier = "GigaTron"
            };
            var product04 = new Product()
            {
                Id = "22ffbb",
                Title = "Nexus 4",
                Price = 450,
                Supplier = "GigaTron"
            };

            var product05 = new Product()
            {
                Id = "99ffbb",
                Title = "Smasung Galaxy S6",
                Price = 550,
                Supplier = "GigaTron"
            };

            var product06 = new Product()
            {
                Id = "zzss99",
                Title = "Smasung Galaxy S4",
                Price = 450,
                Supplier = "MegaBit"
            };

            var product07 = new Product()
            {
                Id = "gg5588",
                Title = "Smasung Galaxy S4",
                Price = 450,
                Supplier = "MegaBit"
            };

            var product08 = new Product()
            {
                Id = "yyAA11",
                Title = "Smasung Galaxy S4",
                Price = 450,
                Supplier = "GigaTron"
            };
            var product09 = new Product()
            {
                Id = "01dd77",
                Title = "Laptop Lenovo ThinkPad",
                Price = 600,
                Supplier = "SecondHandTech"
            };

            var product10 = new Product()
            {
                Id = "00dd77",
                Title = "Laptop Lenovo ThinkPad",
                Price = 600,
                Supplier = "SecondHandTech"
            };
            
            var products = new CollectionOfProducts();
            var productList =  new List<Product>()
            {
                product01,
                product02,
                product03,
                product04,
                product05,
                product06,
                product07,
                product08,
                product09,
                product10
            };
            foreach (var product in productList)
            {
                products.Add(product.Id, product.Title, product.Supplier, product.Price);
            }

            return products;
        }

        [TestMethod]
        public void Add_Product_With_Existing_Id_Should_Replace_the_OldProduct()
        {
            var products = InitializeCollectionOfProducts();
            var newProduct = new Product()
            {
                Id = "11aa33",
                Title = "Laptop Lenovo ThinkPad",
                Price = 3600,
                Supplier = "SuperTech"
            };
            products.Add(newProduct.Id, newProduct.Title, newProduct.Supplier, newProduct.Price);
            
            Assert.AreEqual(10, products.ToList().Count());
        }

        [TestMethod]
        public void Test_Find_Products_by_Title()
        {
            var products = InitializeCollectionOfProducts();

            var productsByTitle1 = products.FindProductsByTitle("Smasung Galaxy S4").ToList();
            Assert.AreEqual(3, productsByTitle1.Count);
            Assert.AreEqual("gg5588", productsByTitle1[0].Id);
            Assert.AreEqual("yyAA11", productsByTitle1[1].Id);
            Assert.AreEqual("zzss99", productsByTitle1[2].Id);

            var productsByTitle2 = products.FindProductsByTitle("Nexus 4").ToList();
            Assert.AreEqual(1, productsByTitle2.Count);
            Assert.AreEqual("22ffbb", productsByTitle2[0].Id);

            var productsByTitle3 = products.FindProductsByTitle("Not existiong product");
            Assert.AreEqual(null, productsByTitle3);
        }

        [TestMethod]
        public void Test_Find_Products_by_Title_and_Price()
        {
            var products = InitializeCollectionOfProducts();

            var productsByTitleAndPrice1 = products
                .FindProductsByTitleAndPrice("Smasung Galaxy S4", 450).ToList();
            Assert.AreEqual(3, productsByTitleAndPrice1.Count);
            Assert.AreEqual("gg5588", productsByTitleAndPrice1[0].Id);
            Assert.AreEqual("yyAA11", productsByTitleAndPrice1[1].Id);
            Assert.AreEqual("zzss99", productsByTitleAndPrice1[2].Id);

            var productsByTitleAndPrice2 = products
                .FindProductsByTitleAndPrice("Laptop Lenovo ThinkPad", 1800).ToList();
            Assert.AreEqual(1, productsByTitleAndPrice2.Count);
            Assert.AreEqual("11aa33", productsByTitleAndPrice2[0].Id);

            var productsByTitleAndPrice3 = products
                .FindProductsByTitleAndPrice("Laptop Lenovo ThinkPad", 1100);
            Assert.AreEqual(null, productsByTitleAndPrice3);
        }

        [TestMethod]
        public void Test_Find_Product_by_Price_Range()
        {
            var products = InitializeCollectionOfProducts();

            var productsByPriceRange = products
                .FindProductsInPriceRange(450, 550).ToList();
            Assert.AreEqual(6, productsByPriceRange.Count);
            Assert.AreEqual("22ffbb", productsByPriceRange[0].Id);
            Assert.AreEqual("99ffbb", productsByPriceRange[1].Id);
            Assert.AreEqual("dd00gg", productsByPriceRange[2].Id);
            Assert.AreEqual("gg5588", productsByPriceRange[3].Id);
            Assert.AreEqual("yyAA11", productsByPriceRange[4].Id);
            Assert.AreEqual("zzss99", productsByPriceRange[5].Id);
        }

        [TestMethod]
        public void Test_Find_Product_by_Title_and_Price_Range()
        {
            var products = InitializeCollectionOfProducts();

            var productsByTitleAndPriceRange = products
                .FindProductByTitleAndPriceRange("Laptop Lenovo ThinkPad", 500, 2000).ToList();
            Assert.AreEqual(3, productsByTitleAndPriceRange.Count);
            Assert.AreEqual("00dd77", productsByTitleAndPriceRange[0].Id);
            Assert.AreEqual("01dd77", productsByTitleAndPriceRange[1].Id);
            Assert.AreEqual("11aa33", productsByTitleAndPriceRange[2].Id);

        }

        [TestMethod]
        public void Test_Find_Products_by_Supplier_and_Price()
        {
            var products = InitializeCollectionOfProducts();

            var productsbySupplierAndPrice1 = products
                .FindProductsBySupplierAndPrice("MegaBit", 450).ToList();

            Assert.AreEqual(2, productsbySupplierAndPrice1.Count);
            Assert.AreEqual("gg5588", productsbySupplierAndPrice1[0].Id);
            Assert.AreEqual("zzss99", productsbySupplierAndPrice1[1].Id);

            var productsbySupplierAndPrice2 = products
                .FindProductsBySupplierAndPrice("SecondHandTech", 600).ToList();

            Assert.AreEqual(2, productsbySupplierAndPrice2.Count);
            Assert.AreEqual("00dd77", productsbySupplierAndPrice2[0].Id);
            Assert.AreEqual("01dd77", productsbySupplierAndPrice2[1].Id);

            var productsbySupplierAndPrice3 = products
                .FindProductsBySupplierAndPrice("SecondHandTech", 123);
            Assert.AreEqual(null, productsbySupplierAndPrice3);
        }

        [TestMethod]
        public void Test_Find_Products_by_Supplier_and_Price_Range()
        {
            var products = InitializeCollectionOfProducts();

            var productsBySupplierAndPriceRange1 = products
                .FindProductBySupplierAndPriceRange("GigaTron", 400, 600).ToList();

            Assert.AreEqual(4, productsBySupplierAndPriceRange1.Count);

            var productsBySupplierAndPriceRange2 = products
                .FindProductBySupplierAndPriceRange("GigaTron", 460, 600).ToList();

            Assert.AreEqual(2, productsBySupplierAndPriceRange2.Count);
            Assert.AreEqual("99ffbb", productsBySupplierAndPriceRange2[0].Id);
            Assert.AreEqual("dd00gg", productsBySupplierAndPriceRange2[1].Id);

            var productsBySupplierAndPriceRange3 = products
                .FindProductBySupplierAndPriceRange("SuperTech", 1800, 2000).ToList();

            Assert.AreEqual(1, productsBySupplierAndPriceRange3.Count);
            Assert.AreEqual("11aa33", productsBySupplierAndPriceRange3[0].Id);
        }

        /// <summary>
        /// Tests for Remove method
        /// </summary>
        [TestMethod]
        public void Test_Count_After_Remove_Product_by_Id()
        {
            var products = InitializeCollectionOfProducts();

            products.Remove("gg5588");

            Assert.AreEqual(9, products.Count);
        }

        [TestMethod]
        public void Test_Remove_NonExisting_Product()
        {
            var products = InitializeCollectionOfProducts();

            bool removed = products.Remove("Non Existing Id");

            Assert.AreEqual(false, removed);
        }

        [TestMethod]
        public void Test_Count_After_Remove_And_Add_Product()
        {
            var products = InitializeCollectionOfProducts();

            products.Remove("11aa33");
            products.Add("someId", "title", "supplier", 1000);

            Assert.AreEqual(10, products.Count);
        }

        [TestMethod]
        public void Test_FindByPriceRange_After_Remove_Product()
        {
            var products = InitializeCollectionOfProducts();

            products.Remove("gg5588");

            var productsByPriceRange = products
                .FindProductsInPriceRange(400, 500).ToList();
            Assert.AreEqual(3, productsByPriceRange.Count);
            Assert.AreEqual("22ffbb", productsByPriceRange[0].Id);
            Assert.AreEqual("yyAA11", productsByPriceRange[1].Id);
            Assert.AreEqual("zzss99", productsByPriceRange[2].Id);
        }

        [TestMethod]
        public void Test_Find_by_Title_and_Price_Range_After_Remove_Product()
        {
            var products = InitializeCollectionOfProducts();

            products.Remove("gg5588");

            var productsByTitleAndPriceRange1 = products
                .FindProductByTitleAndPriceRange("Smasung Galaxy S4", 400, 500).ToList();
            Assert.AreEqual(2, productsByTitleAndPriceRange1.Count);

            var productsByTitleAndPriceRange2 = products
                .FindProductByTitleAndPriceRange("Laptop Lenovo ThinkPad", 600, 2000).ToList();
            Assert.AreEqual(3, productsByTitleAndPriceRange2.Count);

            products.Remove("11aa33");
            var productsByTitleAndPriceRange3 = products
                .FindProductByTitleAndPriceRange("Laptop Lenovo ThinkPad", 600, 2000).ToList();
            Assert.AreEqual(2, productsByTitleAndPriceRange3.Count);
            Assert.AreEqual("00dd77", productsByTitleAndPriceRange3[0].Id);
            Assert.AreEqual("01dd77", productsByTitleAndPriceRange3[1].Id);
        }
    }
}
