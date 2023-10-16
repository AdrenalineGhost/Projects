using GebruikersPortaal;
using UserDatabase;

namespace UnitTesten
{
    [TestClass]
    public class UnitTest_Voorbereiding
    {
        [TestMethod]
        public void TestTestGebruikerPortaal()
        {
            IGebruikersLijst lijst = new GebruikersLijst();

            // Voeg gebruiker toe
            Gebruiker g = new Gebruiker() { GebruikersCode = 1, VoorNaam = "John", Achternaam = "Doe" };
            lijst.VoegToe(g);
            List<Gebruiker> list = new List<Gebruiker>(lijst.Gebruikers);
            Assert.IsTrue(list.Contains(g));

            // Wijzig
            g.VoorNaam = "Jane";
            lijst.PasAan(g);
            list = new List<Gebruiker>(lijst.Gebruikers);
            Gebruiker test = list.First(s => s.GebruikersCode == 1);
            Assert.AreEqual("Jane", test.VoorNaam);

            // Verwijder gebruiker
            lijst.Verwijder(g);
            list = new List<Gebruiker>(lijst.Gebruikers);
            Assert.IsFalse(list.Contains(g));
        }

        [TestMethod]
        public void TestUserDatabase()
        {
            IDatabase db = new MySQLDatabase();

            // Open connectie
            db.OpenConnection();
            Assert.IsTrue(db.IsConnected);

            // Voeg user toe
            User u = new User() { ID = 1, FirstName = "John", LastName = "Doe" };
            db.InsertUser(u);
            Assert.IsTrue(db.SelectAllUsers().Contains(u));

            // Wijzig user
            u.FirstName = "Jane";
            db.UpdateUser(u);
            User test = db.SelectAllUsers().First(s => s.ID == 1);
            Assert.AreEqual("Jane", test.FirstName);

            // Verwijer user
            db.DeleteUser(u);
            Assert.IsFalse(db.SelectAllUsers().Contains(u));

            // Sluit connectie
            db.CloseConnection();
            Assert.IsFalse(db.IsConnected);
        }

    }

}
