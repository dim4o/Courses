using System;
using System.Collections.Generic;
using System.Linq;

public class BreakCycles
{
    private static bool _hasPath;

    static void Main() 
    {
        var graph = ParseGraphFromInput();
        var result = BreakGraph(graph);
        PrintResult(result);
    }

    private static Dictionary<string, List<string>> ParseGraphFromInput()
    {
        var graph = new Dictionary<string, List<string>>();

        var input = Console.ReadLine();
        while (input != String.Empty)
        {
            var arr = input.Split(new char[] { '-', '>' },
                StringSplitOptions.RemoveEmptyEntries);
            var parent = arr[0].Trim();

            var children = arr[1].Split(new char[] { ',', ' ' },
                StringSplitOptions.RemoveEmptyEntries).ToList();

            graph.Add(parent, children);
            input = Console.ReadLine();
        }

        return graph;
    }

    private static List<Edge> EnumerateEdges(Dictionary<string, List<string>> graph)
    {
        var edges = (from node in graph.Keys 
                     from child in graph[node] 
                     select new Edge() {Start = node, End = child}).ToList();
        edges.Sort();
        return edges;
    }

    private static void PrintResult(List<Edge> result)
    {
        Console.WriteLine("Edgeds to remove: {0}", result.Count);
        foreach (var edge in result)
        {
            Console.WriteLine("{0} – {1}", edge.Start, edge.End);
        }
    }

    public static List<Edge> BreakGraph(Dictionary<string, List<string>> graph)
    {
        var edges = EnumerateEdges(graph);
        var result = new List<Edge>();
        foreach (var edge in edges)
        {
            _hasPath = false;
            var end = edge.End;
            graph[edge.Start].Remove(edge.End);
            DfsHasPathCheck(graph, edge.Start, edge.End, new HashSet<string>());

            if (!_hasPath)
            {
                graph[edge.Start].Add(end);
            } 
            else if (edge.Start.CompareTo(edge.End) < 0)
            {
                result.Add(edge);
            }
        }
        return result;
    }

    private static void DfsHasPathCheck(Dictionary<string, List<string>> graph, 
        string start, string end, HashSet<string> visited)
    {
        if (start.CompareTo(end) == 0)
        {
            _hasPath = true;
            return;
        }
        if (!visited.Contains(start))
        {
            visited.Add(start);
            foreach (var child in graph[start])
            {
                DfsHasPathCheck(graph, child, end, visited);
            }
        }
    }
}



