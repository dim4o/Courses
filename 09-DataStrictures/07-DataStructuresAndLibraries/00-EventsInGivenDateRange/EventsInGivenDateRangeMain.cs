using System;
using System.Globalization;
using System.Threading;
using Wintellect.PowerCollections;

namespace _00_EventsInGivenDateRange
{
    class EventsInGivenDateRangeMain
    {
        static void Main()
        {
            Thread.CurrentThread.CurrentCulture = CultureInfo.InvariantCulture;

            var events = new OrderedMultiDictionary<DateTime, string>(true);

            int numberOfEvents = int.Parse(Console.ReadLine());

            for (int i = 0; i < numberOfEvents; i++)
            {
                string eventEntry = Console.ReadLine();
                var eventTokens = eventEntry.Split('|');
                string eventName = eventTokens[0].Trim();
                DateTime eventDate = DateTime.Parse(eventTokens[1].Trim());
                events.Add(eventDate, eventName);
            }

            int numberOfRanges = int.Parse(Console.ReadLine());
            Console.WriteLine();
            for (int i = 0; i < numberOfRanges; i++)
            {
                string rangeEntry = Console.ReadLine();
                string[] rangesEntry = rangeEntry.Split('|');
                DateTime startDate = DateTime.Parse(rangesEntry[0].Trim());
                DateTime endDate = DateTime.Parse(rangesEntry[1].Trim());
                var eventsInRange = events.Range(startDate, true, endDate, true);

                Console.WriteLine(eventsInRange.KeyValuePairs.Count);
                foreach (var e in eventsInRange)
                {
                    foreach (var eventName in e.Value)
                    {
                        Console.WriteLine("{0} | {1:dd-MMM-yyyy}", eventName, e.Key);
                    }
                }
                Console.WriteLine();
            }
        }
    }
}
