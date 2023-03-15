using Microsoft.Win32;
using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media.Imaging;

namespace ImageViewer
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
            OpenFileDialog dlg = new OpenFileDialog();
            dlg.DefaultExt = ".jpg"; // Default file extension
            dlg.Filter = "Image files (*.png;*.jpeg;*.jpg;*.gif)|*.png;*.jpeg;*.jpg;*.gif"; // Filter files by extension

            // Process open file dialog box results
            if (dlg.ShowDialog().Value) //nullable ->.Value
            {
                // Open document
                string filename = dlg.FileName;
                string[] words = filename.Split('\\');
                Bestandsnaam.Text = words[words.Length - 1];

                BitmapImage bi = new BitmapImage();
                // BitmapImage.UriSource must be in a BeginInit/EndInit block.
                bi.BeginInit();
                bi.UriSource = new Uri(dlg.FileName, UriKind.RelativeOrAbsolute);
                bi.EndInit();
                // Set the image source.
                Image.Source = bi;
                //Extra
                ImageRotateTransform.Angle = 0;
                ButtonLinks.IsEnabled = true;
                ButtonRechts.IsEnabled = true;
            }

        }

        private void Button_Links(object sender, RoutedEventArgs e)
        {
            Rotate(-90);

        }

        private void Rotate(double hoek)
        {
            ImageRotateTransform.Angle += hoek;
        }

        private void Button_Rechts(object sender, RoutedEventArgs e)
        {
            Rotate(090);
        }

    }
}
