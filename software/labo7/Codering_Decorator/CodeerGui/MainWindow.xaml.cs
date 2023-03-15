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

namespace CodeerGUI
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        ICodering codering;
        
        public MainWindow()
        {
            InitializeComponent();
            codering = new NoCodering(); //geen codering
            InitButtons();
        }

        private void InitButtons()
        {
            int k = 0;
            string[] types = { "Cijfer", "Wissel", "Blok" };
            
            // foreach (string type in helper.Keys)
            foreach (string type in types)
            {
                Button button = new Button();
                button.Content = type;
                button.Width = 100;
                button.Height = 50;
                button.Click += Button_Click;
                button.VerticalAlignment = VerticalAlignment.Center;
                button.HorizontalAlignment = HorizontalAlignment.Center;
                ColumnDefinition col = new ColumnDefinition();
                gridCodeer.ColumnDefinitions.Add(col);
                gridCodeer.Children.Add(button);
                Grid.SetRow(button, 0);
                Grid.SetColumn(button, k);
                k += 1;
            }
            
         }

        private void Reset(object sender, RoutedEventArgs e)
        {
            codering = new NoCodering();
            uitvoer.Text = invoer.Text;
        }
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Button button = (Button)sender;
            string type = button.Content.ToString();

            switch (type)
            {
                case "Blok":
                    codering = new Blok(codering);
                    break;
                case "Wissel":
                    codering = new Wissel(codering);
                    break;
                default:
                    codering = new Cijfer(codering);
                    break;
            }
            uitvoer.Text = codering.Codeer(invoer.Text);

        }

        private void Invoer_TextChanged(object sender, TextChangedEventArgs e)
        {
            uitvoer.Text = codering.Codeer(invoer.Text);
        }

        private void Undo(object sender, RoutedEventArgs e)
        {
            codering = codering.Undo();
            uitvoer.Text = codering.Codeer(invoer.Text);
        }
    }
}
