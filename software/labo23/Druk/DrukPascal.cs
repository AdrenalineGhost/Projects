
namespace Druk
{
    public class DrukPascal: ISubject
    {
        
        private double druk=101325;

        private List<IObserver> observers = new List<IObserver>();

        //enkel toevoegen 
        public void Register(IObserver observer)
        {
            observers.Add(observer);
            observer.Update(); //stuur notificatie naar deze observer
        }

        //stuur kort bericht naar observers
        private void Notify()
        {
            foreach (IObserver observer in observers)
            {
                observer.Update();
            }
        }

        public string Eenheid { get; } = "Pa";
        public string Naam { get; } = "Pascal";

        public double Max { get; } = 1700000;
        public double Druk
        {
            get { return druk; }
            set
            {
                druk = Math.Max(0, Math.Min(value,Max));
                Notify();
            }
        }
    }
}
