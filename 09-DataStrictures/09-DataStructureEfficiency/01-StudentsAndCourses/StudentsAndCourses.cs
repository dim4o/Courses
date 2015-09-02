using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace _01_StudentsAndCourses
{
    static class StudentsAndCourses
    {
        static void Main()
        {
            var studentsByCourse = new SortedDictionary<string, SortedSet<Student>>();
            var reader = new StreamReader("../../students.txt");

            // Read and parse students.txt
            using (reader)
            {
                var currentLine = reader.ReadLine();

                while (currentLine != null)
                {
                    var personInfo = currentLine.Split('|');
                    var firstName = personInfo[0].Trim();
                    var lastName = personInfo[1].Trim();
                    var courseName = personInfo[2].Trim();
                    var currentStudent = CreateStudent(firstName, lastName, courseName);

                    if (!studentsByCourse.ContainsKey(courseName))
                    {
                        studentsByCourse.Add(courseName, new SortedSet<Student>());
                    }
                    studentsByCourse[courseName].Add(currentStudent);

                    currentLine = reader.ReadLine();
                }
            }

            // Prints result
            foreach (var course in studentsByCourse)
            {
                Console.WriteLine("{0}: {1}", course.Key, 
                    string.Join(", ", course.Value.Select(s => s.FirstName + " " + s.LastName)));
            }
        }

        private static Student CreateStudent(string firstName, string lastName, string courseName)
        {
            var student = new Student()
            {
                FirstName =  firstName, LastName = lastName, CourseName = courseName
            };
            return student;
        }
    }
}
