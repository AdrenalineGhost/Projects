using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace labo1._1
{
    abstract internal class Person
    {
        readonly string name = "";
        public string Name { get { return name; } }
        public Person(string name) {  this.name = name; }
        internal string welcomeMessage { get { return "Hello " + name; } } 
    }
}
