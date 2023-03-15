using Coderingen;
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

namespace CodeerGui2
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        ICodering? codering;
        public MainWindow()
        {
            InitializeComponent();
            InitButtons();
        }

        private void InitButtons()
        {
            Helper helper = new();
            int i = helper.Keys.Length - 1;
            foreach (string type in helper.Keys)
            {
                RadioButton button = new()
                {
                    Content = helper[type],
                    GroupName = "Codering",                    
                    VerticalAlignment = VerticalAlignment.Center,
                    HorizontalAlignment = HorizontalAlignment.Center
                };
                button.Checked += Radio_Checked;
                ColumnDefinition col = new ();
                gridCodeer.ColumnDefinitions.Add(col);
                gridCodeer.Children.Add(button);
                Grid.SetRow(button, 2);
                Grid.SetColumn(button, i);
                i -= 1;

                button.IsChecked = true;
                codering = helper[type];
            }
        }

        private void Radio_Checked(object sender, RoutedEventArgs e)
        {
            RadioButton button = (RadioButton)sender;
            codering = (ICodering)button.Content;
            uitvoer.Text = codering?.Codeer(invoer.Text);
        }

        private void Invoer_TextChanged(object sender, TextChangedEventArgs e)
        {
            uitvoer.Text = codering?.Codeer(invoer.Text);
        }
    }
}
