using System;
using System.Collections.Generic;

namespace _02_BiDictionary
{
    class BiDictionary<TKey1, TKey2, T>
    {
        private readonly Dictionary<TKey1, List<T>> _valuesByFirstKey = 
            new Dictionary<TKey1, List<T>>();

        private readonly Dictionary<TKey2, List<T>> _valuesBySecondKey = 
            new Dictionary<TKey2, List<T>>();

        private readonly Dictionary<Tuple<TKey1, TKey2>, List<T>> _valuesByBothKeys = 
            new Dictionary<Tuple<TKey1, TKey2>, List<T>>();

        /// <summary>
        /// Adds value by two keys
        /// </summary>
        /// <param name="firstKey"> First key </param>
        /// <param name="secondKey"> Second key </param>
        /// <param name="value"> The value to add </param>
        public void Add(TKey1 firstKey, TKey2 secondKey, T value)
        {
            _valuesByFirstKey.EnsureKeyExists(firstKey);
            _valuesByFirstKey[firstKey].Add(value);

            _valuesBySecondKey.EnsureKeyExists(secondKey);
            _valuesBySecondKey[secondKey].Add(value);

            var bothKeys = new Tuple<TKey1, TKey2>(firstKey, secondKey);
            _valuesByBothKeys.EnsureKeyExists(bothKeys);
            _valuesByBothKeys[bothKeys].Add(value);
        }

        /// <summary>
        /// Finds values by two keys
        /// </summary>
        /// <param name="firstKey"> First key </param>
        /// <param name="secondKey"> Second key</param>
        /// <returns> List of values </returns>
        public IEnumerable<T> Find(TKey1 firstKey, TKey2 secondKey)
        {
            var bothKeys = new Tuple<TKey1, TKey2>(firstKey, secondKey);

            if (!_valuesByBothKeys.ContainsKey(bothKeys))
            {
                return new List<T>();
            }
            return _valuesByBothKeys[bothKeys];
        }

        /// <summary>
        /// Finds values by first key
        /// </summary>
        /// <param name="firstKey"> First key </param>
        /// <returns> List of values</returns>
        public IEnumerable<T> FindByKey1(TKey1 firstKey)
        {
            if (!_valuesByFirstKey.ContainsKey(firstKey))
            {
                return new List<T>();
            }
            return _valuesByFirstKey[firstKey];
        }

        /// <summary>
        /// Finds values by second key
        /// </summary>
        /// <param name="secondKey"> Second key </param>
        /// <returns> List of values</returns>
        public IEnumerable<T> FindByKey2(TKey2 secondKey)
        {
            if (!_valuesBySecondKey.ContainsKey(secondKey))
            {
                return new List<T>();
            }
            return _valuesBySecondKey[secondKey];
        }

        /// <summary>
        /// Removes values by two keys
        /// </summary>
        /// <param name="firstKey"> First key </param>
        /// <param name="secondKey"> Second key </param>
        /// <returns> Is the values are removed successfully </returns>
        public bool Remove(TKey1 firstKey, TKey2 secondKey)
        {
            var bothKeys = new Tuple<TKey1, TKey2>(firstKey, secondKey);

            if (!_valuesByBothKeys.ContainsKey(bothKeys))
            {
                return false;
            }

            var values = _valuesByBothKeys[bothKeys];
            _valuesByBothKeys.Remove(bothKeys);

            foreach (var value in values)
            {
                if (_valuesByFirstKey[firstKey].Contains(value))
                {
                    _valuesByFirstKey[firstKey].Remove(value);
                }

                if (_valuesBySecondKey[secondKey].Contains(value))
                {
                    _valuesBySecondKey[secondKey].Remove(value);
                }
            }

            return true;
        }
    }
}
