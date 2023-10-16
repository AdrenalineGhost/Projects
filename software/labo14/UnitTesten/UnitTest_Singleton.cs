using Samenwerking;
using UserDatabase;

namespace UnitTestPortaal
{
    [TestClass]
    public class UnitTest_Singleton
    {
        [TestMethod]
        public void TestSingletonDatabase()
        {
            // Hier mag je IDatabase gebruiken
            IDatabase db = SingletonDatabase.Instance;
            IDatabase db2 = SingletonDatabase.Instance;
            Test(db, db2);
        }

        [TestMethod]
        public void TestSingletonDBInheritance()
        {
            // Mag je niet casten naar IDatabase omdat dan de CloseConnection() van de base klasse gebruikt wordt (is niet virtual).
            SingletonDBInheritance db = SingletonDBInheritance.Instance;
            SingletonDBInheritance db2 = SingletonDBInheritance.Instance;
            Test(db, db2);
        }
        private void Test(IDatabase db, IDatabase db2)
        {
            db.CloseConnection();
            Assert.IsTrue(db2.IsConnected);
            db2.CloseConnection();
            Assert.IsTrue(db.IsConnected); //sluit pas bij destructie

            // Should be same object
            Assert.AreEqual(db, db2);

            // Voeg user toe
            User u = new User() { ID = 1, FirstName = "John", LastName = "Doe" };
            db.InsertUser(u);
            Assert.IsTrue(db.SelectAllUsers().Contains(u));
            Assert.IsTrue(db2.SelectAllUsers().Contains(u));

            // Wijzig user
            u.FirstName = "Jane";
            db.UpdateUser(u);
            User test = db.SelectAllUsers().First(s => s.ID == 1);
            Assert.AreEqual("Jane", test.FirstName);
            test = db2.SelectAllUsers().First(s => s.ID == 1);
            Assert.AreEqual("Jane", test.FirstName);

            // Verwijder user
            db.DeleteUser(u);
            Assert.IsFalse(db.SelectAllUsers().Contains(u));
            Assert.IsFalse(db2.SelectAllUsers().Contains(u));
        }

        private void Test(SingletonDBInheritance db, SingletonDBInheritance db2)
        {
            db.CloseConnection();
            Assert.IsTrue(db2.IsConnected);
            db2.CloseConnection();
            Assert.IsTrue(db.IsConnected); //sluit pas bij destructie

            // Should be same object
            Assert.AreEqual(db, db2);

            // Voeg user toe
            User u = new User() { ID = 1, FirstName = "John", LastName = "Doe" };
            db.InsertUser(u);
            Assert.IsTrue(db.SelectAllUsers().Contains(u));
            Assert.IsTrue(db2.SelectAllUsers().Contains(u));

            // Wijzig user
            u.FirstName = "Jane";
            db.UpdateUser(u);
            User test = db.SelectAllUsers().First(s => s.ID == 1);
            Assert.AreEqual("Jane", test.FirstName);
            test = db2.SelectAllUsers().First(s => s.ID == 1);
            Assert.AreEqual("Jane", test.FirstName);

            // Verwijder user
            db.DeleteUser(u);
            Assert.IsFalse(db.SelectAllUsers().Contains(u));
            Assert.IsFalse(db2.SelectAllUsers().Contains(u));
        }
    }
}
