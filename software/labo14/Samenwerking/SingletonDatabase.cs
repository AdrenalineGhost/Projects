using UserDatabase;

namespace Samenwerking{
    //sealed: er kan geen klasse worden afgeleid van deze klasse
    public sealed class SingletonDatabase : IDatabase
    {
        readonly MySQLDatabase db;

        static volatile SingletonDatabase? instance;  //volatile: beschikbaar voor verschillende Threads; ? voor lazy initialization
        static object blockObj = new object();        //mag om het even welk soort object zijn

        private SingletonDatabase()
        {
            db = new MySQLDatabase();
            db.OpenConnection();
        }

        ~SingletonDatabase()
        {
            db.CloseConnection();   // Destructor!!
        }

        public static IDatabase Instance
        {
            get
            {   //lazy singleton
                //blokkeer alles tot de code is afgewerkt
                if (instance == null)
                {
                    lock (blockObj)
                    {
                        if (instance == null)
                        {
                            instance = new SingletonDatabase();
                        }
                    }
                }                
                return instance;
            }
        }

        public bool IsConnected => true; //always connected

        public void CloseConnection() {
            Console.WriteLine("MySQLDatabank niet sluiten");
        } //niets doen

        public void DeleteUser(User user) => db.DeleteUser(user);

        public void InsertUser(User user) => db.InsertUser(user);

        public void OpenConnection() { }//connectie is altijd open

        public List<User> SelectAllUsers() => db.SelectAllUsers();

        public void UpdateUser(User user) => db.UpdateUser(user);

    }
}
