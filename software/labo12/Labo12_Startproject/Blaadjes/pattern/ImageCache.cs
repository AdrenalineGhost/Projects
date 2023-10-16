using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Media.Imaging;
using static System.Net.Mime.MediaTypeNames;

namespace Blaadjes.pattern
{
    internal class ImageCache
    {
        private static ImageCache ImageInstance = new();
        private ImageCache() { }
        public static ImageCache Instance { get {  return ImageInstance; } }

        Dictionary<string, BitmapImage> dict = new Dictionary<string, BitmapImage>();

        public BitmapImage GetImage(string soort)
        {
            try
            {
                return dict[soort];
            }
            catch 
            { 
                string bestandsnaam = $"images\\{soort}.png"; //string interpolation met $
                Console.WriteLine($"Bitmap wordt gemaakt voor {soort}");
                Uri uri = new Uri(bestandsnaam, UriKind.Relative);
                var temp = new BitmapImage(uri);
                dict[soort] = temp;
                return temp;
            }
        }
    }
}
