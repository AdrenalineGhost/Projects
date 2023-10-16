namespace Druk
{
    public class DrukKlasse : ISubject
    {
        private ISubject pascalModel;

        private double factor;

        public string Eenheid { get; }
        public string Naam { get; }

        public DrukKlasse(ISubject pascal, double factor, string eenheid, string naam)
        {
            pascalModel = pascal;
            this.factor = factor;
            this.Eenheid = eenheid;
            this.Naam = naam;
        }

        public double Druk
        {
            get { return pascalModel.Druk / factor; }
            set { pascalModel.Druk = value * factor; }
        }
        public double Max
        {
            get { return pascalModel.Max / factor; }
        }

        public void Register(IObserver observer)
        {
            pascalModel.Register(observer);
        }
    }
}