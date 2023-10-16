using System.Windows;
using System.Windows.Controls;

namespace Blaadjes.pattern
{
    internal interface IVoorwerp
    {
        //Extra parameter nodig indien verschillende afmetingen gewenst
        Image VoorwerpImage { get;}

       
        Point Move(Point p);
    }
}
