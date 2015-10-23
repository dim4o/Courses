using System;
using System.Collections.Generic;
using System.Linq;

public class DistanceBetweenVertices
{
    private static Dictionary<int, List<int>> inputGraph = new Dictionary<int, List<int>>()
    {
        { 11, new List<int>(){ 4 } },
        { 4, new List<int>(){ 12, 1 } },
        { 1, new List<int>(){ 12, 21, 7 } }, 
        { 7, new List<int>(){ 21 } },
        { 12, new List<int>(){ 4, 19 } },
        { 19, new List<int>(){ 1, 21 } },
        { 21, new List<int>(){ 14, 31 } },
        { 14, new List<int>(){ 14 } },
        { 31, new List<int>(){ } },
    };
    private static HashSet<int> visited = new HashSet<int>();

    static void Main()
    {
        inputGraph = ReadGraph();
        Console.WriteLine("Distances to find:");

        string input = Console.ReadLine();

        while (input != String.Empty)
        {
            string[] arr = input.Split('-');
            int startNode = int.Parse(arr[0]);
            int targetNode = int.Parse(arr[1]);
            int result = DFS(inputGraph, startNode, targetNode);
            Console.WriteLine("{{{0}, {1}}} -> {2}", startNode, targetNode, result);
            input = Console.ReadLine();
            visited = new HashSet<int>();
        }
    }

    public static int DFS(Dictionary<int, List<int>> graph, int node, int targetNode)
    {
        int result = DFS(graph, node, targetNode, int.MaxValue, -1);
        if (result != int.MaxValue)
        {
            return result;
        }
        return -1;
    }

    private static int DFS(Dictionary<int, List<int>> graph, int node, int targetNode, int minLen, int len)
    {
        if (visited.Contains(node))
        {
            return minLen;
        }

        visited.Add(node);
        len++;
        if (node == targetNode && len < minLen)
        {
            minLen = len;
        }
        minLen = graph[node].Aggregate(minLen, (current, child) => 
            DFS(graph, child, targetNode, current, len));
        //foreach (var child in graph[node])
        //{
        //    minLen = DFS(graph, child, targetNode, minLen, len);
        //}
        visited.Remove(node);
        len--;

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

    //public static int minLen = int.MaxValue;
    //private static int len;

    //public static void DFS(Dictionary<int, List<int>> graph, int node, int targetNode)
    //{
    //    if (!visited.Contains(node))
    //    {
    //        visited.Add(node);
    //        len++;
    //        if (node == targetNode && len < minLen)
    //        {
    //            minLen = len;
    //        }

    //        foreach (var child in graph[node])
    //        {
    //            DFS(graph, child, targetNode);
    //        }

    //        visited.Remove(node);
    //        len--;
    //    }
    //}
}



