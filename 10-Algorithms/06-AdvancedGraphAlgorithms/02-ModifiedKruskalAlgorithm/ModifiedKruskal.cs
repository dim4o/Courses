using System.Collections.Generic;

namespace ModifiedKruskalAlgorithm
{
    public class ModifiedKruskal
    {
        public static List<Edge> Kruskal(int numberOfVertices, List<Edge> edges)
        {
            edges.Sort();
            var nodes = new Node[numberOfVertices];
            for (int i = 0; i < nodes.Length; i++)
            {
                nodes[i] = new Node(i);
            }

            var spanningTree = new List<Edge>();
            foreach (var edge in edges)
            {
                Node firstNode = nodes[edge.StartNode];
                Node secondNode =  nodes[edge.EndNode];
                
                if (firstNode.Parent.Value != secondNode.Parent.Value)
                {
                    spanningTree.Add(edge);
                    if (IsRoot(firstNode) && !IsRoot(secondNode))
                    {
                        MergeTrees(firstNode, secondNode);
                    }
                    else if (!IsRoot(firstNode) && IsRoot(secondNode))
                    {
                        MergeTrees(secondNode, firstNode);
                    }
                    else if (IsRoot(firstNode) && IsRoot(secondNode))
                    {
                        MergeTrees(secondNode.Parent, firstNode);
                    }
                }
            }

            return spanningTree;
        }

        private static bool IsRoot(Node node)
        {
            return node.Value == node.Parent.Value;
        }

        private static void MergeTrees(Node firstNode, Node secondNode)
        {
            firstNode.Parent = secondNode.Parent;
            secondNode.Parent.Children.Add(firstNode);

            foreach (var child in firstNode.Children)
            {
                child.Parent = secondNode.Parent;
                secondNode.Parent.Children.Add(child);
            }
            firstNode.Children = new List<Node>();
        }
    }
}
