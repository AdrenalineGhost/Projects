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

namespace Blaadjes
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        List<Blad> blaadjes = new();
        public MainWindow()
        {
            InitializeComponent();
           // for (int i=0; i<5;i++) AddBlad();
            DispatcherTimer dispatcherTimer = new();
            dispatcherTimer.Tick += timerEvent;
            dispatcherTimer.Interval = new TimeSpan(0, 0, 0, 0, 100);
            dispatcherTimer.Start();

        }

        private void timerEvent(object? sender, EventArgs e)
        {        
            Blad blaadje = new();
            blaadje.Add(canvas);
            blaadjes.Add(blaadje);
            foreach(Blad blad in blaadjes)
            {
                blad.Move(canvas);
            }
            
        }

        private void AddBlad()
        {
            Blad blaadje= new Blad();
            blaadje.Add(canvas);
        }
        private void AddBlad_ori()
        {
            Image BladImage = new()
            {
                Width = 50,
                Height = 50
            };
            Uri uri = new Uri("Images\\blad.png",UriKind.Relative);
            BladImage.Source = new BitmapImage(uri);
            canvas.Children.Add(BladImage);
            Canvas.SetLeft(BladImage, 50);
            Canvas.SetTop(BladImage, 50);
        }
    }
}
