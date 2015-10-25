using System;
using System.Collections.Generic;
using System.Linq;

public static class DistanceBetweenVertices
{
    static void Main()
    {
        Console.WriteLine("Graph:");
        var inputGraph = ReadGraph();
        Console.WriteLine("Distances to find:");
        string input = Console.ReadLine();

        while (input != String.Empty)
        {
            string[] arr = input.Split('-');
            int startNode = int.Parse(arr[0]);
            int targetNode = int.Parse(arr[1]);
            int result = FindMinDistance(inputGraph, startNode, targetNode);
            Console.WriteLine("{{{0}, {1}}} -> {2}", startNode, targetNode, result);
            input = Console.ReadLine();
        }
    }

    public static int FindMinDistance(Dictionary<int, List<int>> graph, int startNode, int targetNode)
    {
        int result = Dfs(graph, startNode, targetNode, int.MaxValue, -1, new HashSet<int>());
        return result != int.MaxValue ? result : -1;
    }

    private static int Dfs(Dictionary<int, List<int>> graph, int startNode, int targetNode, 
        int minLen, int len, HashSet<int> visited)
    {
        if (visited.Contains(startNode))
        {
            return minLen;
        }

        visited.Add(startNode);
        len++;
        if (startNode == targetNode && len < minLen)
        {
            minLen = len;
        }
        minLen = graph[startNode].Aggregate(minLen, (current, child) => 
            Dfs(graph, child, targetNode, current, len, visited));
        visited.Remove(startNode);

        return minLen;
    }

    private static Dictionary<int, List<int>> ReadGraph()
    {
        var graph = new Dictionary<int, List<int>>();
        string input = Console.ReadLine();
        while (input != String.Empty)
        {
            var arr = input.Split(new char[] {'-', '>'}, StringSplitOptions.RemoveEmptyEntries);
            int parentNode = int.Parse(arr[0]);
            List<int> childs = new List<int>();
            if (arr.Length > 1)
            {
                childs = arr[1].Split(',').Select(n => int.Parse(n)).ToList();                
            }
            graph.Add(parentNode, childs);
            input = Console.ReadLine();
        }

        return graph;
    }
}



