using Blaadjes.pattern;
using System;
using System.Collections.Generic;
using System.Windows;
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
            DispatcherTimer dispatcherTimer = new DispatcherTimer();
            dispatcherTimer.Tick += timerEvent;
            dispatcherTimer.Interval = new TimeSpan(0, 0, 0, 0, 100);
            dispatcherTimer.Start();
            //AddBlad();
        }

        private void timerEvent(object sender, EventArgs e)
        {
            Blad blaadje = new Blad();
            blaadje.Add(canvas);
            blaadjes.Add(blaadje);
            foreach (Blad blad in blaadjes)
            {
                blad.Move(canvas);
            }
        }
    }
}
