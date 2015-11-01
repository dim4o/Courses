namespace Kurskal
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class KruskalMain
    {
        public static void Main()
        {
            //int numberOfVertices = 9;
            //var graphEdges = new List<Edge>
            //{
            //    new Edge(0, 3, 9),
            //    new Edge(0, 5, 4),
            //    new Edge(0, 8, 5),
            //    new Edge(1, 4, 8),
            //    new Edge(1, 7, 7),
            //    new Edge(2, 6, 12),
            //    new Edge(3, 5, 2),
            //    new Edge(3, 6, 8),
            //    new Edge(3, 8, 20),
            //    new Edge(4, 7, 10),
            //    new Edge(6, 8, 7)
            //};
            //int numberOfVertices = 8;
            //var graphEdges = new List<Edge>
            //{
            //    new Edge(0, 1, 4),
            //    new Edge(0, 2, 5),
            //    new Edge(0, 3, 1),
            //    new Edge(1, 2, 8),
            //    new Edge(1, 3, 2),
            //    new Edge(2 ,3, 3),
            //    new Edge(2 ,4 ,16),
            //    new Edge(2 ,5, 9),
            //    new Edge(3 ,4 ,7),
            //    new Edge(3 ,5, 14),
            //    new Edge(4, 5 ,12),
            //    new Edge(4, 6 ,22),
            //    new Edge(4 ,7, 9),
            //    new Edge(5 ,6 ,6),
            //    new Edge(5 ,7, 18),
            //    new Edge(6,7 ,15),
            //};

            Console.Write("Nodes: ");
            int numberOfVertices = int.Parse(Console.ReadLine());
            Console.Write("Edges: ");
            int edgesCount = int.Parse(Console.ReadLine());
            var graphEdges = new List<Edge>();
            for (int i = 0; i < edgesCount; i++)
            {
                int[] edgeParams = Console.ReadLine().Split(' ').Select(e => int.Parse(e)).ToArray();
                graphEdges.Add(new Edge(edgeParams[0], edgeParams[1], edgeParams[2]));
            }

            var minimumSpanningForest = KruskalAlgorithm.Kruskal(numberOfVertices, graphEdges);

            Console.WriteLine("Minimum spanning forest weight: " +
                            minimumSpanningForest.Sum(e => e.Weight));

            foreach (var edge in minimumSpanningForest)
            {
                Console.WriteLine(edge);
            }
        }
    }
}
