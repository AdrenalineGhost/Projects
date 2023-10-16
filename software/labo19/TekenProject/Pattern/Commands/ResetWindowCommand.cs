using System.Collections.Generic;
using System.Windows.Shapes;

namespace TekenProject.Pattern.Commands
{
    class ResetWindowCommand : ACommand<DrawLogic>
    {
        private IList<Shape> backup=new List<Shape>();
        public ResetWindowCommand(DrawLogic receiver) : base(receiver)
        {
        }

        public override void Execute()
        {
            backup = receiver.Dump();
            receiver.ClearCanvas();
        }

        public override void Redo()
        {
            backup = receiver.Dump();
            receiver.ClearCanvas();
        }

        public override void Undo()
        {
            receiver.Load(backup);
        }
    }
}
