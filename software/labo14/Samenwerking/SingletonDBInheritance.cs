
using UserDatabase;

namespace Samenwerking
{
    public sealed class SingletonDBInheritance : MySQLDatabase
    {
        static volatile SingletonDBInheritance? instance;
        //volatile: beschikbaar voor verschillende Threads
        static Object blockObj = new();

        public static SingletonDBInheritance Instance
        {
            get
            {
                if (instance == null)
                {
                    lock (blockObj)
                    {
                        if (instance == null)
                        {
                            instance = new SingletonDBInheritance();
                            instance.OpenConnection(); //opent de connectie van MySqlDatabase
                        }
                    }
                }
                return instance;
            }
        }

        private SingletonDBInheritance()
        {
            
        }

        ~SingletonDBInheritance()
        {
            base.CloseConnection(); //Bij afbreken van deze klasse
        }


        public new void CloseConnection()
        {
            Console.WriteLine("MySQLDatabase niet sluiten");
            //niets doen op MySQLDatebase
        }


        public new void OpenConnection()
        {
            if (!IsConnected)
            {
                base.OpenConnection();
            }//open connectie van MySQLDatebase
        }
    }
}
