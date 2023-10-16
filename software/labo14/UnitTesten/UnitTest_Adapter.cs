using Samenwerking;
using GebruikersPortaal;
using UserDatabase;

namespace UnitTesten
{
    /// <summary>
    /// Summary description for UnitTest2
    /// </summary>
    [TestClass]
    public class UnitTest_Adapter
    {
        [TestMethod]
        public void TestUserToGebruikerAdapter()
        {
            IDatabase db = new MySQLDatabase();
            UserToGebruiker adapter = new UserToGebruiker(db);

            // Voeg gebruiker toe via adapter en verifieer in originele database
            Gebruiker g = new Gebruiker() { GebruikersCode = 1, VoorNaam = "John", Achternaam = "Doe" };
            adapter.VoegToe(g);
            db.OpenConnection();
            User test = db.SelectAllUsers().First(s => s.ID == 1);
            Assert.AreEqual("John", test.FirstName);
            Assert.AreEqual("Doe", test.LastName);
            db.CloseConnection();

            // Pas gebruiker aan via adapter en verifieer in originele database
            g.VoorNaam = "Jane";
            adapter.PasAan(g);
            db.OpenConnection();
            test = db.SelectAllUsers().First(s => s.ID == 1);
            Assert.AreEqual("Jane", test.FirstName);
            db.CloseConnection();

            // Verwijder gebruiker en verifieer in originele database
            adapter.Verwijder(g);
            db.OpenConnection();
            test = db.SelectAllUsers().FirstOrDefault(s => s.ID == 1);
            Assert.IsNull(test);
            db.CloseConnection();
        }

    }
}
