using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media.Imaging;

namespace Blaadjes.pattern
{
    internal abstract class AVoorwerp : IVoorwerp
    {        
        BitmapImage bitmap;//houdt enkel bitmapImage bij
        protected int size = 30; //altijd hetzelfde
        public AVoorwerp(string soort)
        {
            string bestandsnaam = $"images\\{soort}.png"; //string interpolation met $
            Uri uri = new Uri(bestandsnaam, UriKind.Relative);
            bitmap = new BitmapImage(uri);//dure operatie
            Console.WriteLine($"Bitmap wordt gemaakt voor {soort}");        
        }

        //bij variabele afmetingen moet je de afmeting meegeven als parameter -> functie
        public Image VoorwerpImage
        {
            get
            {
                Image image = new Image();
                image.Width = size;
                image.Height = image.Width;
                image.Source = bitmap;
                return image;
            }
        }

        //Extra parameter nodig indien verschillende afmetingen gewenst
        public Point Move(Point pos)
        {
                
            pos.X = Math.Max(0, GetX(pos.X) ); //nooit negatief          

            pos.Y += size / 2; //altijd halve figuur naar beneden
            return pos;
        }
        
        //Extra parameter nodig indien verschillende afmetingen gewenst
        public abstract double GetX(double x);
    }
}
