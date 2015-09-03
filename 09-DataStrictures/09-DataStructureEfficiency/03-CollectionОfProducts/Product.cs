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
            if (this.Id== other.Id)
            {
                return 0;
            }
            return this.Id.CompareTo(other.Id);
        }

        public override bool Equals(object obj)
        {
            var item = obj as Product;

            if (item == null)
            {
                return false;
            }

            return this.Id.Equals(item.Id);
        }

        public override int GetHashCode()
        {
            return this.Id.GetHashCode();
        }
    }
}
