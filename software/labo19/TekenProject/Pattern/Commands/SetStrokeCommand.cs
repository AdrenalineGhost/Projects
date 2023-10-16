namespace TekenProject.Pattern.Commands
{
    class SetStrokeCommand : ACommand<DrawLogic>
    {
        private int strokeNumber;
        private int previousStroke;
        public SetStrokeCommand(DrawLogic receiver, int strokeNumber) : base(receiver)
        {
            this.strokeNumber = strokeNumber;
        }

        public override void Execute()
        {
            previousStroke = receiver.StrokeNr;
            receiver.StrokeNr = strokeNumber;
        }

        public override void Redo()
        {
            previousStroke = receiver.StrokeNr;
            receiver.StrokeNr = strokeNumber;
        }

        public override void Undo()
        {
            receiver.StrokeNr = previousStroke;
        }
    }
}
