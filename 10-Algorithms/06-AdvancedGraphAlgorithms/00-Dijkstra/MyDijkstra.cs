namespace Dijkstra
{
    using System.Linq;
    using System.Collections.Generic;

    public static class MyDijkstra
    {
        public static List<int> DijkstraAlgorithm(int[,] graph, int sourceNode, int destinationNode)
        {
            // Initialize dist[] array
            int n = graph.GetLength(0);
            int[] dist = new int[n];
            int[] prev = new int[n];
            bool[] used = new bool[n];

            for (int i = 0; i < dist.Length; i++)
            {
                dist[i] = int.MaxValue;
            }
            dist[sourceNode] = 0;

            while (true)
            {
                // Find minNode
                int minNode = 0;
                int minDistance = int.MaxValue;

                for (int node = 0; node < n; node++)
                {
                    if (!used[node] && dist[node] < minDistance)
                    {
                        minDistance = dist[node];
                        minNode = node;
                    }
                }

                if (minDistance == int.MaxValue)
                {
                    break;
                }
                used[minNode] = true;

                // za vsi4ki naslednici na MinNode -> relax
                for (int i = 0; i < n; i++)
                {
                    if (graph[minNode, i] > 0 && graph[minNode, i] + minDistance < dist[i])
                    {
                        dist[i] = graph[minNode, i] + minDistance;
                        prev[i] = minNode;
                    }
                }
               
            }
            if (dist[destinationNode] == int.MaxValue)
            {
                // No path found from sourceNode to destinationNode
                return null;
            }


            // return path
            var path = new Stack<int>(new int[]{destinationNode});
            int currentNode = destinationNode;

            while (currentNode != sourceNode)
            {
                currentNode = prev[currentNode];
                path.Push(currentNode);
            }
            return path.ToList();
        }
    }
}
