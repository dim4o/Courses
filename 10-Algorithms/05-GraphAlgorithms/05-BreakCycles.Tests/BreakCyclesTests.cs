using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;

[TestClass]
public class BreakCyclesTests
{
    [TestMethod]
    public void TestWith_2_Nodes()
    {
        var graph = new Dictionary<string, List<string>>()
        {
            { "A", new List<string>(){"B"} },
            { "B", new List<string>(){"A"} },
        };

        List<Edge> edges = new List<Edge>();

        List<Edge> outputEdges = BreakCycles.BreakGraph(graph);

        CollectionAssert.AreEqual(edges, outputEdges);
    }

    [TestMethod]
    public void TestWith_3_Nodes()
    {
        var graph = new Dictionary<string, List<string>>()
        {
            { "A", new List<string>(){"B", "C"} },
            { "B", new List<string>(){"A", "C"} },
            { "C", new List<string>(){"A", "B"} },
        };

        List<Edge> edges = new List<Edge>()
        {
            new Edge(){Start = "A", End = "B"},
        };

        List<Edge> outputEdges = BreakCycles.BreakGraph(graph);

        CollectionAssert.AreEqual(edges, outputEdges);
    }

    [TestMethod]
    public void TestWith_4_Nodes()
    {
        var graph = new Dictionary<string, List<string>>()
        {
            { "A", new List<string>(){"D", "B", "C"} },
            { "B", new List<string>(){"A", "C"} },
            { "C", new List<string>(){"A", "D", "B"} },
            { "D", new List<string>(){"A", "C"} },
        };

        List<Edge> edges = new List<Edge>()
        {
            new Edge(){Start = "A", End = "B"},
            new Edge(){Start = "A", End = "C"},
        };

        List<Edge> outputEdges = BreakCycles.BreakGraph(graph);

        CollectionAssert.AreEqual(edges, outputEdges);
    }

    [TestMethod]
    public void TestWith_8_Nodes()
    {
        var graph = new Dictionary<string, List<string>>()
        {
            { "8", new List<string>(){"6", "7"} },
            { "1", new List<string>(){"2", "5", "4"} },
            { "2", new List<string>(){"1", "3"} },
            { "3", new List<string>(){"2", "5"} },
            { "4", new List<string>(){"1"} },
            { "5", new List<string>(){"1", "3"} },
            { "6", new List<string>(){"7", "8"} },
            { "7", new List<string>(){"6", "8"} },
        };

        List<Edge> edges = new List<Edge>()
        {
            new Edge(){Start = "1", End = "2"},
            new Edge(){Start = "6", End = "7"}
        };

        List<Edge> outputEdges = BreakCycles.BreakGraph(graph);

        CollectionAssert.AreEqual(edges, outputEdges);
    }

    [TestMethod]
    public void TestWith_14_Nodes()
    {
        var graph = new Dictionary<string, List<string>>()
        {
            { "K", new List<string>(){"X", "J"} },
            { "J", new List<string>(){"K", "N"} },
            { "N", new List<string>(){"J", "X", "L", "M"} },
            { "X", new List<string>(){"K", "N", "Y"} },
            { "M", new List<string>(){"N", "I"} },
            { "Y", new List<string>(){"X", "L"} },
            { "L", new List<string>(){"N", "I", "Y"} },
            { "I", new List<string>(){"M", "L"} },
            { "A", new List<string>(){"Z", "Z", "Z"} },
            { "Z", new List<string>(){"A", "A", "A"} },
            { "F", new List<string>(){"E", "B", "P"} },
            { "E", new List<string>(){"F", "P"} },
            { "P", new List<string>(){"B", "F", "E"} },
            { "B", new List<string>(){"F","P"} },
        };

        List<Edge> edges = new List<Edge>()
        {
            new Edge(){Start = "A", End = "Z"},
            new Edge(){Start = "A", End = "Z"},
            new Edge(){Start = "B", End = "F"},
            new Edge(){Start = "E", End = "F"},
            new Edge(){Start = "I", End = "L"},
            new Edge(){Start = "J", End = "K"},
            new Edge(){Start = "L", End = "N"},
        };

        List<Edge> outputEdges = BreakCycles.BreakGraph(graph);

        CollectionAssert.AreEqual(edges, outputEdges);
    }

    [TestMethod]
    public void TestWith_15_Nodes()
    {
        var graph = new Dictionary<string, List<string>>()
        {
            { "1", new List<string>(){"9"} },
            { "2", new List<string>(){"9", "3", "4"} },
            { "3", new List<string>(){"2", "7"} },
            { "4", new List<string>(){"2", "7", "5"} },
            { "5", new List<string>(){"4", "7", "6"} },
            { "6", new List<string>(){"5", "8", "9"} },
            { "7", new List<string>(){"3", "4", "5"} },
            { "8", new List<string>(){"6", "9"} },
            { "9", new List<string>(){"1", "2", "6", "8"} },

            { "A", new List<string>(){"E", "B"} },
            { "B", new List<string>(){"A", "C"} },
            { "C", new List<string>(){"B", "D"} },
            { "D", new List<string>(){"E", "F", "C"} },
            { "E", new List<string>(){"D", "F", "A"} },
            { "F", new List<string>(){"E", "D"} },
        };

        List<Edge> edges = new List<Edge>()
        {
            new Edge(){Start = "2", End = "3"},
            new Edge(){Start = "2", End = "4"},
            new Edge(){Start = "4", End = "5"},
            new Edge(){Start = "6", End = "8"},
            new Edge(){Start = "A", End = "B"},
            new Edge(){Start = "D", End = "E"}
        };

        List<Edge> outputEdges = BreakCycles.BreakGraph(graph);

        CollectionAssert.AreEqual(edges, outputEdges);
    }
}



