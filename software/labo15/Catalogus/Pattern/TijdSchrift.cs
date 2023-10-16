namespace Catalogus
{
    public class TijdSchrift : ABibComposite
    {
        public DateTime Jaartal { get; set; }
        public string Uitgeverij { get; set; }
        public string Titel {get;set;}

        public TijdSchrift()
        {
            elementen = new List<IBibItem>();
        }

        public override string Inhoud
        {
            get
            {
                return Id + ": \"" + Titel + "\", " + Jaartal.ToString("d/MM/yyyy H:mm:ss") + ", " + Uitgeverij;
            }
        }

        public override bool HasTrefwoord(string trefwoord)
        {
            return  Titel.Contains(trefwoord) || Uitgeverij.Contains(trefwoord);
        }
    }
}
