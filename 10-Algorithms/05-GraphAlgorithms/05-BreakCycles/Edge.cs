using System;

public class Edge : IComparable<Edge>
{
    public string Start { get; set; }
    public string End { get; set; }
    public int CompareTo(Edge other)
    {
        int compareTo = this.Start.CompareTo(other.Start);
        if (compareTo == 0)
        {
            compareTo = this.End.CompareTo(other.End);
        }
        return compareTo;
    }

    public override bool Equals(object other)
    {
        var toCompareWith = other as Edge;
        if (toCompareWith == null)
            return false;
        return this.Start == toCompareWith.Start && this.End == toCompareWith.End;
    }
}

