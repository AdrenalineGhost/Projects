using System;
using System.Collections.Generic;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media.Imaging;

namespace Blaadjes.pattern
{
    internal class Blad
    {
        static Random random = new Random();
        static string[] afbeeldingen = { "blad", "groenBlad", "roodBlad" };
        Point pos;
        public Image BladImage { get; private set; }

        public Blad()
        {
            string soort = afbeeldingen[random.Next(afbeeldingen.Length)];
            BladImage = new Image();
            BladImage.Width = 30;
            BladImage.Height = BladImage.Width;
            
            BladImage.Source = ImageCache.Instance.GetImage(soort);

        }

        public void Move(Canvas canvas)
        {
            int richting = random.Next(3) - 1; //-1,O of 1
            pos.X = Math.Max(0, pos.X + richting * (BladImage.Width / 2)); //nooit negatief
            pos.X = Math.Min(pos.X, canvas.ActualWidth - BladImage.Width / 2); // niet buiten canvas
            pos.Y = pos.Y + BladImage.Height / 2; //altijd halve figuur naar beneden
            
            if (pos.Y > canvas.ActualHeight)
            {
                canvas.Children.Remove(BladImage);
            }
            else
            {
                Canvas.SetLeft(BladImage, pos.X);
                Canvas.SetTop(BladImage, pos.Y);
            }
        }

        public void Add(Canvas canvas)
        {
            pos.X = BladImage.Width / 2 + random.NextDouble() * (canvas.ActualWidth - BladImage.Width);
            pos.Y = BladImage.Height / 2;
            canvas.Children.Add(BladImage);
            Canvas.SetLeft(BladImage, pos.X);
            Canvas.SetTop(BladImage, pos.Y);
        }

    }
}
