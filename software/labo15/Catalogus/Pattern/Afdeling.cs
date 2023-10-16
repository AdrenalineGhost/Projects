namespace Catalogus

{
    public class Afdeling : ABibComposite
    {
        public string Naam { get; set; }

        public Afdeling()
        {
            elementen = new SortedSet<IBibItem>(new Sorteerder());
        }
        public override string Inhoud
        {
            get
            {
                return Naam;
            }
        }

        public override bool HasTrefwoord(string trefwoord)
        {
            return false;
        }

    }
}
