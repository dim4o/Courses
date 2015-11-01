using ModifiedKruskalAlgorithm;
namespace Kurskal
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    public class ModifiedKruskalMain
    {
        public static void Main()
        {
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

            var minimumSpanningForest = ModifiedKruskal.Kruskal(numberOfVertices, graphEdges);

            Console.WriteLine("Minimum spanning forest weight: " +
                            minimumSpanningForest.Sum(e => e.Weight));

            foreach (var edge in minimumSpanningForest)
            {
                Console.WriteLine(edge);
            }
        }
    }
}