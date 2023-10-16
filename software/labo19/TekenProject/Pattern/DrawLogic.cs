using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Shapes;

namespace TekenProject.Pattern
{
    /*
     * Receiver
     * */
    public class DrawLogic
    {
        SolidColorBrush[] colors = { Brushes.Black, Brushes.White, Brushes.Gray, Brushes.Red, Brushes.Green, Brushes.Blue, Brushes.Yellow, Brushes.Purple, Brushes.Brown, Brushes.Orange };

        MainWindow window;
        int strokeNr = 0, fillNr = 1;

        Point start, eind;

        public DrawLogic(MainWindow window)
        {
            this.window = window;
        }
        
        internal SolidColorBrush StrokeColor => colors[StrokeNr];
        internal SolidColorBrush FillColor => colors[FillNr];

        internal int StrokeNr
        {
            get { return strokeNr; }
            set
            {
                strokeNr = value % colors.Length;
                window.brushStroke.Color = StrokeColor.Color;
            }
        }

        internal int FillNr
        {
            get { return fillNr; }
            set
            {
                fillNr = value % colors.Length;
                window.brushFill.Color = FillColor.Color;
            }
        }
        internal void ClearCanvas()
        {
            window.canvas.Children.Clear();
        }

        internal IList<Shape> Dump()
        {
            List<Shape> dump = new List<Shape>();
            foreach (Shape shape in window.canvas.Children)
            {
                dump.Add(shape);
            }
            return dump;
        }

        internal void Load(IList<Shape> dump)
        {
            foreach (Shape shape in dump)
            {
                window.canvas.Children.Add(shape);
            }
        }

        internal void RemoveDrawing(Shape shape)
        {
            window.canvas.Children.Remove(shape);
        }

        internal void AddDrawing(Shape shape)
        {
            window.canvas.Children.Add(shape);
        }

        internal void MouseDown(Point point)
        {
           start = point;
        }

        internal Shape MouseUp(Point point)
        {
            eind = point;
            Random random = new Random();
            return random.Next(2) == 0 ? CreateEllips(start, eind) : CreateLine(start, eind);
        }

        internal void MouseMove(Point point)
        {

        }

        
        #region Draw methods
        private Shape CreateLine(Point start, Point eind)
        {
            Line line = new Line();
            line.Stroke = StrokeColor;
            line.X1 = start.X;
            line.Y1 = start.Y;
            line.X2 = eind.X;
            line.Y2 = eind.Y;
            return line;
        }

        private Shape CreateEllips(Point start, Point eind)
        {
            Shape shape = new Ellipse();
            shape.Width = Math.Abs(eind.X - start.X);
            shape.Height = Math.Abs(eind.Y - start.Y);
            shape.Stroke = StrokeColor;
            shape.Fill = FillColor;
            Canvas.SetLeft(shape, Math.Min(start.X, eind.X));
            Canvas.SetTop(shape, Math.Min(start.Y, eind.Y));
            return shape;
        }
        #endregion
    }

}