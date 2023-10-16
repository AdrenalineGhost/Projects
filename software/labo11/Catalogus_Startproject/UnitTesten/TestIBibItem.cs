using Catalogus;

namespace UnitTesten
{
    [TestClass]
    public class TestIBibItem
    {
        [TestMethod]
        public void TestVoegToe()
        {
            // afdeling
            IBibItem afdeling = new Afdeling { Id = "WET", Naam = "Wetenschappen" };
            // boek
            IBibItem boek = new Boek();
            boek.Id = "ID01";
            Assert.IsNull(afdeling.Zoek("ID01"));
            afdeling.VoegToe(boek);
            Assert.AreEqual(boek, afdeling.Zoek("ID01"));
            Assert.AreEqual(boek.Ouder, afdeling);

            // tijdschrift
            IBibItem tijdschrift = new Tijdschrift { Id = "ID03", Titel = "Scientific American", Jaartal = new DateTime(2014, 8, 1), Uitgeverij = "Scientific American" };
            IBibItem artikel = new Artikel { Id = "ID04", Titel = "Planets we could call home", Auteur = "Dimitar Sasselov" };
            tijdschrift.VoegToe(artikel);
            IBibItem artikel2 = new Artikel { Id = "ID05", Titel = "Robot Pills", Auteur = "Paolo Dario" };
            tijdschrift.VoegToe(artikel2);
            Assert.AreEqual(artikel, tijdschrift.Zoek("ID04"));
            Assert.AreEqual(artikel.Ouder, tijdschrift);
            Assert.AreEqual(artikel2, tijdschrift.Zoek("ID05"));
            Assert.AreEqual(artikel2.Ouder, tijdschrift);
        }

        [TestMethod]
        public void TestVerwijder()
        {
            // afdeling
            IBibItem afdeling = new Afdeling { Id = "WET", Naam = "Wetenschappen" };
            // boek
            IBibItem boek = new Boek();
            boek.Id = "ID01";
            Assert.IsNull(afdeling.Zoek("ID01"));
            afdeling.VoegToe(boek);
            Assert.AreEqual(boek, afdeling.Zoek("ID01"));
            afdeling.Verwijder(boek);
            Assert.IsNull(afdeling.Zoek("ID01"));
            Assert.IsNull(boek.Ouder);

            // tijdschrift
            IBibItem tijdschrift = new Tijdschrift { Id = "ID03", Titel = "Scientific American", Jaartal = new DateTime(2014, 8, 1), Uitgeverij = "Scientific American" };
            IBibItem artikel = new Artikel { Id = "ID04", Titel = "Planets we could call home", Auteur = "Dimitar Sasselov" };
            tijdschrift.VoegToe(artikel);
            IBibItem artikel2 = new Artikel { Id = "ID05", Titel = "Robot Pills", Auteur = "Paolo Dario" };
            tijdschrift.VoegToe(artikel2);
            Assert.IsNull(afdeling.Zoek("ID02"));
            afdeling.VoegToe(tijdschrift);
            Assert.AreEqual(tijdschrift, afdeling.Zoek("ID03"));
            afdeling.Verwijder(tijdschrift);
            Assert.IsNull(afdeling.Zoek("ID02"));
            Assert.IsNull(afdeling.Zoek("ID05"));
            Assert.IsNull(tijdschrift.Ouder);
        }

        [TestMethod]
        public void TestZoekId()
        {
            // boek
            IBibItem boek = new Boek();
            boek.Id = "ID01";
            Assert.AreEqual(boek, boek.Zoek("ID01"));
            Assert.AreEqual(null, boek.Zoek("ID02"));
            // artikel
            IBibItem artikel = new Artikel { Id = "ID02", Titel = "Ik ben Pelgrim", Auteur = "Terry Hayes" };
            Assert.AreEqual(artikel, artikel.Zoek("ID02"));
            Assert.AreEqual(null, artikel.Zoek("ID03"));
            // tijdschrift
            IBibItem tijdschrift = new Tijdschrift { Id = "ID03", Titel = "Scientific American", Jaartal = new DateTime(2014, 8, 1), Uitgeverij = "Scientific American" };
            artikel = new Artikel { Id = "ID04", Titel = "Planets we could call home", Auteur = "Dimitar Sasselov" };
            tijdschrift.VoegToe(artikel);
            IBibItem artikel2 = new Artikel { Id = "ID05", Titel = "Robot Pills", Auteur = "Paolo Dario" };
            tijdschrift.VoegToe(artikel2);
            Assert.AreEqual(tijdschrift, tijdschrift.Zoek("ID03"));
            Assert.AreEqual(artikel, tijdschrift.Zoek("ID04"));
            Assert.AreEqual(artikel2, tijdschrift.Zoek("ID05"));
            Assert.AreEqual(null, tijdschrift.Zoek("ID06"));
        }

