using System;
using System.Collections.Generic;

using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media.Imaging;

namespace Blaadjes
{
    internal class Blad
    {
        static Random random = new ();
        static string[] afbeeldingen = { "blad", "groenBlad", "roodBlad" };
        Image image;
        Point pos;
        public Blad() {
            image = new Image()
            {
                Width = random.Next(15, 40),
            };
            image.Height = image.Width;
            string soort = afbeeldingen[random.Next(afbeeldingen.Length)];
            string bestandsnaam = $"images\\{soort}.png"; //string interpolation met $
            Uri uri = new Uri(bestandsnaam, UriKind.Relative);
            image.Source = new BitmapImage(uri);
        }

        public void Move(Canvas canvas)
        {
            int richting = random.Next(3) - 1; //-1,O of 1
            pos.X = Math.Max(0, pos.X + richting * (image.Width / 2)); //nooit negatief
            pos.X = Math.Min(pos.X, canvas.ActualWidth - image.Width / 2); // niet buiten canvas
            pos.Y = pos.Y + image.Height / 2; //altijd halve figuur naar beneden
            Canvas.SetLeft(image, pos.X);
            Canvas.SetTop(image, pos.Y);
            if (pos.Y > canvas.ActualHeight - image.Height) //gaat buiten canvas
            {
                canvas.Children.Remove(image);
            }
        }

        public void Add(Canvas canvas)
        {
            pos.X = image.Width / 2 + random.NextDouble() * (canvas.ActualWidth - image.Width);
            pos.Y = image.Height / 2;
            canvas.Children.Add(image);
            Canvas.SetLeft(image, pos.X);
            Canvas.SetTop(image, pos.Y);
        }

    }
}
