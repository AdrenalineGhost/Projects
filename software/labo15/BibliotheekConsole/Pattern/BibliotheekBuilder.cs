using Catalogus;
using System;
using System.Collections.Generic;
using System.ComponentModel.Design.Serialization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BibliotheekConsole.Pattern
{
    internal class BibliotheekBuilder : IBuilder
    {
        private ABibComposite root;

        private void AddComposite(ABibComposite composite)
        {
            root.VoegToe(composite);
        }

        public void AddArtikel(string id, string name, string auteur)
        {
            root.VoegToe(new Artikel { Id = id, Auteur = auteur, Titel = name} );
        }

        public void AddBoek(string id, string name, string auteur, string uitgeverij, int jaartal)
        {
            root.VoegToe(new Boek { Id = id, Auteur = auteur, Titel = name, Jaartal = jaartal, Uitgeverij=uitgeverij}) ;
        }

        public IBibItem Build()
        {
            while(root.Ouder != null) { root = (ABibComposite)root.Ouder; }
            return root;
        }

        public void EndAfdeling()
        {
            _OldRoot();
        }

        public void EndTijdschrift()
        {
            _OldRoot();
        }

        public void NewLibrary(string id, string name)
        {
            root = new Afdeling { Naam = name, Id = id };
        }

        public void StartAfdeling(string id, string name)
        {
            _NewRoot(new Afdeling { Id = id, Naam = name });
        }

        public void StartTijdschrift(string id, string titel, DateTime jaartal, string uitgeverij)
        {
            _NewRoot(new TijdSchrift { Id = id, Jaartal = jaartal, Titel = titel, Uitgeverij = uitgeverij });
        }

        private void _NewRoot(ABibComposite nr)
        {
            root.VoegToe(nr);
            root= nr;
        }

        private void _OldRoot() { root = (ABibComposite)root.Ouder; }
    }
}
