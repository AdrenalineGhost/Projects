using Blaadjes.pattern;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Threading;

namespace Blaadjes_Size_Willekeurig
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Random random = new();

        //Indien afmetingen variabel, dan hier ook de afmeting bijhouden!!
        Dictionary<string, IList<Point>> posities = new();
        Dictionary<string, IList<int>> sizes = new();  //kan ook in dezelfde dictionary

        VoorwerpFactory factory = new();

        public MainWindow()
        {
            InitializeComponent();
            foreach (string soort in VoorwerpFactory.SOORTEN)
            {
                posities.Add(soort, new List<Point>());
                sizes.Add(soort, new List<int>());
            }

            DispatcherTimer dispatcherTimer = new DispatcherTimer();
            dispatcherTimer.Tick += timerEvent;
            dispatcherTimer.Interval = new TimeSpan(0, 0, 0, 0, 100);
            dispatcherTimer.Start();
            //AddBlad();
        }

        private void timerEvent(object sender, EventArgs e)
        {
            canvas.Children.Clear();  //alles wissen

            foreach (string type in posities.Keys)
            {
                IVoorwerp voorwerp = factory[type];
                for (int i = 0; i < posities[type].Count; i++)
                {
                    Point p = posities[type][i];
                    int size = sizes[type][i];
                    p = voorwerp.Move(p, size);
                    p.X = Math.Min(p.X, Width);  //binnen kader Canvas
                    p.X = Math.Min(p.X, canvas.ActualWidth);

                    posities[type][i] = p;
                    //hier kan je controleren of je onderaan bent, en het punt dan verwijderen uit posities
                    if (p.Y > canvas.ActualHeight)
                    {
                        posities[type].RemoveAt(i);
                        sizes[type].RemoveAt(i);
                    }
                    else
                    {
                        Draw(voorwerp, p);

                    }
                }
            }
            if (random.Next(10) > 0)
                AddBlad();
            else
                AddPluim();
        }

        private void Draw(IVoorwerp voorwerp, Point p)
        {
            //indien afmetingen variabel, moet je de gewenste afmeting meegeven bij het ophalen van de image
            Image simpleImage = voorwerp.VoorwerpImage;
            canvas.Children.Add(simpleImage);
            Canvas.SetLeft(simpleImage, p.X);
            Canvas.SetTop(simpleImage, p.Y);
        }

        private void AddBlad()
        {
            string type = factory.KiesBlad();
            Point p = new Point(random.Next((int)Width - 20) + 10, 20);
            posities[type].Add(p);
            sizes[type].Add(random.Next(30) + 10);
        }

        private void AddPluim()
        {
            int aantal = VoorwerpFactory.SOORTEN.Length;
            string type = VoorwerpFactory.SOORTEN[aantal - 1];
            Point p = new Point(20, 20);
            posities[type].Add(p);
            sizes[type].Add(random.Next(30) + 10);

        }
    }
}
