using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TekenProject.Pattern.Commands
{
    class ToggleStrokeCommand : ACommand<DrawLogic>
    {
        public ToggleStrokeCommand(DrawLogic receiver) : base(receiver)
        {
        }

        public override void Execute()
        {
            receiver.StrokeNr++;
        }

        public override void Redo()
        {
            receiver.StrokeNr++;
        }

        public override void Undo()
        {
            receiver.StrokeNr--;
        }
    }
}
