// See https://aka.ms/new-console-template for more information
using GebruikersPortaal;
using Samenwerking;
using UserDatabase;

int nr=0;

try
{
    Console.WriteLine("***********MySQLDataBaser********");

    IDatabase db = new MySQLDatabase();//enige database die gegeven is, implementeert IDatabase
    TelUsers(db);

    Console.WriteLine("***********Adapter UserToGebruiker********");
    IGebruikersLijst gebruikersLijst = new UserToGebruiker(db);
    gebruikersLijst.VoegToe(new Gebruiker
    {
        Achternaam = "Jansen",
        VoorNaam = "Jan",
        GebruikersCode = 586
    });
    TelUsers(db);

    //toegevoegd voor tweede adapter
    Console.WriteLine("***********Adapter GebruikerToUser ********");
    IDatabase db2 = new GebruikerToUser(gebruikersLijst);
    db2.InsertUser(new User() { ID = 1, FirstName = "John", LastName = "Doe" });
    TelUsers(db);
}
catch (Exception e)
{
    Console.WriteLine(e.Message);
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

void TelUsers(IDatabase db)
{
    db.OpenConnection();
    Console.WriteLine(db.SelectAllUsers().Count + " users");
    db.OpenConnection();
}
