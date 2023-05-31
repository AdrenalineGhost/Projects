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

namespace Chrono
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }


        private void Button_Click(object sender, RoutedEventArgs e)
        {
            var dpt = new System.Windows.Threading.DispatcherTimer();
            var counter = 0;
            dpt.Tick += new EventHandler((x,y)=> { displayText.Content = counter; counter++; });
            dpt.Interval = new TimeSpan(0, 0, 1);
            if (sender.Equals(start))
            {
                dpt.Start();
            }

            if (sender.Equals(stop))
            {
                dpt.Stop();
            }

        }

    }
}
