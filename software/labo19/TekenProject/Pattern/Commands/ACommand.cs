namespace TekenProject.Pattern.Commands
{
    abstract class ACommand<T> : ICommando
    {
        protected T receiver;
        public ACommand(T receiver)
        {
            this.receiver = receiver;
        }
        abstract public void Execute();

        abstract public void Redo();

        abstract public void Undo();
    }
}
