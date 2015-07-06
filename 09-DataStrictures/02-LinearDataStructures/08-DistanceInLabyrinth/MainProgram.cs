using System;

class DistanceInLabyrinthTest
{
    static void Main()
    {
        string[,] inputMatrix0 = 
        {
            {"0", "0", "0", "x", "0", "x"},
            {"0", "x", "0", "x", "0", "x"},
            {"0", "*", "x", "0", "x", "0"},
            {"0", "x", "0", "0", "0", "0"},
            {"0", "0", "0", "x", "x", "0"},
            {"0", "0", "0", "x", "0", "x"},
        };

        DistanceInLabyrinth.CalcDistance(inputMatrix0, 2, 1);

        Console.WriteLine();

        string[,] inputMatrix1 = 
        {
            {"0", "0", "0", "x", "0", "x", "0"},
            {"0", "x", "0", "x", "0", "x", "0"},
            {"0", "0", "x", "0", "x", "0", "0"},
            {"0", "x", "0", "0", "0", "0", "0"},
            {"0", "0", "*", "x", "x", "0", "0"},
            {"0", "0", "0", "x", "0", "x", "0"},
            {"0", "0", "0", "x", "0", "x", "0"},
        };

        DistanceInLabyrinth.CalcDistance(inputMatrix1, 4, 2);

        Console.WriteLine();

        string[,] inputMatrix2 = 
        {
            {"0", "0", "0", "x", "0", "x", "0", "x"},
            {"0", "x", "0", "x", "0", "x", "0", "x"},
            {"0", "0", "x", "0", "x", "0", "0", "0"},
            {"0", "x", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "x", "x", "0", "*", "x"},
            {"0", "0", "0", "x", "0", "x", "0", "x"},
            {"0", "0", "0", "x", "0", "x", "0", "x"},
            {"0", "x", "0", "0", "0", "0", "0", "0"}
        };

        DistanceInLabyrinth.CalcDistance(inputMatrix2, 4, 6);
    }
}

