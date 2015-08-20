using System;

public class Product : IComparable<Product>
{
    public string Name { get; set; }
    public int Price { get; set; }

    public Product(string name, int price)
    {
        this.Name = name;
        this.Price = price;
    }
    public int CompareTo(Product other)
    {
        if (this.Price == other.Price && Name != null)
        {
            return this.Name.CompareTo(other.Name);
        }
        return this.Price.CompareTo(other.Price);
    }
}
