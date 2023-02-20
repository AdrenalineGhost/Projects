using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace labo1._1
{
    internal class Student:Person
    {
        public Student(string name) : base(name) { }
        internal string welcomeMessage { get { return "Fuck"} }
    }
}
