using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace _01_StudentsAndCourses
{
    class Student : IComparable<Student>
    {
        public string FirstName { get; set; }

        public string LastName { get; set; }

        public string CourseName { get; set; }

        public int CompareTo(Student other)
        {
            if (this.LastName.CompareTo(other.LastName) == 0)
            {
                return this.FirstName.CompareTo(other.FirstName);
            }

            return this.LastName.CompareTo(other.LastName);
        }
    }
}