        [TestMethod]
        public void TestZoekTrefwoord()
        {
            // boek
            IBibItem item = new Boek { Id = "ID01", Auteur = "Hertmans", Titel = "In de herfst" };
            Assert.IsTrue(item.ZoekTrefwoord("herfst").Contains(item));
            Assert.IsTrue(item.ZoekTrefwoord("ert").Contains(item));
            Assert.IsTrue(item.ZoekTrefwoord("s").Contains(item));
            // artikel
            item = new Artikel { Id = "ID02", Auteur = "Hertmans", Titel = "In de herfst" };
            Assert.IsTrue(item.ZoekTrefwoord("herfst").Contains(item));
            Assert.IsTrue(item.ZoekTrefwoord("ert").Contains(item));
            Assert.IsTrue(item.ZoekTrefwoord("s").Contains(item));
            // tijdschrift
            item = new Tijdschrift { Id = "ID03", Titel = "Scientific American", Jaartal = new DateTime(2014, 8, 1), Uitgeverij = "Scientific American" };
            IBibItem artikel = new Artikel { Id = "ID04", Titel = "Planets we could call home", Auteur = "Dimitar Sasselov" };
            item.VoegToe(artikel);
            IBibItem artikel2 = new Artikel { Id = "ID05", Titel = "Robot Pills", Auteur = "Paolo Dario" };
            item.VoegToe(artikel2);
            Assert.IsTrue(item.ZoekTrefwoord("American").Contains(item));
            Assert.IsTrue(item.ZoekTrefwoord("we").Contains(artikel));
            Assert.IsTrue(item.ZoekTrefwoord("asse").Contains(artikel));
            Assert.IsTrue(item.ZoekTrefwoord("Pills").Contains(artikel2));
            Assert.IsTrue(item.ZoekTrefwoord("ar").Contains(artikel));
            Assert.IsTrue(item.ZoekTrefwoord("ar").Contains(artikel2));
            Assert.IsTrue(item.ZoekTrefwoord("ar").Count == 2);
            Assert.IsTrue(item.ZoekTrefwoord("thomas").Count == 0);
            //afdeling

            IBibItem afdeling = new Afdeling { Id = "WET", Naam = "Wetenschappen" };
            Assert.AreEqual(0, afdeling.ZoekTrefwoord("Wetenschappen").Count);
            // tijdschrift
            IBibItem tijdschrift = new Tijdschrift { Id = "ID01", Titel = "Scientific American", Jaartal = new DateTime(2014, 8, 1), Uitgeverij = "Scientific American" };
            artikel = new Artikel { Id = "ID02", Titel = "Planets we could call home", Auteur = "Dimitar Sasselov" };
            tijdschrift.VoegToe(artikel);
            artikel = new Artikel { Id = "ID03", Titel = "Robot Pills", Auteur = "Paolo Dario" };
            tijdschrift.VoegToe(artikel);
            afdeling.VoegToe(tijdschrift);
            // boek
            IBibItem boek = new Boek { Id = "ID04", Titel = "Ik ben Pelgrim", Auteur = "Terry Hayes", Uitgeverij = "Bruna", Jaartal = 2014 };
            afdeling.VoegToe(boek);
            // boek
            boek = new Boek { Id = "ID05", Titel = "Kou uit het oosten", Auteur = "Ken Follett", Uitgeverij = "Van Holkema", Jaartal = 2014 };
            afdeling.VoegToe(boek);
            // boek
            boek = new Boek { Id = "ID06", Titel = "De monogrammoorden", Auteur = "Ken Follett", Uitgeverij = "Van Holkema", Jaartal = 2014 };
            afdeling.VoegToe(boek);
            // boek
            boek = new Boek { Id = "ID07", Titel = "Kou uit het oosten", Auteur = "Ken Follett", Uitgeverij = "Van Holkema", Jaartal = 2014 };
            afdeling.VoegToe(boek);
            // afdeling
            IBibItem afdeling2 = new Afdeling { Id = "GESCH", Naam = "Geschiedenis" };
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
            afdeling.VoegToe(afdeling2);
            Assert.AreEqual(6, afdeling.ZoekTrefwoord("Follet").Count);
            Assert.AreEqual(4, afdeling.ZoekTrefwoord("oosten").Count);
            Assert.AreEqual(7, afdeling.ZoekTrefwoord("ol").Count);
            Assert.AreEqual(9, afdeling.ZoekTrefwoord("en").Count);
        }

