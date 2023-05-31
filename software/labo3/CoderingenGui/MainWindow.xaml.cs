using System;
using System.Windows;
using System.Windows.Controls;

namespace CoderingenGui
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private bool[] _radioArray = new bool[] { true, false, false };
        public bool[] RadioArray { get { return _radioArray; } }
        public int SelectedRadio { get { return Array.IndexOf(_radioArray, true); } }
        public MainWindow()
        {
            InitializeComponent();
        }


        private void RadioButton_Checked(object sender, RoutedEventArgs e)
        {

        }

        private void TextBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            //    switch ((RadioArray[0]?1:0) + (RadioArray[1]?2:0) + (RadioArray[2]?3:0))
            // resultText.Text = "" + ((RadioArray[0]?1:0) + (RadioArray[1]?2:0) + (RadioArray[2]?3:0)).ToString() + " - " + inputText.Text;
            switch (SelectedRadio)
            {
                case 0:
                    resultText.Text = Coderingen.blok(inputText.Text);
                    break;
                case 1:
                    resultText.Text = Coderingen.wissel(inputText.Text);
                    break;
                case 2:
                    resultText.Text = Coderingen.cijfer(inputText.Text);
                    break;
                default:
                    break;
            }
        }
    }
}
