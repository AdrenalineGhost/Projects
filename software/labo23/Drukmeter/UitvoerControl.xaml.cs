using Druk;
using System;
using System.Windows.Controls;

namespace Drukmeter
{
    /// <summary>
    /// Interaction logic for UitvoerControl.xaml
    /// </summary>
    public partial class UitvoerControl : UserControl,IObserver
    {
       
        ISubject druk;
        public UitvoerControl(ISubject druk)
        {

            InitializeComponent();
            this.druk = druk;
            Type.Content= druk.Naam;
            Value.Content = druk.Druk;
            druk.Register(this);
            UpdateWijzer();
        }

        public void Update()
        {
            UpdateWijzer();
        }

        private void UpdateWijzer()
        {

            double currentAngle = (5.0 / 4.0) * Math.PI - (druk.Druk / druk.Max) * (Math.PI * 3.0 / 2.0);
            wijzer.X2 = 100 + 60 * Math.Cos(currentAngle);
            wijzer.Y2 = 100 - 60 * Math.Sin(currentAngle);
            Value.Content = Math.Round(druk.Druk, 2) + " " + druk.Eenheid;
        }
    }
}
