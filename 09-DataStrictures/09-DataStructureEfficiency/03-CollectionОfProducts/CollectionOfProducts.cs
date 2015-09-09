using System;
using System.Collections.Generic;
using System.Linq;
using Wintellect.PowerCollections;

namespace _03_CollectionОfProducts
{
    public class CollectionOfProducts
    {
        private readonly Dictionary<string, Product> _productsById = 
            new Dictionary<string, Product>();

        private readonly OrderedDictionary<decimal, Set<Product>> _productsByPriceRange =
            new OrderedDictionary<decimal, Set<Product>>(); 

        private readonly Dictionary<string, SortedSet<Product>> _productsByTitle = 
            new Dictionary<string, SortedSet<Product>>();

        private readonly Dictionary<Tuple<string, decimal>, SortedSet<Product>> _productsByTitleAndPrice =
          new Dictionary<Tuple<string, decimal>, SortedSet<Product>>();

        private readonly Dictionary<Tuple<string, decimal>, SortedSet<Product>> _productsBySupplierAndPrice =
          new Dictionary<Tuple<string, decimal>, SortedSet<Product>>();

        private readonly Dictionary<string, OrderedDictionary<decimal, HashSet<Product>>> _productsByTitleAndPriceRange =
            new Dictionary<string, OrderedDictionary<decimal, HashSet<Product>>>();

        private readonly Dictionary<string, OrderedDictionary<decimal, HashSet<Product>>> _productsBySupplierAndPriceRange =
            new Dictionary<string, OrderedDictionary<decimal, HashSet<Product>>>();

        public int Count
        {
            get { return this._productsById.Count; }
        }

        public void Add(string id, string title, string supplier, decimal price)
        {
            var product = new Product()
            {
                Id = id, Title = title, Supplier = supplier, Price = price
            };

            if (_productsById.ContainsKey(id))
            {
                Remove(id);
            }
            // Add product by id
            _productsById.EnsureKeyExists(id);
            _productsById[id] = product;
            
            // Add product by title
            _productsByTitle.EnsureKeyExists(title);
            _productsByTitle[title].Add(product);

            // Add product by title and price
            var titleAndPrice = new Tuple<string, decimal>(title, price);
            _productsByTitleAndPrice.EnsureKeyExists(titleAndPrice);
            _productsByTitleAndPrice[titleAndPrice].Add(product);

            // Add product by supplier and price
            var supplierAndPrice = new Tuple<string, decimal>(supplier, price);
            _productsBySupplierAndPrice.EnsureKeyExists(supplierAndPrice);
            _productsBySupplierAndPrice[supplierAndPrice].Add(product);

            // Add product by price range
            _productsByPriceRange.EnsureKeyExists(price);
            _productsByPriceRange[price].Add(product);

            // Add product by title and price range
            _productsByTitleAndPriceRange.EnsureKeyExists(title);
            _productsByTitleAndPriceRange[title].EnsureKeyExists(price);
            _productsByTitleAndPriceRange[title][price].Add(product);

            // Add product by supplier and price range
            _productsBySupplierAndPriceRange.EnsureKeyExists(supplier);
            _productsBySupplierAndPriceRange[supplier].EnsureKeyExists(price);
            _productsBySupplierAndPriceRange[supplier][price].Add(product);
        }

        public bool Remove(string id)
        {
            if (!_productsById.ContainsKey(id))
            {
                return false;
            }
            var product = _productsById[id];

            // Remove product by Id
            _productsById.Remove(id);

            // Remove product by Title
            //_productsByTitle.Remove(product.Title);
            _productsByTitle[product.Title].Remove(product);

            // Remove product by Price Range
            _productsByPriceRange[product.Price].Remove(product);

            // Remove product by Title and Price
            var titleAndPrice = new Tuple<string, decimal>(product.Title, product.Price);
            _productsByTitleAndPrice[titleAndPrice].Remove(product);

            // Remove product by Supplier and Price
            var supplierAndPrice = new Tuple<string, decimal>(product.Supplier, product.Price);
            _productsBySupplierAndPrice[supplierAndPrice].Remove(product);

            // Remove product by Title and Price Range
            _productsByTitleAndPriceRange[product.Title][product.Price].Remove(product);

            // Remove product by Supplier and Price Range
            _productsBySupplierAndPriceRange[product.Supplier][product.Price].Remove(product);

            return true;
        }

        public IEnumerable<Product> FindProductsInPriceRange(decimal startPrice, decimal endPrice)
        {
            var productsInRange = _productsByPriceRange.Range(startPrice, true, endPrice, true);
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
            if (!_productsByTitle.ContainsKey(title))
            {
                return null;
            }

            return _productsByTitle[title];
        }

        public IEnumerable<Product> FindProductsByTitleAndPrice(string title, decimal price)
        {
            var titleAndPrice = new Tuple<string, decimal>(title, price);
            if (!_productsByTitleAndPrice.ContainsKey(titleAndPrice))
            {
                return null;
            }

            return _productsByTitleAndPrice[titleAndPrice];
        }

        public IEnumerable<Product> FindProductByTitleAndPriceRange(string title, decimal startPrice, decimal endPrice)
        {
            var result = new SortedSet<Product>();
            if (!_productsByTitleAndPriceRange.ContainsKey(title))
            {
                return null;
            }
            var productsInRangeByTitle = _productsByTitleAndPriceRange[title].Range(startPrice, true, endPrice, true);

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
            var result = new SortedSet<Product>();
            if (!_productsBySupplierAndPriceRange.ContainsKey(supplier))
            {
                return null;
            }
            var productsInRangeBySupplier = _productsBySupplierAndPriceRange[supplier].Range(startPrice, true, endPrice, true);

            foreach (var productsInRange in productsInRangeBySupplier)
            {
                foreach (var product in productsInRange.Value)
                {
                    result.Add(product);
                }
            }

            return result;
        }

        public IEnumerable<Product> FindProductsBySupplierAndPrice(string supplier, decimal price)
        {
            var supplierAndPrice = new Tuple<string, decimal>(supplier, price);
            if (!_productsBySupplierAndPrice.ContainsKey(supplierAndPrice))
            {
                return null;
            }

            return _productsBySupplierAndPrice[supplierAndPrice];
        }

        public IEnumerable<Product> ToList()
        {
            return this._productsById.Values.ToList();
        }

        public Product this[string id]
        {
            get
            {
                if (!this._productsById.ContainsKey(id))
                {
                    return null;
                }
                return this._productsById[id];
            }
        }
    }
}
