using System.Windows.Shapes;

namespace TekenProject.Pattern.Commands
{
    class DrawCommand : ACommand<DrawLogic>
    {
        private Shape shape;
        public DrawCommand(DrawLogic receiver, Shape shape) : base(receiver)
        {
            this.shape = shape;
        }

        public override void Execute()
        {
            receiver.AddDrawing(shape);
        }

        public override void Redo()
        {
            receiver.AddDrawing(shape);
        }

        public override void Undo()
        {
            receiver.RemoveDrawing(shape);
        }
    }
}