        [TestMethod]
        public void TestVerplaatsNaar()
        {
            // boek verplaatsen
            IBibItem afdeling = new Afdeling { Id = "WET", Naam = "Wetenschappen" };
            IBibItem boek = new Boek { Id = "ID01", Auteur = "Hertmans", Titel = "In de herfst" };
            afdeling.VoegToe(boek);
            IBibItem artikel = new Artikel { Id = "ID02", Auteur = "Hertmans", Titel = "In de herfst" };
            afdeling.VoegToe(artikel);
            IBibItem nieuweAfdeling = new Afdeling() { Id = "GESCH", Naam = "Geschiedenis" };
            boek.VerplaatsNaar(nieuweAfdeling);
            Assert.AreEqual(boek, nieuweAfdeling.Zoek("ID01"));
            Assert.AreEqual(null, afdeling.Zoek("ID01"));
            Assert.AreEqual(null, nieuweAfdeling.Zoek("ID02"));
            Assert.AreEqual(artikel, afdeling.Zoek("ID02"));
            Assert.AreEqual(boek.Ouder, nieuweAfdeling);

            //tijdschrift en boek verplaatsen
            afdeling = new Afdeling { Id = "WET", Naam = "Wetenschappen" };
            // tijdschrift
            IBibItem tijdschrift = new Tijdschrift { Id = "ID01", Titel = "Scientific American", Jaartal = new DateTime(2014, 8, 1), Uitgeverij = "Scientific American" };
            artikel = new Artikel { Id = "ID02", Titel = "Planets we could call home", Auteur = "Dimitar Sasselov" };
            tijdschrift.VoegToe(artikel);
            artikel = new Artikel { Id = "ID03", Titel = "Robot Pills", Auteur = "Paolo Dario" };
            tijdschrift.VoegToe(artikel);
            afdeling.VoegToe(tijdschrift);
            // boek
            boek = new Boek { Id = "ID04", Titel = "Ik ben Pelgrim", Auteur = "Terry Hayes", Uitgeverij = "Bruna", Jaartal = 2014 };
            afdeling.VoegToe(boek);
            // boek
            boek = new Boek { Id = "ID05", Titel = "Kou uit het oosten", Auteur = "Ken Follett", Uitgeverij = "Van Holkema", Jaartal = 2014 };
            afdeling.VoegToe(boek);
            // boek
            boek = new Boek { Id = "ID06", Titel = "De monogrammoorden", Auteur = "Ken Follett", Uitgeverij = "Van Holkema", Jaartal = 2014 };
            afdeling.VoegToe(boek);
            // boek
            boek = new Boek { Id = "ID07", Titel = "Kou uit het oosten", Auteur = "Ken Follett", Uitgeverij = "Van Holkema", Jaartal = 2014 };
            afdeling.VoegToe(boek);
            // afdeling
            IBibItem afdeling2 = new Afdeling { Id = "GESCH", Naam = "Geschiedenis" };
            // boek
            boek = new Boek { Id = "ID08", Titel = "Ik ben Pelgrim", Auteur = "Terry Hayes", Uitgeverij = "Bruna", Jaartal = 2014 };
            afdeling2.VoegToe(boek);
            // boek
            boek = new Boek { Id = "ID09", Titel = "Kou uit het oosten", Auteur = "Ken Follett", Uitgeverij = "Van Holkema", Jaartal = 2014 };
            afdeling2.VoegToe(boek);
            // boek
            IBibItem boek2 = new Boek { Id = "ID10", Titel = "De monogrammoorden", Auteur = "Ken Follett", Uitgeverij = "Van Holkema", Jaartal = 2014 };
            afdeling2.VoegToe(boek2);
            // boek
            boek = new Boek { Id = "ID11", Titel = "Kou uit het oosten", Auteur = "Ken Follett", Uitgeverij = "Van Holkema", Jaartal = 2014 };
            afdeling2.VoegToe(boek);
            afdeling.VoegToe(afdeling2);
            tijdschrift.VerplaatsNaar(afdeling2);
            Assert.IsNotNull(afdeling2.Zoek("ID01"));
            Assert.IsNotNull(afdeling2.Zoek("ID02"));
            Assert.IsNotNull(afdeling2.Zoek("ID03"));
            Assert.AreEqual(afdeling2, tijdschrift.Ouder);
            boek2.VerplaatsNaar(afdeling);
            Assert.IsNull(afdeling2.Zoek("ID10"));
            Assert.IsNotNull(afdeling.Zoek("ID10"));
            Assert.AreEqual(afdeling, boek2.Ouder);

        }
    }
}
