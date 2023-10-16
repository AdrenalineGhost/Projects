using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Blaadjes.pattern
{
    internal class Voorwerp
    {
        static Dictionary<string, Voorwerp> dict = new Dictionary<string, Voorwerp>()
        {
            {"blad", Blad };
            {"veer", Veer };
        };
        


        public Voorwerp(string soort) 
        {
            
        }
    }
}
