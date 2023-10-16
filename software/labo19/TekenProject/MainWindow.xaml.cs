using System.Windows;
using System.Windows.Input;
using System.Windows.Shapes;
using TekenProject.Pattern;
using TekenProject.Pattern.Commands;

namespace TekenProject
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        Key previousKey;
        DrawLogic receiver;
        CommandController invoker;

        public MainWindow()
        {
            InitializeComponent();
            receiver = new DrawLogic(this);
            invoker = new CommandController();
            canvas.Focus();
        }

        #region MouseEvents       
        private void canvas_MouseDown(object sender, MouseButtonEventArgs e)
        {
            canvas.CaptureMouse();
            receiver.MouseDown(e.GetPosition(canvas));
        }

        private void canvas_MouseUp(object sender, MouseButtonEventArgs e)
        {
            canvas.ReleaseMouseCapture();
            Shape drawing = receiver.MouseUp(e.GetPosition(canvas));
            invoker.Execute(new DrawCommand(receiver, drawing));
        }
        private void canvas_MouseMove(object sender, MouseEventArgs e)
        {
            receiver.MouseMove(e.GetPosition(canvas));
        }
        #endregion

        private void canvas_KeyDown(object sender, KeyEventArgs e)
        {
            // Could be transformed to a factory to create the correct Command
            ICommando command = null;
            if (e.Key == Key.R)
            {
                command = new ResetWindowCommand(receiver);
            }
            else if (e.Key >= Key.D0 && e.Key <= Key.D9)
            {
                int number = e.Key - Key.D0;
                if (previousKey == Key.F)
                    command = new SetStrokeCommand(receiver, number);
                else if (previousKey == Key.B)
                    command = new SetFillCommand(receiver, number);
            }

            if (command != null)
            {
                invoker.Execute(command);
            }
            previousKey = e.Key;
        }


        private void btnFill_Click(object sender, RoutedEventArgs e)
        {
            invoker.Execute(new ToggleFillCommand(receiver));
        }

        private void btnStroke_Click(object sender, RoutedEventArgs e)
        {
            invoker.Execute(new ToggleStrokeCommand(receiver));
        }

        private void btnPencil_Click(object sender, RoutedEventArgs e)
        {

        }

        private void btnLine_Click(object sender, RoutedEventArgs e)
        {

        }

        private void btnRectangle_Click(object sender, RoutedEventArgs e)
        {

        }

        private void btnEllipse_Click(object sender, RoutedEventArgs e)
        {

        }

        private void btnReset_Click(object sender, RoutedEventArgs e)
        {
            invoker.Execute(new ResetWindowCommand(receiver));
        }

        private void btnUndo_Click(object sender, RoutedEventArgs e)
        {
            invoker.Undo();
        }
        private void btnRedo_Click(object sender, RoutedEventArgs e)
        {
            invoker.Redo();
        }
    }
}
