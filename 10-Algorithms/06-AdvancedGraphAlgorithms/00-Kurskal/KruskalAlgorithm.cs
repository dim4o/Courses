namespace Kurskal
{
    using System;
    using System.Collections.Generic;

    public class KruskalAlgorithm
    {
        public static List<Edge> Kruskal(int numberOfVertices, List<Edge> edges)
        {
            edges.Sort();
            // Initialize parents
            var parent = new int[numberOfVertices];
            for (int i = 0; i < parent.Length; i++)
            {
                parent[i] = i;
            }

            var spanningTree = new List<Edge>();
            foreach (var edge in edges)
            {
                int rootStartNode = FindRoot(edge.StartNode, parent);
                int rootEndNode = FindRoot(edge.EndNode, parent);
                if (rootStartNode != rootEndNode)
                {
                    spanningTree.Add(edge);
                    parent[rootEndNode] = rootStartNode;
                }
            }

            return spanningTree;
        }

        private static int FindRoot(int node, int[] parent)
        {
            if (parent[node] == node)
            {
                return node;
            }
            parent[node] = FindRoot(parent[node], parent);
            return parent[node];
        }
        //private static int FindRoot(int node, int[] parent)
        //{
        //    // Find the root parent for the node
        //    int root = node;
        //    while (parent[root] != root)
        //    {
        //        root = parent[root];
        //    }

        //    // Optimize(compress) path from ndoe to root
        //    while (node != root)
        //    {
        //        var oldParentNode = parent[node];
        //        parent[node] = root;
        //        node = oldParentNode;
        //    }
        //    return root;
        //}
    }
}
