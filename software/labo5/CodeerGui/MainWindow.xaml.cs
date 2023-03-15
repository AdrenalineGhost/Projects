using Coderingen;
using System;
using System.Windows;
using System.Windows.Controls;

namespace CodeerGui
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        Helper helper = new();
        ICodering codering;
        public MainWindow()
        {
            InitializeComponent();
           //codering = helper["Blok"];
           //Blok.IsChecked = true;
            InitButtons();
        }

        private void InitButtons()
        {
            int i = 0;
            foreach (string type in helper.Keys)
            {
                RadioButton button = new()
                {
                    Content = type,
                    GroupName = "Codering",
                    VerticalAlignment = VerticalAlignment.Center,
                    HorizontalAlignment = HorizontalAlignment.Center
                };
                button.Checked += Radio_Checked;
                ColumnDefinition col = new();
                gridCodeer.ColumnDefinitions.Add(col);
                gridCodeer.Children.Add(button);
                Grid.SetRow(button, 2);
                Grid.SetColumn(button, i);
                if (i == 0)
                {
                    button.IsChecked = true;
                    codering = helper[type];
                }
                i += 1;
            }
        }

        private void Radio_Checked(object sender, RoutedEventArgs e)
            {
                RadioButton button = (RadioButton)sender;
                string? type = button.Content.ToString();
                if (type != null)
                {
                    codering = helper[type];
                    uitvoer.Text = codering.Codeer(invoer.Text);
                }
            }


            private void Invoer_TextChanged(object sender, TextChangedEventArgs e)
            {
                uitvoer.Text = codering.Codeer(invoer.Text);
            }
    }
}
