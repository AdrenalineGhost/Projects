using GebruikersPortaal;
using Samenwerking;
using UserDatabase;

namespace UnitTesten
{
    [TestClass]
    public class UnitTest_TweedeAdapter
    {
        [TestMethod]
        public void TestGebruikerToUserAdapter()
        {
            IGebruikersLijst lijst = new GebruikersLijst();
            GebruikerToUser adapter = new GebruikerToUser(lijst);

            // Voeg user toe via adapter en verifieer in gebruikerslijst
            User u = new User() { ID = 1, FirstName = "John", LastName = "Doe" };
            adapter.InsertUser(u);
            List<Gebruiker> list = new List<Gebruiker>(lijst.Gebruikers);
            Gebruiker test = list.First(s => s.GebruikersCode == 1);
            Assert.AreEqual("John", test.VoorNaam);
            Assert.AreEqual("Doe", test.Achternaam);

            // Pas user aan via adapter en verifieer in gebruikerslijst
            u.FirstName = "Jane";
            adapter.UpdateUser(u);
            list = new List<Gebruiker>(lijst.Gebruikers);
            test = list.First(s => s.GebruikersCode == 1);
            Assert.AreEqual("Jane", test.VoorNaam);

            // Verwijder user en verifieer in gebruikerslijst
            adapter.DeleteUser(u);
            list = new List<Gebruiker>(lijst.Gebruikers);
            test = list.FirstOrDefault(s => s.GebruikersCode == 1);
            Assert.IsNull(test);
        }


    }
}
