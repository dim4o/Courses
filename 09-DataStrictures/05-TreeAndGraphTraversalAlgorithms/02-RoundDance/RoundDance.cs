using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_RoundDance
{
    class RoundDance
    {
        static Dictionary<int, List<int>> graph = new Dictionary<int, List<int>>();
        static List<int> visited = new List<int>();
        static int maxLength = 1;

        static void Main()
        {
            int numberOfFriendships = int.Parse(Console.ReadLine());
            int leadNumber = int.Parse(Console.ReadLine());

            for (int i = 0; i < numberOfFriendships; i++)
            {
                string currentFriendship = Console.ReadLine();
                int first = int.Parse(currentFriendship.Split(' ')[0]);
                int second = int.Parse(currentFriendship.Split(' ')[1]);

                if (!graph.ContainsKey(first))
                {
                    graph[first] = new List<int>();
                }
                if (!graph.ContainsKey(second))
                {
                    graph[second] = new List<int>();
                }
                
                graph[first].Add(second);
                graph[second].Add(first);
            }

            DFS(leadNumber);

            Console.WriteLine(maxLength);
        }

        static void DFS(int node)
        {
            if (!visited.Contains(node))
            {
                visited.Add(node);
                maxLength = 1;

                foreach (var childNode in graph[node])
                {
                    DFS(childNode);
                }
                
                maxLength++;
            }
        }
    }
}
