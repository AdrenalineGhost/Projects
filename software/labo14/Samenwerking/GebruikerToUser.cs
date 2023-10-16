using GebruikersPortaal;
using System.Collections.Generic;
using UserDatabase;

namespace Samenwerking
{
    public class GebruikerToUser : IDatabase
    {
        private IGebruikersLijst gebruikerslijst;

        public GebruikerToUser(IGebruikersLijst gebruikerslijst)
        {
            this.gebruikerslijst = gebruikerslijst;

        }
        public bool IsConnected => true;

        public void CloseConnection()
        {
            //niets doen
        }

        public void DeleteUser(User user)
        {
            gebruikerslijst.Verwijder(new GebruikerUser(user));
        }

        public void InsertUser(User user)
        {
            gebruikerslijst.VoegToe(new GebruikerUser(user));
        }

        public void OpenConnection()
        {
            //niets doen
        }

        public List<User> SelectAllUsers()
        {
            List<User> lijst = new List<User>();
            foreach (Gebruiker gebruiker in gebruikerslijst.Gebruikers)
            {
                lijst.Add(new UserGebruiker(gebruiker));
            }
            return lijst;
        }

        public void UpdateUser(User user)
        {
            gebruikerslijst.PasAan(new GebruikerUser(user));
        }

    }
}