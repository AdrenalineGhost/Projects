using Catalogus;

namespace UnitTesten
{
    [TestClass]
    public class TestTijdschrift
    {
        [TestMethod]
        public void TestToon()
        {
            TijdSchrift tijdschrift = new TijdSchrift { Id = "ID01", Titel = "Scientific American", Jaartal = new DateTime(2014, 8, 1), Uitgeverij = "Scientific American" };
            Artikel artikel = new Artikel { Id = "ID02", Titel = "Planets we could call home", Auteur = "Dimitar Sasselov" };
            tijdschrift.VoegToe(artikel);
            artikel = new Artikel { Id = "ID03", Titel = "Robot Pills", Auteur = "Paolo Dario" };
            tijdschrift.VoegToe(artikel);
            string toon = tijdschrift.Toon(0);
            string resultaat = "ID01: \"Scientific American\", 1/08/2014 0:00:00, Scientific American: \n"
                + "--ID02: \"Planets we could call home\", Dimitar Sasselov \n"
                + "--ID03: \"Robot Pills\", Paolo Dario \n";
            Assert.AreEqual(resultaat, toon);
        }
    }
}
