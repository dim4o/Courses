using System;
using System.Collections.Generic;


public class AreasInMatrix
{
    private static readonly HashSet<Tuple<int, int>> Visited = new HashSet<Tuple<int, int>>();
    private static readonly int[] Directions = new int[] { -1, 0, 1, 0, 0, -1, 0, 1 };
    private static int _areas = 0;

    static void Main()
    {
        Console.Write("Number of rows: ");
        int numberOfLines = int.Parse(Console.ReadLine());
        char[][] matrix = new char[numberOfLines][];

        for (int i = 0; i < numberOfLines; i++)
        {
            matrix[i] = Console.ReadLine().ToCharArray();
        }

        Dictionary<char, int> lettersMap = new Dictionary<char, int>();

        for (int row = 0; row < matrix.Length; row++)
        {
            for (int col = 0; col < matrix[0].Length; col++)
            {
                if (!Visited.Contains(new Tuple<int, int>(row, col)))
                {
                    _areas++;
                    DFS(matrix, new Tuple<int, int>(row, col));

                    if (!lettersMap.ContainsKey(matrix[row][col]))
                    {
                        lettersMap[matrix[row][col]] = 0;
                    }
                    lettersMap[matrix[row][col]]++;
                }
            }
        }

        Console.WriteLine("Areas: {0}", _areas);
        foreach (var pair in lettersMap)
        {
            Console.WriteLine("Letter '{0}' -> {1}", pair.Key, pair.Value);
        }
    }

    private static void DFS(char[][] matrix, Tuple<int, int> cell)
    {
        if (!Visited.Contains(cell))
        {
            Visited.Add(cell);
            foreach (var child in GetChildren(matrix, cell.Item1, cell.Item2))
            {
                DFS(matrix, child);
            }
        }
    }

    private static IEnumerable<Tuple<int, int>> GetChildren(char[][] matrix, int row, int col)
    {
        for (int i = 0; i < Directions.Length; i += 2)
        {
            int ii = Directions[i];
            int jj = Directions[i + 1];
            if (IsValidCell(matrix, row + ii, col + jj) &&
                matrix[row][col] == matrix[row + ii][col + jj])
            {
                yield return new Tuple<int, int>(row + ii, col + jj);
            }
        }
    }
    private static bool IsValidCell(char[][] matrix, int i, int j)
    {
        if (i >= 0 && j >= 0 &&
            i < matrix.Length &&
            j < matrix[0].Length)
        {
            return true;
        }
        return false;
    }
    //char[,] matrix =
    //{
    //    {'a', 's', 's', 's', 'a', 'a', 'd', 'a', 's'},
    //    {'a', 'd', 's', 'd', 'a', 's', 'd', 'a', 'd'},
    //    {'s', 'd', 's', 'd', 'a', 'd', 's', 'a', 's'},
    //    {'s', 'd', 'a', 's', 'd', 's', 'd', 's', 'a'},
    //    {'s', 's', 's', 's', 'a', 's', 'd', 'd', 'd'},
    //};

    //char[,] matrix =
    //{
    //    {'a', 'a', 'c', 'c', 'c', 'a', 'a', 'c',},
    //    {'b', 'a', 'a', 'a', 'a', 'c', 'c', 'c',},
    //    {'b', 'a', 'a', 'b', 'a', 'c', 'c', 'c',},
    //    {'b', 'b', 'd', 'a', 'a', 'c', 'c', 'c',},
    //    {'c', 'c', 'd', 'c', 'c', 'c', 'c', 'c',},
    //    {'c', 'c', 'd', 'c', 'c', 'c', 'c', 'c',}
    //};

    //char[,] matrix =
    //{
    //    {'a', 'a', 'a'},
    //    {'a', 'a', 'a'},
    //    {'a', 'a', 'a'},
    //};
}

