using System;
using Wintellect.PowerCollections;

namespace _04_StringEditor
{
    class StringEditor
    {
        private static readonly BigList<char> Rope = new BigList<char>();

        public string Word
        {
            get
            {
                return String.Join("", Rope);
            }
        }

        public StringEditor(string word = "")
        {
            Rope.AddRange(word.ToCharArray());
        }

        public void Insert(string word, int position)
        {
            if (!IsValidIndex(position))
            {
                Console.WriteLine("ERROR");
                return;
            }
            Rope.InsertRange(position, word.ToCharArray());
        }

        public void Append(string word)
        {
            Rope.AddRange(word.ToCharArray());
        }

        public void Delete(int startIndex, int count)
        {
            if (!IsValidIndex(startIndex) || !IsValidIndex(startIndex + count - 1))
            {
                Console.WriteLine("ERROR");
                return;
            }
            Rope.RemoveRange(startIndex, count);
        }

        public void Replace(int startIndex, int count, string word)
        {
            Delete(startIndex, count);
            Insert(word, startIndex);
        }

        public void Print()
        {
            Console.WriteLine(this.Word);
        }

        private static bool IsValidIndex(int index)
        {
            if (index >= Rope.Count || index < 0)
            {
                return false;
            }

            return true;
        }
    }
}
