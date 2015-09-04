using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Wintellect.PowerCollections;

namespace _03_CollectionОfProducts
{
    public class CollectionOfProducts
    {
        private Dictionary<string, Product> productsById = 
            new Dictionary<string, Product>();

        private OrderedDictionary<decimal, Set<Product>> productsByPriceRange =
            new OrderedDictionary<decimal, Set<Product>>(); 

        private Dictionary<string, SortedSet<Product>> productsByTitle = 
            new Dictionary<string, SortedSet<Product>>();

        private Dictionary<Tuple<string, decimal>, SortedSet<Product>> productsByTitleOrSupplierAndPrice =
           new Dictionary<Tuple<string, decimal>, SortedSet<Product>>(); 

        private Dictionary<string, OrderedDictionary<decimal, Set<Product>>>  productsByTitleOrSupplierAndPriceRange =
            new Dictionary<string, OrderedDictionary<decimal, Set<Product>>>();

        public int Count
        {
            get { return this.productsById.Count; }
        }

        public void Add(string id, string title, string supplier, decimal price)
        {
            var product = new Product()
            {
                Id = id, Title = title, Supplier = supplier, Price = price
            };

            if (productsById.ContainsKey(id))
            {
                Remove(id);
            }
            // Add product by id
            productsById.EnsureKeyExists(id);
            productsById[id] = product;
            
            // Add product by title
            productsByTitle.EnsureKeyExists(title);
            productsByTitle[title].Add(product);

            // Add product by title and price
            var titleAndPrice = new Tuple<string, decimal>(title, price);
            productsByTitleOrSupplierAndPrice.EnsureKeyExists(titleAndPrice);
            productsByTitleOrSupplierAndPrice[titleAndPrice].Add(product);

            // Add product by supplier and price
            var supplierAndPrice = new Tuple<string, decimal>(supplier, price);
            productsByTitleOrSupplierAndPrice.EnsureKeyExists(supplierAndPrice);
            productsByTitleOrSupplierAndPrice[supplierAndPrice].Add(product);

            // Add product by price range
            productsByPriceRange.EnsureKeyExists(price);
            productsByPriceRange[price].Add(product);

            // Add product by title and price range
            productsByTitleOrSupplierAndPriceRange.EnsureKeyExists(title);
            productsByTitleOrSupplierAndPriceRange[title].EnsureKeyExists(price);
            productsByTitleOrSupplierAndPriceRange[title][price].Add(product);

            // Add product by supplier and price range
            productsByTitleOrSupplierAndPriceRange.EnsureKeyExists(supplier);
            productsByTitleOrSupplierAndPriceRange[supplier].EnsureKeyExists(price);
            productsByTitleOrSupplierAndPriceRange[supplier][price].Add(product);
        }

        public bool Remove(string id)
        {
            if (!productsById.ContainsKey(id))
            {
                return false;
            }
            var product = productsById[id];

            // Remove product by Id
            productsById.Remove(id);

            // Remove product by Title
            productsByTitle.Remove(product.Title);

            // Remove product by Price Range
            productsByPriceRange[product.Price].Remove(product);

            // Remove product by Title and Price
            var titleAndPrice = new Tuple<string, decimal>(product.Title, product.Price);
            productsByTitleOrSupplierAndPrice[titleAndPrice].Remove(product);

            // Remove product by Supplier and Price
            var supplierAndPrice = new Tuple<string, decimal>(product.Supplier, product.Price);
            productsByTitleOrSupplierAndPrice[supplierAndPrice].Remove(product);

            // Remove product by Title and Price Range
            productsByTitleOrSupplierAndPriceRange[product.Title][product.Price].Remove(product);

            // Remove product by Supplier and Price Range
            productsByTitleOrSupplierAndPriceRange[product.Supplier][product.Price].Remove(product);

            return true;
        }

        public IEnumerable<Product> FindProductsInPriceRange(decimal startPrice, decimal endPrice)
        {
            var productsInRange = productsByPriceRange.Range(startPrice, true, endPrice, true);
            var setOfProducts = new SortedSet<Product>();

            foreach (var products in productsInRange)
            {
                foreach (var product in products.Value)
                {
                    setOfProducts.Add(product);
                }
            }

            return setOfProducts;
        }

        public IEnumerable<Product> FindProductsByTitle(string title)
        {
            if (!productsByTitle.ContainsKey(title))
            {
                return null;
            }

            return productsByTitle[title];
        }

        public IEnumerable<Product> FindProductsByTitleAndPrice(string title, decimal price)
        {
            var titleAndPrice = new Tuple<string, decimal>(title, price);
            if (!productsByTitleOrSupplierAndPrice.ContainsKey(titleAndPrice))
            {
                return null;
            }

            return productsByTitleOrSupplierAndPrice[titleAndPrice];
        }

        public IEnumerable<Product> FindProductByTitleAndPriceRange(string title, decimal startPrice, decimal endPrice)
        {
            var result = new SortedSet<Product>();
            if (!productsByTitleOrSupplierAndPriceRange.ContainsKey(title))
            {
                return null;
            }
            var productsInRangeByTitle = productsByTitleOrSupplierAndPriceRange[title].Range(startPrice, true, endPrice, true);

            foreach (var productsInRange in productsInRangeByTitle)
            {
                foreach (var product in productsInRange.Value)
                {
                    result.Add(product);
                }
            }

            return result;
        }

        public IEnumerable<Product> FindProductBySupplierAndPriceRange(string supplier, decimal startPrice, decimal endPrice)
        {
            return FindProductByTitleAndPriceRange(supplier, startPrice, endPrice);
        }

        public IEnumerable<Product> FindProductsBySupplierAndPrice(string supplier, decimal price)
        {
            return FindProductsByTitleAndPrice(supplier, price);
        }

        public IEnumerable<Product> ToList()
        {
            return this.productsById.Values.ToList();
        }

        public Product this[string id]
        {
            get
            {
                if (!this.productsById.ContainsKey(id))
                {
                    return null;
                }
                return this.productsById[id];
            }
        }
    }
}
