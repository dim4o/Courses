using System;

namespace _03_CollectionОfProducts
{
    public class Product : IComparable<Product>
    {
        public string Id { get; set; }

        public string Title { get; set; }

        public string Supplier { get; set; }

        public decimal Price { get; set; }

        public int CompareTo(Product other)
        {
            return this.Id.CompareTo(other.Id);
        }
    }
}
