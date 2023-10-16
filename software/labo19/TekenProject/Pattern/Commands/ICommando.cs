using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace TekenProject.Pattern.Commands
{
    public interface ICommando
    {
        void Execute();
        void Undo();
        void Redo();
    }
}
