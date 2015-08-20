using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace _01_FindWordsInFile
{
    class FindWordsInFileMain
    {
        static void Main()
        {
            int numberOfLines = int.Parse(Console.ReadLine());
            Regex regex = new Regex(@"[\s+?!.,;-]+");
            var wordsMap = new Dictionary<string, int>(); 

            for (int i = 0; i < numberOfLines; i++)
            {
                string currentLine = Console.ReadLine();
                IEnumerable<string> words = regex.Split(currentLine).Where(w => w != String.Empty);

                foreach (var word in words)
                {
                    if (!wordsMap.ContainsKey(word))
                    {
                        wordsMap[word] = 0;
                    }
                    wordsMap[word]++;
                }
            }

            int numberOfWordsToFind = int.Parse(Console.ReadLine());

            for (int i = 0; i < numberOfWordsToFind; i++)
            {
                string currentWord = Console.ReadLine();

                Console.WriteLine("{0} -> {1}", currentWord, 
                    wordsMap.ContainsKey(currentWord) ? wordsMap[currentWord] : 0);
            }
        }
    }
}
