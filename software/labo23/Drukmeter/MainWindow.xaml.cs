using System.Windows;
using System.Windows.Controls;


namespace Drukmeter
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        
        // By using the params keyword, you can specify a method parameter that takes a variable number of arguments.
        // The parameter type must be a single-dimensional array.
        public MainWindow(params UserControl[] userControls)
        {
            InitializeComponent();
            Width = 20;
            // Add any number of input- or output controls to the mainwindow
            for (int i = 0; i < userControls.Length; i++)
            {
                AddControl(userControls[i], i);
            }
        }

        private void AddControl(UserControl control, int p)
        {
            grid.ColumnDefinitions.Add(new ColumnDefinition());
            Grid.SetRow(control, 0);
            Grid.SetColumn(control, p);
            grid.Children.Add(control);
            Width += 200; //Aangepast om ook meer kolommen te kunnen toevoegen
        }

    }
}
