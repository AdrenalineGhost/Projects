using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media.Imaging;

namespace Blaadjes.pattern {
    internal class Blad:AVoorwerp
    {
        private Random random = new Random();

        public Blad(string soort):base(soort)
        {           
        }

        //Extra parameter nodig indien verschillende afmetingen gewenst
        public override double GetX(double x)
        {
            int richting = random.Next(3) - 1; //-1,O of 1
            return x + richting * size/2;
        }
    }
}


