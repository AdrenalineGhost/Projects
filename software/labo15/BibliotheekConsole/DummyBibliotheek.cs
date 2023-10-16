using Catalogus;

namespace BibliotheekConsole
{
    internal class DummyBibliotheek
    {
        Afdeling bib;
        internal DummyBibliotheek()
        {
            bib = new Afdeling { Id = "BIB", Naam = "Bibliotheek" };
            Afdeling afdeling = new Afdeling { Id = "FICTIE", Naam = "Fictie" };
            bib.VoegToe(afdeling);
            Afdeling subafdeling = new Afdeling { Id = "VOLW", Naam = "Volwassenen" };
            afdeling.VoegToe(subafdeling);
            // boek
            Boek boek = new Boek { Id = "ID04", Titel = "Ik ben Pelgrim", Auteur = "Terry Hayes", Uitgeverij = "Bruna", Jaartal = 2014 };
            subafdeling.VoegToe(boek);
            // boek
            boek = new Boek { Id = "ID05", Titel = "Kou uit het oosten", Auteur = "Ken Follett", Uitgeverij = "Van Holkema", Jaartal = 2014 };
            subafdeling.VoegToe(boek);
            // boek
            boek = new Boek { Id = "ID06", Titel = "De monogrammoorden", Auteur = "Ken Follett", Uitgeverij = "Van Holkema", Jaartal = 2014 };
            subafdeling.VoegToe(boek);
            // boek
            boek = new Boek { Id = "ID07", Titel = "Kou uit het oosten", Auteur = "Ken Follett", Uitgeverij = "Van Holkema", Jaartal = 2014 };
            subafdeling.VoegToe(boek);
            afdeling = new Afdeling { Id = "NONFICTIE", Naam = "Non Fictie" };
            bib.VoegToe(afdeling);
            subafdeling = new Afdeling { Id = "WET", Naam = "Wetenschappen" };
            afdeling.VoegToe(subafdeling);
            // tijdschrift
            TijdSchrift tijdschrift = new TijdSchrift { Id = "ID01", Titel = "Scientific American", Jaartal = new DateTime(2014, 8, 1), Uitgeverij = "Scientific American" };
            Artikel artikel = new Artikel { Id = "ID02", Titel = "Planets we could call home", Auteur = "Dimitar Sasselov" };
            tijdschrift.VoegToe(artikel);
            artikel = new Artikel { Id = "ID03", Titel = "Robot Pills", Auteur = "Paolo Dario" };
            tijdschrift.VoegToe(artikel);
            subafdeling.VoegToe(tijdschrift);
            // afdeling
            Afdeling afdeling2 = new Afdeling { Id = "GESCH", Naam = "Geschiedenis" };
            afdeling.VoegToe(afdeling2);
            // boek
            boek = new Boek { Id = "ID08", Titel = "Ik ben Pelgrim", Auteur = "Terry Hayes", Uitgeverij = "Bruna", Jaartal = 2014 };
            afdeling2.VoegToe(boek);
            // boek
            boek = new Boek { Id = "ID09", Titel = "Kou uit het oosten", Auteur = "Ken Follett", Uitgeverij = "Van Holkema", Jaartal = 2014 };
            afdeling2.VoegToe(boek);
            // boek
            boek = new Boek { Id = "ID10", Titel = "De monogrammoorden", Auteur = "Ken Follett", Uitgeverij = "Van Holkema", Jaartal = 2014 };
            afdeling2.VoegToe(boek);
            // boek
            boek = new Boek { Id = "ID11", Titel = "Kou uit het oosten", Auteur = "Ken Follett", Uitgeverij = "Van Holkema", Jaartal = 2014 };
            afdeling2.VoegToe(boek);
        }

        public IBibItem Bibliotheek
        {
            get { return bib; }
        }
    }
}
