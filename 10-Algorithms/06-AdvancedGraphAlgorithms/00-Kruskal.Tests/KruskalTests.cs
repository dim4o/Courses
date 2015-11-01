using ModifiedKruskalAlgorithm;

namespace Kruskal.Tests
{
    using System.Collections.Generic;
    using System.Linq;
    using Kurskal;
    using Microsoft.VisualStudio.TestTools.UnitTesting;

    [TestClass]
    public class KruskalTests
    {
        [TestMethod]
        public void TestKruskalWithSingleEdge()
        {
            int numberOfVertices = 2;
            var graphEdges = new List<Edge>
            {
                new Edge(0, 1, 3)
            };

            var minimumSpanningForest = ModifiedKruskal.Kruskal(numberOfVertices, graphEdges.ToList());
            var totalWeight = minimumSpanningForest.Sum(edge => edge.Weight);

            var expectedTotalWeight = 3;
            var expectedForest = new[] { graphEdges[0] };

            Assert.AreEqual(expectedTotalWeight, totalWeight, "Weights should match.");
            CollectionAssert.AreEqual(
                expectedForest,
                minimumSpanningForest,
                "The correct edges should be present in the MST in the correct order.");
        }

        [TestMethod]
        public void TestKruskalWithTwoConnectedEdges()
        {
            int numberOfVertices = 3;
            var graphEdges = new List<Edge>
            {
                new Edge(0, 1, 3),
                new Edge(2, 1, 4)
            };

            var minimumSpanningForest = ModifiedKruskal.Kruskal(numberOfVertices, graphEdges.ToList());
            var totalWeight = minimumSpanningForest.Sum(edge => edge.Weight);

            var expectedTotalWeight = 7;
            var expectedForest = new[] { graphEdges[0], graphEdges[1] };

            Assert.AreEqual(expectedTotalWeight, totalWeight, "Weights should match.");
            CollectionAssert.AreEqual(
                expectedForest,
                minimumSpanningForest,
                "The correct edges should be present in the MST in the correct order.");
        }

        [TestMethod]
        public void TestKruskalWithTwoEdgesFormingForest()
        {
            int numberOfVertices = 4;
            var graphEdges = new List<Edge>
            {
                new Edge(0, 1, 3),
                new Edge(2, 3, 4)
            };

            var minimumSpanningForest = ModifiedKruskal.Kruskal(numberOfVertices, graphEdges.ToList());
            var totalWeight = minimumSpanningForest.Sum(edge => edge.Weight);

            var expectedTotalWeight = 7;
            var expectedForest = new[] { graphEdges[0], graphEdges[1] };

            Assert.AreEqual(expectedTotalWeight, totalWeight, "Weights should match.");
            CollectionAssert.AreEqual(
                expectedForest,
                minimumSpanningForest,
                "The correct edges should be present in the MST in the correct order.");
        }

        [TestMethod]
        public void TestKruskalWith4VerticesAnd5Edges()
        {
            int numberOfVertices = 4;
            var graphEdges = new List<Edge>
            {
                new Edge(0, 1, 9),
                new Edge(0, 3, 4),
                new Edge(3, 1, 6),
                new Edge(3, 2, 11),
                new Edge(1, 2, 5)
            };

            var minimumSpanningForest = ModifiedKruskal.Kruskal(numberOfVertices, graphEdges.ToList());
            var totalWeight = minimumSpanningForest.Sum(edge => edge.Weight);

            var expectedTotalWeight = 15;
            var expectedForest = new[]
            {
                graphEdges[1],
                graphEdges[4],
                graphEdges[2],
            };

            Assert.AreEqual(expectedTotalWeight, totalWeight, "Weights should match.");
            CollectionAssert.AreEqual(
                expectedForest,
                minimumSpanningForest,
                "The correct edges should be present in the MST in the correct order.");
        }

        [TestMethod]
        public void TestKruskalWith9VerticesAnd11Edges()
        {
            int numberOfVertices = 9;
            var graphEdges = new List<Edge>
            {
                new Edge(0, 3, 9),
                new Edge(0, 5, 4),
                new Edge(0, 8, 5),
                new Edge(1, 4, 8),
                new Edge(1, 7, 7),
                new Edge(2, 6, 12),
                new Edge(3, 5, 2),
                new Edge(3, 6, 8),
                new Edge(3, 8, 20),
                new Edge(4, 7, 10),
                new Edge(6, 8, 7)
            };

            var minimumSpanningForest = ModifiedKruskal.Kruskal(numberOfVertices, graphEdges.ToList());
            var totalWeight = minimumSpanningForest.Sum(edge => edge.Weight);

            var expectedTotalWeight = 45;
            var expectedForest = new[]
            {
                graphEdges[6],
                graphEdges[1],
                graphEdges[2],
                graphEdges[4], // (1, 7, 7)
                graphEdges[10],//(6, 8, 7)
                graphEdges[3],
                graphEdges[5]
            };

            Assert.AreEqual(expectedTotalWeight, totalWeight, "Weights should match.");
            CollectionAssert.AreEqual(
                expectedForest,
                minimumSpanningForest,
                "The correct edges should be present in the MST in the correct order.");
        }

