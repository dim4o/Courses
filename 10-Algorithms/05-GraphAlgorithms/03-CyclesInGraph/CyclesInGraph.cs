using System;
using System.Collections.Generic;
using System.Linq;

class CyclesInGraph
{
    static void Main()
    {
        Dictionary<char, List<char>> graph = new Dictionary<char, List<char>>();
        Dictionary<char, int> edgesCountMap = new Dictionary<char, int>();

        string input = Console.ReadLine();
        while (input != String.Empty)
        {
            char[] pair = input.Split('-').Select(e => char.Parse(e.Trim())).ToArray();
            char firstNode = pair[0];
            char secondNode = pair[1];
            if (!graph.ContainsKey(firstNode))
            {
                graph[firstNode] = new List<char>();
                edgesCountMap[firstNode] = 0;
            }
            if (!graph.ContainsKey(secondNode))
            {
                graph[secondNode] = new List<char>();
                edgesCountMap[secondNode] = 0;
            }
            graph[firstNode].Add(secondNode);
            graph[secondNode].Add(firstNode);
            edgesCountMap[firstNode]++;
            edgesCountMap[secondNode]++;
            input = Console.ReadLine();
        }

        Console.WriteLine("Acyclic: {0}", IsAcyclic(graph, edgesCountMap) ? "Yes" : "No");
    }

    public static bool IsAcyclic(Dictionary<char, List<char>> graph, Dictionary<char, int> edgesCountMap)
    {
        while (true)
        {
            char nodeToRemove = graph.Keys.FirstOrDefault(e => edgesCountMap[e] == 1);
            if (nodeToRemove == '\0')
            {
                break;
            }
            foreach (var childNode in graph[nodeToRemove])
            {
                edgesCountMap[childNode]--;
            }
            graph.Remove(nodeToRemove);
        }

        return graph.Count == 1;
    }
}

//private static Dictionary<char, List<char>> graph = new Dictionary<char, List<char>>()
//{
//    {'K', new List<char>(){'J'}},
//    {'J', new List<char>(){'N', 'K'}},
//    {'N', new List<char>(){'L', 'J', 'M'}},
//    {'M', new List<char>(){'I', 'N'}},
//    {'L', new List<char>(){'N'}},
//    {'I', new List<char>(){'M'}},
//};

