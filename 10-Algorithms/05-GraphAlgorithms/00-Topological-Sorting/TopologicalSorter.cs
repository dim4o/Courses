using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;

public class TopologicalSorter
{
    private Dictionary<string, List<string>> graph;
    private HashSet<string> visitedNodes;
    private LinkedList<string> sortedNodes;
    private HashSet<string> cycleNodes; 

    public TopologicalSorter(Dictionary<string, List<string>> graph)
    {
        this.graph = graph;
    }

    // With DFS
    public ICollection<string> TopSort()
    {
        this.visitedNodes = new HashSet<string>();
        this.sortedNodes = new LinkedList<string>();
        this.cycleNodes = new HashSet<string>();

        foreach (var node in graph.Keys)
        {
            TopSortDFS(node);
        }

        return sortedNodes;
    }

    private void TopSortDFS(string node)
    {
        if (cycleNodes.Contains(node))
        {
            throw new InvalidOperationException("A cycle detected in the graph");
        }
        if (!visitedNodes.Contains(node))
        {
            this.visitedNodes.Add(node);
            this.cycleNodes.Add(node);

            if (graph.ContainsKey(node))
            {
                foreach (var child in graph[node])
                {
                    TopSortDFS(child);
                }
            }

            this.cycleNodes.Remove(node);
            this.sortedNodes.AddFirst(node);
        }
    }

    // Source removal algorithm
    //public ICollection<string> TopSort()
    //{
    //    var predecessorsCount = new Dictionary<string, int>();
    //    foreach (var node in this.graph)
    //    {
    //        if (!predecessorsCount.ContainsKey(node.Key))
    //        {
    //            predecessorsCount[node.Key] = 0;
    //        }

    //        foreach (var childNode in node.Value)
    //        {
    //            if (!predecessorsCount.ContainsKey(childNode))
    //            {
    //                predecessorsCount[childNode] = 0;
    //            }
    //            predecessorsCount[childNode]++;
    //        }
    //    }

    //    var removedNodes = new List<string>();
    //    while (true)
    //    {
    //        string nodeToRemove = graph.Keys.FirstOrDefault(n => predecessorsCount[n] == 0);
    //        if (nodeToRemove == null)
    //        {
    //            // No more nodes for removal (with o predecessors)
    //            break;
    //        }
    //        foreach (var childNode in graph[nodeToRemove])
    //        {
    //            predecessorsCount[childNode]--;
    //        }
    //        graph.Remove(nodeToRemove);
    //        removedNodes.Add(nodeToRemove);
    //    }

    //    if (graph.Count > 0)
    //    {
    //        throw new InvalidOperationException("A cycle detected in the graph");
    //    }

    //    return removedNodes;
    //}
}
