using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace Blaadjes.pattern
{
    internal class Pluim : AVoorwerp
    {

        public Pluim() : base("pluim")
        {

        }

        //Extra parameter nodig indien verschillende afmetingen gewenst
        public override double GetX(double x)
        {
            return x + size/2;       }
    }
}
