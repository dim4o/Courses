using System;

namespace _01_BinomialCoefficients
{
    public class BinomialCoefficients
    {
        private const int StartRow = 2;
        private const int StartCol = 1;

        private static void Main()
        {
            Console.Write("N = ");
            int n = int.Parse(Console.ReadLine());
            Console.Write("K = ");
            int k = int.Parse(Console.ReadLine());

            Console.WriteLine("C({0}, {1}) = {2}", n, k, GetCoefficient(n, k));
        }

        public static int GetCoefficient(int n, int k)
        {
            if (k > n)
            {
                throw new InvalidOperationException("\"N must be greater or equal to K\"");
            }

            int[,] matrix = new int[n + 1, k + 1];

            // Initialization of the Pascal's Triangle
            for (int i = 0; i <= n; i++)
            {
                matrix[i, 0] = 1;
                if (i <= k)
                {
                    matrix[i, i] = 1;
                }
            }

            // Calculation ot the binomial coefficients for <=N & <=K
            for (int row = StartRow; row <= n; row++)
            {
                int col = StartCol;
                while (col <= k && matrix[row, col] != 1)
                {
                    matrix[row, col] = matrix[row - 1, col] + matrix[row - 1, col - 1];
                    col++;
                }
            }

            return matrix[n, k];
        }
    }
}
