using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;


[TestClass]
public class DistanceBetweenVerticesTests
{
    private static readonly Dictionary<int, List<int>> Graph01 = 
        new Dictionary<int, List<int>>()
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

    private static readonly Dictionary<int, List<int>> Graph02 =
        new Dictionary<int, List<int>>()
    {
        { 1, new List<int>(){ 4 } },
        { 2, new List<int>(){ 4 } },
        { 3, new List<int>(){ 4, 5 } }, 
        { 4, new List<int>(){ 6 } }, 
        { 5, new List<int>(){ 3, 7, 8 } },
        { 6, new List<int>(){  } },
        { 7, new List<int>(){ 8 } },
        { 8, new List<int>(){ } },
    };

    private static readonly Dictionary<int, List<int>> Graph03 =
        new Dictionary<int, List<int>>()
    {
        { 1, new List<int>(){ 2 } },
        { 2, new List<int>(){  } },
    };

    [TestMethod]
    public void TestGraphWith_9_vertices()
    {
        Assert.AreEqual(3, DistanceBetweenVertices.DFS(Graph01, 11, 7));
        Assert.AreEqual(3, DistanceBetweenVertices.DFS(Graph01, 11, 21));
        Assert.AreEqual(-1, DistanceBetweenVertices.DFS(Graph01, 21, 4));
        Assert.AreEqual(2, DistanceBetweenVertices.DFS(Graph01, 19, 14));
        Assert.AreEqual(2, DistanceBetweenVertices.DFS(Graph01, 1, 4));
        Assert.AreEqual(-1, DistanceBetweenVertices.DFS(Graph01, 1, 11));
        Assert.AreEqual(-1, DistanceBetweenVertices.DFS(Graph01, 31, 21));
        Assert.AreEqual(4, DistanceBetweenVertices.DFS(Graph01, 11, 14));
    }

    [TestMethod]
    public void TestGraphWith_7_vertices()
    {
        Assert.AreEqual(2, DistanceBetweenVertices.DFS(Graph02, 1, 6));
        Assert.AreEqual(-1, DistanceBetweenVertices.DFS(Graph02, 1, 5));
        Assert.AreEqual(3, DistanceBetweenVertices.DFS(Graph02, 5, 6));
        Assert.AreEqual(1, DistanceBetweenVertices.DFS(Graph02, 5, 8));
    }

    [TestMethod]
    public void TestGraphWith_2_vertices()
    {
        Assert.AreEqual(1, DistanceBetweenVertices.DFS(Graph03, 1, 2));
        Assert.AreEqual(-1, DistanceBetweenVertices.DFS(Graph03, 2, 1));
    }
}

