using Catalogus;

namespace BibliotheekConsole.Pattern
{
    interface IBuilder
    {
        public void NewLibrary(string id, string name);
        public void StartAfdeling(string id, string name);

        public void EndAfdeling();
        public void StartTijdschrift(string id, string titel, DateTime jaartal, string uitgeverij) ;
        public void EndTijdschrift() ;

        public void AddArtikel(string id, string name, string auteur) ;

        public void AddBoek(string id, string name, string auteur, string uitgeverij, int jaartal) ;

        public IBibItem Build();

    }
}
