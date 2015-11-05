/*
 * Very slow for int values >= 8
 */
using System;

namespace _03_KnightsTourWithBacktracking
{
    class KnightsTourWithBacktracking
    {
        private static readonly int[] Directions = { 1, 2, -1, 2, 2, 1, 1, -2, -1, -2, -2, 1, 2, -1, -2, -1 };
        
        static void Main()
        {
            int size = int.Parse(Console.ReadLine());
            int[,] board = new int[size,size];
            StartKnightTour(board, 0, 0, 1);
        }

        private static void StartKnightTour(int[,] board, int row, int col, int step)
        {
            board[row, col] = step;
            if (step == board.GetLength(0) * board.GetLength(0))
            {
                PrintBoard(board);
                return;
            }
           
            for (int i = 0; i < Directions.Length; i+=2)
            {
                int currentRow = row + Directions[i];
                int currentCol = col + Directions[i + 1];
                if (IsInBounds(currentRow, currentCol, board.GetLength(0)) && 
                    board[currentRow, currentCol] == 0)
                {
                    StartKnightTour(board, currentRow, currentCol, step + 1);
                }
            }

            board[row, col] = 0;
        }

        private static bool IsInBounds(int row, int col, int size)
        {
            return !(row >= size || col >= size || row < 0 || col < 0);
        }

        private static void PrintBoard(int[,] board)
        {
            for (int i = 0; i < board.GetLength(0); i++)
            {
                for (int j = 0; j < board.GetLength(1); j++)
                {
                    Console.Write(board[i, j].ToString().PadLeft(4));
                }
                Console.WriteLine();
            }
        }
    }
}
