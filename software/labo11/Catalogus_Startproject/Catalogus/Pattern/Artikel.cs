namespace Catalogus
{
    public class Artikel :IBibItem
    {
        public string Titel { get; set; }

        public string Id { get; set; }
        public string Auteur { get; set; }
        public string Inhoud
        {
            get {return Id + ": \"" + Titel + "\", " + Auteur; }
            
        }
    }
}
