namespace TekenProject.Pattern.Commands
{
    class SetFillCommand : ACommand<DrawLogic>
    {
        private int fillNumber;
        private int previousFill;
        public SetFillCommand(DrawLogic receiver, int fillNumber) : base(receiver)
        {
            this.fillNumber = fillNumber;
        }

        public override void Execute()
        {
            previousFill = receiver.FillNr;
            receiver.FillNr = fillNumber;
        }

        public override void Redo()
        {
            previousFill = receiver.FillNr;
            receiver.FillNr = fillNumber;
        }

        public override void Undo()
        {
            receiver.FillNr = previousFill;
        }
    }
}
