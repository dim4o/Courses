using System;
using System.Collections.Generic;

class DistanceInLabyrinth
{
    // Keeps (row, col) pair
    private class HelpNode
    {
        public HelpNode(int row, int col)
        {
            this.Row = row;
            this.Col = col;
        }

        public int Row { get; set; }
        public int Col { get; set;}
    }

    public static void CalcDistance(string[,] inputMatrix, int startRow, int startCol)
    {
        int size = inputMatrix.GetLength(0);
        int[,] passed = new int[size, size];
        Queue<HelpNode> queue = new Queue<HelpNode>();
        int[,] matrix = ParseMatrix(inputMatrix);
        HelpNode startNode = new HelpNode(startRow, startCol);
        passed[startRow, startCol] = 1;
        matrix[startRow, startCol] = 0;
        queue.Enqueue(startNode);

        while (queue.Count > 0)
        {
            HelpNode currNode = queue.Peek();
            int row = currNode.Row;
            int col = currNode.Col;

            List<HelpNode> children = new List<HelpNode>()
            { 
                new HelpNode(row + 1, col), new HelpNode(row - 1, col),
                new HelpNode(row, col + 1), new HelpNode(row, col - 1)
            };

            foreach (var child in children)
            {
                if (inBounds(child.Row, child.Col, size) 
                    && matrix[child.Row, child.Col] >= 0 
                    && passed[child.Row, child.Col] == 0)
                {
                    matrix[child.Row, child.Col] = matrix[row, col] + 1;
                    queue.Enqueue(new HelpNode(child.Row, child.Col));
                }
            }

            passed[row, col] = 1;
            queue.Dequeue();
        }

        PrintMatrix(matrix, startRow, startCol);
    }

    // Checks whether the row and col are in array bounds
    public static bool inBounds(int row, int col, int size)
    {
        if (row >=0 && col >= 0 && row < size && col < size)
	    {
            return true;
	    }
        return false;
    }

    // Converts string matrix to integer matrix
    static int[,] ParseMatrix(string[,] matrix)
    {
        int[,] result = new int[matrix.GetLength(0), matrix.GetLength(1)];

        for (int i = 0; i < matrix.GetLength(0); i++)
        {
            for (int j = 0; j < matrix.GetLength(1); j++)
            {
                switch (matrix[i,j])
                {
                    case "0": result[i, j] = 0; 
                        break;
                    case "x": result[i, j] = -1;
                        break;
                    default: result[i, j] = -2;
                        break;
                }
            }
        }

        return result;
    }

    static void PrintMatrix(int[,] matrix, int startRow, int startCol)
    {
        for (int i = 0; i < matrix.GetLength(0); i++)
        {
            for (int j = 0; j < matrix.GetLength(1); j++)
            {
                if (i == startRow && j == startCol)
                {
                    Console.Write("*".PadRight(3));
                    continue;
                }
                switch (matrix[i,j])
                {
                    case 0: Console.Write("u".PadRight(3));
                        break;
                    case -1: Console.Write("x".PadRight(3));
                        break;
                    default: Console.Write(matrix[i, j].ToString().PadRight(3));
                        break;
                }
            }
            Console.WriteLine();
        }
    }
}

