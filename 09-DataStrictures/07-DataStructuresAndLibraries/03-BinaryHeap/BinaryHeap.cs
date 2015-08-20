using System;
using System.Collections.Generic;
using System.Linq;

namespace _03_BinaryHeap
{
    class BinaryHeap<T> where T: IComparable<T>
    {
        private List<T> list = new List<T>();

        public List<T> List 
        {
            get { return this.list; }
            set { this.list = value; }
        }

        public int Count
        {
            get { return List.Count; }
        }
        
        public void Enqueue(T value)
        {
            List.Add(value);
            int currentIndex = List.Count - 1;
            int parentIndex = GetParentIndex(currentIndex);

            while (List[parentIndex].CompareTo(List[currentIndex]) > 0)
            {
                Swap(currentIndex, parentIndex);
                currentIndex = GetParentIndex(currentIndex);
                parentIndex = GetParentIndex(currentIndex);
            }
        }

        public T Dequeue()
        {
            if (this.Count == 0)
            {
                throw new InvalidOperationException("The queue is already empty.");
            }
            T element = List.First();
            List[0] = List[List.Count - 1];
            List.RemoveAt(List.Count - 1);
            int currentIndex = 0;
            int leftChildIndex = GetLeftChild(currentIndex);
            int rightChildIndex = GetRightChild(currentIndex);
            int indexToSwap = GetIndexToSwap(leftChildIndex, rightChildIndex);

            while (indexToSwap > 0 && List[currentIndex].CompareTo(List[indexToSwap]) > 0)
            {
                Swap(indexToSwap, currentIndex);
                currentIndex = indexToSwap;
                leftChildIndex = GetLeftChild(currentIndex);
                rightChildIndex = GetRightChild(currentIndex);
                indexToSwap = GetIndexToSwap(leftChildIndex, rightChildIndex);
            }
            
            return element;
        }

        private int GetIndexToSwap(int leftChildIndex, int rightChildIndex)
        {
            int indexToSwap;

            if (leftChildIndex > 0 && rightChildIndex > 0 && List[leftChildIndex].CompareTo(List[rightChildIndex]) > 0)
            {
                indexToSwap = rightChildIndex;
            }
            else if (leftChildIndex > 0 && rightChildIndex > 0 && List[leftChildIndex].CompareTo(List[rightChildIndex]) < 0)
            {
                indexToSwap = leftChildIndex;
            }
            else if (leftChildIndex > 0 && rightChildIndex == -1)
            {
                indexToSwap = leftChildIndex;
            }
            else
            {
                indexToSwap = rightChildIndex;
            }

            return indexToSwap;
        }

        private void Swap(int firstIndex, int secondIndex)
        {
            T temp = List[firstIndex];
            List[firstIndex] = List[secondIndex];
            List[secondIndex] = temp;
        }

        private static int GetParentIndex(int index)
        {
            return (index - 1) / 2;
        }

        private int GetLeftChild(int rootIndex)
        {
            if (2 * rootIndex + 1 < List.Count)
            {
                return 2 * rootIndex + 1;
            }
            
            return -1;
        }

        private int GetRightChild(int rootIndex)
        {
            if (2 * rootIndex + 2 < List.Count)
            {
                return 2 * rootIndex + 2;
            }

            return -1;
        }
    }
}


//public void Enqueue(int value)
//{
//    List.Enqueue(value);
//    int currentIndex = List.Count - 1;
//    int rootIndex = GetParentIndex(currentIndex);

//    while (rootIndex >= 0 && List[rootIndex] > List[currentIndex])
//    {
//        int temp = List[currentIndex];
//        List[currentIndex] = List[rootIndex];
//        List[rootIndex] = temp;

//        currentIndex = GetParentIndex(currentIndex);
//        rootIndex = GetParentIndex(currentIndex);
//    }
//}