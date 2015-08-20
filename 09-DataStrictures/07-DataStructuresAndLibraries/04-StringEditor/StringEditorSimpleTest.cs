using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace _04_StringEditor
{
    class StringEditorSimpleTest
    {
        private static readonly Random Rand = new Random();
        private const string Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefjhijklmnopqrstuvwxyz";
        static void Main()
        {
            //string input = "1 2 3 4 5 6";
            //List<int> list = Console.ReadLine().Split(' ').Select(s => int.Parse(s)).ToList();

            List<string> strings = GenerateListOfRandomStrings(1000);
            var w = new StringEditor("start");
            for (int i = 0; i < 10000; i++)
            {
                w.Append(strings[Rand.Next(strings.Count)]);
            }

            for (int i = 0; i < 10000; i++)
            {
                int randomIndex = Rand.Next(strings.Count);
                int randomLength = Rand.Next(strings.Count);
                w.Insert(strings[randomIndex], randomLength);
            }

            for (int i = 0; i < 10000; i++)
            {
                int randomIndex = Rand.Next(0, strings.Count);
                int randomLength = Rand.Next(1, strings.Count);
                string randomWord = GenerateRandomString(randomLength, randomLength);
                w.Replace(randomIndex, randomLength, randomWord);
            }

            for (int i = 0; i < 10000; i++)
            {
                int randomIndex = Rand.Next(0, strings.Count);
                int randomLength = Rand.Next(1, 10);
                w.Delete(randomIndex, randomLength);
            }

            w.Print();
            //var w = new StringEditor("nachalo");
            //w.Append("Append");
            //w.Append("Append");
            //w.Insert("word", 7);
            //w.Replace(7, 4, "WORD");
            //w.Delete(7, 4);
            //w.Print();
        }

        private static List<string> GenerateListOfRandomStrings(int numberOfStrings)
        {
            var words = new List<string>();
            for (int i = 0; i < numberOfStrings; i++)
            {
                words.Add(GenerateRandomString(1, 50));
            }

            return words;
        }

        private static string GenerateRandomString(int minLenght, int maxLength)
        {
            string word = null;
            int length = Rand.Next(minLenght, maxLength + 1);

            for (int i = 0; i < length; i++)
            {
                word += Chars[Rand.Next(0, Chars.Length)];
            }
            
            return word;
        }
    }
}
