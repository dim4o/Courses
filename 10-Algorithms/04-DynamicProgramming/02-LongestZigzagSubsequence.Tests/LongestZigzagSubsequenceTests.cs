using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using _02_LongestZigzagSubsequence;

namespace _02_LongestZigzagSubsequence.Tests
{
    [TestClass]
    public class LongestZigzagSubsequenceTests
    {
        [TestMethod]
        public void ZeroTest_with_3_ordered_elements()
        {
            var result = LongestZigzagSubsequence.GetLongestZigZag(
                new int[] { 1, 2, 3 });

            var expected = new int[] { 1, 2 };
            CollectionAssert.AreEqual(result, expected);
        }

        [TestMethod]
        public void ZeroTest_with_3_zigzag_elements()
        {
            var result = LongestZigzagSubsequence.GetLongestZigZag(
                new int[] { 1, 3, 2 });

            var expected = new int[] { 1, 3, 2 };
            CollectionAssert.AreEqual(result, expected);
        }

        [TestMethod]
        public void ZeroTest_with_14_elements()
        {
            var result = LongestZigzagSubsequence.GetLongestZigZag(
                new int[] { 8, 3, 5, 7, 0, 8, 9, 10, 20, 20, 20, 12, 19, 11 });

            var expected = new int[] {8, 3, 5, 0, 20, 12, 19, 11};
            CollectionAssert.AreEqual(result, expected);
        }

        [TestMethod]
        public void ZeroTest_with_12_elements()
        {
            var result = LongestZigzagSubsequence.GetLongestZigZag(
                new int[] { 24, 5, 31, 3, 3, 342, 51, 114, 52, 55, 56, 58 });

            var expected = new int[] { 24, 5, 31, 3, 342, 51, 114, 52, 55 };
            CollectionAssert.AreEqual(result, expected);
        }

        [TestMethod]
        public void ZeroTest_with_19_elements()
        {
            var result = LongestZigzagSubsequence.GetLongestZigZag(new int[] 
            { 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 });
            
            var expected = new int[] { 70, 55, 99, 2, 80, 19, 1000, 32 };

            CollectionAssert.AreEqual(result, expected);
        }

        [TestMethod]
        public void ZeroTest_with_6_elements()
        {
            var result = LongestZigzagSubsequence.GetLongestZigZag(new int[] 
            { 1, 7, 4, 9, 2, 5 });

            var expected = new int[] { 1, 7, 4, 9, 2, 5 };

            CollectionAssert.AreEqual(result, expected);
        }

        [TestMethod]
        public void ZeroTest_with_10_elements()
        {
            var result = LongestZigzagSubsequence.GetLongestZigZag(new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 });

            var expected = new int[] { 1, 17, 5, 13, 10, 16, 8 };

            CollectionAssert.AreEqual(result, expected);
        }

        [TestMethod]
        public void ZeroTest_with_50_elements()
        {
            var result = LongestZigzagSubsequence.GetLongestZigZag(new int[] 
                { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
                600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
                67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
                477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
                249, 22, 176, 279, 23, 22, 617, 462, 459, 244 });

            Assert.AreEqual(result.Length, 36);
        }
    }
}