        [TestMethod]
        public void TestKruskalWith9VerticesAnd15Edges()
        {
            int numberOfVertices = 9;
            var graphEdges = new List<Edge>
            {
                new Edge(1, 4, 8),
                new Edge(4, 0, 6),
                new Edge(1, 7, 7),
                new Edge(4, 7, 10),
                new Edge(4, 8, 3),
                new Edge(7, 8, 4),
                new Edge(0, 8, 5),
                new Edge(8, 6, 9),
                new Edge(8, 3, 20),
                new Edge(0, 5, 4),
                new Edge(0, 3, 9),
                new Edge(6, 3, 8),
                new Edge(6, 2, 12),
                new Edge(5, 3, 2),
                new Edge(3, 2, 14)
            };

            var minimumSpanningForest = ModifiedKruskal.Kruskal(numberOfVertices, graphEdges.ToList());
            var totalWeight = minimumSpanningForest.Sum(edge => edge.Weight);

            var expectedTotalWeight = 45;
            var expectedForest = new[]
            {
                graphEdges[13],
                graphEdges[4],
                graphEdges[5],// swap
                graphEdges[9],// swap
                graphEdges[6],
                graphEdges[2],
                graphEdges[11],
                graphEdges[12]
            };

            Assert.AreEqual(expectedTotalWeight, totalWeight, "Weights should match.");
            CollectionAssert.AreEqual(
                expectedForest,
                minimumSpanningForest,
                "The correct edges should be present in the MST in the correct order.");
        }

        [TestMethod]
        public void TestKruskalWith9VerticesAnd10Edges()
        {
            int numberOfVertices = 9;
            var graphEdges = new List<Edge>
            {
                new Edge(0, 3, 9),
                new Edge(0, 8, 5),
                new Edge(1, 4, 8),
                new Edge(1, 7, 7),
                new Edge(2, 6, 12),
                new Edge(3, 5, 2),
                new Edge(3, 6, 8),
                new Edge(3, 8, 20),
                new Edge(4, 7, 10),
                new Edge(6, 8, 7)
            };

            var minimumSpanningForest = ModifiedKruskal.Kruskal(numberOfVertices, graphEdges.ToList());
            var totalWeight = minimumSpanningForest.Sum(edge => edge.Weight);

            var expectedTotalWeight = 49;
            var expectedForest = new[]
            {
                graphEdges[5],
                graphEdges[1],
                graphEdges[3],
                graphEdges[9],
                graphEdges[2],
                graphEdges[6],
                graphEdges[4]
            };

            Assert.AreEqual(expectedTotalWeight, totalWeight, "Weights should match.");
            CollectionAssert.AreEqual(
                expectedForest,
                minimumSpanningForest,
                "The correct edges should be present in the MST in the correct order.");
        }

        [TestMethod]

        public void TestKruskalWith8VerticesAnd16Edges()
        {
            int numberOfVertices = 8;
            var graphEdges = new List<Edge>
            {
                new Edge(0, 1, 4),
                new Edge(0, 2, 5),
                new Edge(0, 3, 1),
                new Edge(1, 2, 8),
                new Edge(1, 3, 2),
                new Edge(2 ,3, 3),
                new Edge(2 ,4 ,16),
                new Edge(2 ,5, 9),
                new Edge(3 ,4 ,7),
                new Edge(3 ,5, 14),
                new Edge(4, 5 ,12),
                new Edge(4, 6 ,22),
                new Edge(4 ,7, 9),
                new Edge(5 ,6 ,6),
                new Edge(5 ,7, 18),
                new Edge(6,7 ,15),
            };

            var minimumSpanningForest = ModifiedKruskal.Kruskal(numberOfVertices, graphEdges.ToList());
            var totalWeight = minimumSpanningForest.Sum(edge => edge.Weight);

            var expectedTotalWeight = 37;
            var expectedForest = new[]
            {
                graphEdges[2],
                graphEdges[4],
                graphEdges[5],
                graphEdges[13],
                graphEdges[8],
                graphEdges[7],
                graphEdges[12]
            };

            Assert.AreEqual(expectedTotalWeight, totalWeight, "Weights should match.");
            CollectionAssert.AreEqual(
                expectedForest,
                minimumSpanningForest,
                "The correct edges should be present in the MST in the correct order.");
        }
    }
}
