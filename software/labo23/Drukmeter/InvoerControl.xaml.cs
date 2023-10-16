using Druk;
using System;
using System.Windows.Controls;

namespace Drukmeter
{
    /// <summary>
    /// Interaction logic for InvoerControl.xaml
    /// </summary>
    public partial class InvoerControl : UserControl, IObserver
    {
        ISubject druk;
        public InvoerControl(ISubject druk)
        {
            InitializeComponent();
           
            this.druk = druk;
            druk.Register(this);
            lblEenheid.Content = druk.Eenheid;
            groupBox.Header = "druk in " + druk.Naam;
            }

        private void btnVerlaag_Click(object sender, System.Windows.RoutedEventArgs e)
        {
            druk.Druk -= 1;
        }

        private void btnVerhoog_Click(object sender, System.Windows.RoutedEventArgs e)
        {
            druk.Druk+= 1;
        }
        private void txtWaarde_KeyDown(object sender, System.Windows.Input.KeyEventArgs e)
        {
            if (e.Key == System.Windows.Input.Key.Enter)
            {
                druk.Druk = double.Parse(txtWaarde.Text);
                txtWaarde.Text = Convert.ToString(druk.Druk);
            }
        }

        public void Update()
        {
            txtWaarde.Text = Convert.ToString(druk.Druk);
            txtMax.Text = Convert.ToString(druk.Max);
        }
    }
}
