using GebruikersPortaal;
using UserDatabase;

namespace Samenwerking
{
    internal class UserGebruiker : User
    { 

        public UserGebruiker(Gebruiker gebruiker)
        {
            LastName = gebruiker.Achternaam;
            FirstName = gebruiker.VoorNaam;
            ID = gebruiker.GebruikersCode;
        }
    }
}