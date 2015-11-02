namespace ModifiedKruskalAlgorithm
{
    using System.Collections.Generic;

    class Node 
    {
        public int Value { get; set; }
        public Node Parent { get; set; }
        public List<Node> Children { get; set; }

        public Node(int value)
        {
            this.Value = value;
            this.Parent = this;
            this.Children = new List<Node>();
        }
    }
}
