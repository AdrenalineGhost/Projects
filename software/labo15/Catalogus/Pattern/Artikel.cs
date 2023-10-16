
namespace Catalogus
{
    public class Artikel : ABibItem
    {
        public string Titel { get; set; }
        public string Auteur { get; set; }
        public override string Inhoud
        {
            get {return Id + ": \"" + Titel + "\", " + Auteur; }
            
        }
        public override bool HasTrefwoord(string trefwoord)
        {
            return Auteur.Contains(trefwoord) || Titel.Contains(trefwoord);
        }

    }
}
