using System.Collections.Generic;

using ICommando = TekenProject.Pattern.Commands.ICommando;

namespace TekenProject.Pattern
{
    /* 
     * Invoker
     * */
    class CommandController
    {
        private readonly Stack<ICommando> undo = new Stack<ICommando>();
        private readonly Stack<ICommando> redo = new Stack<ICommando>();

        public void Execute(ICommando command)
        {
            command.Execute();
            undo.Push(command);
            redo.Clear();
        }

        public void Undo()
        {
            if (undo.Count != 0)
            {
                ICommando command = undo.Pop();
                command.Undo();
                redo.Push(command);
            }
        }

        public void Redo()
        {
            if (redo.Count != 0)
            {
                ICommando command = redo.Pop();
                command.Redo();
                undo.Push(command);
            }
        }
    }
}
