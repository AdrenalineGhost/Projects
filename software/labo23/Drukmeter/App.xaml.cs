using Druk;
using System.Windows;
using System.Windows.Controls;

namespace Drukmeter
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App : Application
    {
        protected override void OnStartup(StartupEventArgs e)
        {
            base.OnStartup(e);

            ISubject druk = new DrukPascal();
            var mainWindow = new MainWindow(new InvoerControl(druk), new UitvoerControl(druk));
            mainWindow.Show();
        }

    }
}
