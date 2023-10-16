// See https://aka.ms/new-console-template for more information

using Samenwerking;
using UserDatabase;
int nr = 0;
ProxySingleton(); 
DBINheritance();

void ProxySingleton()
{
    try
    {
        //Hier kan je de interface IDatabase gebruiken
        Console.WriteLine("\n*******Singleton Proxy ************");
        IDatabase singleton = SingletonDatabase.Instance;
        controleerAdd(singleton);
        Console.WriteLine("*******Singleton2 ************");
        IDatabase singleton2 = SingletonDatabase.Instance;
        controleerAdd(singleton2);
    }
    catch (Exception e)
    {
        Console.WriteLine(e.Message);
    }
}


void DBINheritance()
{
    try
    {
        //Hier kan je de interface IDatabase NIET gebruiken
        Console.WriteLine("\n*******Singleton Inheritance************");
        SingletonDBInheritance singleton = SingletonDBInheritance.Instance;
        controleerAddInheritance(singleton);
        Console.WriteLine("*******Singleton2 Inheritance ************");
        SingletonDBInheritance singleton2 = SingletonDBInheritance.Instance;
        controleerAddInheritance(singleton2);
    }
    catch (Exception e)
    {
        Console.WriteLine(e.Message);
    }
}

void controleerAdd(IDatabase db)
{
    db.OpenConnection();
    if (db.IsConnected)
    {
        db.InsertUser(
            new User { FirstName = "Leen", LastName = "Brouns", ID = 123 + nr });
        nr++;
        Console.WriteLine(db.SelectAllUsers().Count + " users");
        // Business Logic	
    }
    db.CloseConnection();
}

//Methode herschrijven voor de oplossing met Inheritance
void controleerAddInheritance(SingletonDBInheritance db)
{
    db.OpenConnection();
    if (db.IsConnected)
    {
        db.InsertUser(
            new User { FirstName = "Leen", LastName = "Brouns", ID = 123 + nr });
        nr++;
        Console.WriteLine(db.SelectAllUsers().Count + " users");
        // Business Logic	
    }
    db.CloseConnection();
}
