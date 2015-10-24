using System;
using System.Collections.Generic;
using System.Linq;

class Salaries
{
    private static  Dictionary<int, List<int>> predecessorsMap = new Dictionary<int, List<int>>();
    private static Dictionary<int, int> successorsCount= new Dictionary<int, int>();
    private static long[] salaries;

    static void Main()
    {
        int numberOflines = int.Parse(Console.ReadLine());
        var graph = new List<int>[numberOflines];
        salaries = new long[graph.Length]; 

        for (int i = 0; i < numberOflines; i++)
        {
            string cuurentLine = Console.ReadLine();
            int index = cuurentLine.IndexOf('Y', 0);
            graph[i] = new List<int>();
            while (index >= 0)
            {
                graph[i].Add(index);
                index = cuurentLine.IndexOf('Y', index + 1);
            }
        }

        for (int index = 0; index < graph.Length; index++)
        {
            successorsCount.Add(index, graph[index].Count);

            foreach (var child  in graph[index])
            {
                if (!predecessorsMap.ContainsKey(child))
                {
                    predecessorsMap[child] = new List<int>();
                }
                predecessorsMap[child].Add(index);
            }
        }

        while (successorsCount.Values.Any(v => v == 0))
        {
            int currentNode = successorsCount.FirstOrDefault(v => v.Value == 0).Key;
            if (graph[currentNode].Count == 0)
            {
                salaries[currentNode] = 1;  
            }
            if (predecessorsMap.ContainsKey(currentNode))
            {
                foreach (var predecessor in predecessorsMap[currentNode])
                {
                    salaries[predecessor] += salaries[currentNode];
                    successorsCount[predecessor]--;
                }
            }
            successorsCount.Remove(currentNode);
        }

        Console.WriteLine(salaries.Sum());
    }
}

