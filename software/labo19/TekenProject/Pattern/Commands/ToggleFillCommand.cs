using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TekenProject.Pattern.Commands
{
    class ToggleFillCommand : ACommand<DrawLogic>
    {
        public ToggleFillCommand(DrawLogic receiver) : base(receiver)
        {
        }

        public override void Execute()
        {
            receiver.FillNr++;
        }

        public override void Redo()
        {
            receiver.FillNr++;
        }

        public override void Undo()
        {
            receiver.FillNr--;
        }
    }
}
