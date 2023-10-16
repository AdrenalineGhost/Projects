using GebruikersPortaal;
using System.Collections.Generic;
using UserDatabase;

namespace Samenwerking
{
    public class UserToGebruiker : IGebruikersLijst
    {
        //Geen Singleton
        IDatabase db;//Niet vastleggen in deze klasse         
        public UserToGebruiker(IDatabase db)  
        {
            this.db = db;
        }
        
        public Gebruiker[] Gebruikers
        {
            get
            {
                checkConnection();
                List<UserDatabase.User> users = db.SelectAllUsers();
                Gebruiker[] gebruikers = new Gebruiker[users.Count];
                int i = 0;
                foreach (User user in users)
                {
                    gebruikers[i] = new GebruikerUser(user);
                    i++;
                }
                db.CloseConnection();
                return gebruikers;

            }
        }

        private void checkConnection()
        {
            db.OpenConnection();
            if (!db.IsConnected)
                throw new NotConnected();

        }


        public void PasAan(Gebruiker gebruiker)
        {
            checkConnection();           
            db.UpdateUser(new UserGebruiker(gebruiker));
            db.CloseConnection();
        }

        public void Verwijder(Gebruiker gebruiker)
        {
            checkConnection();
            db.DeleteUser(new UserGebruiker(gebruiker));
            db.CloseConnection();
        }

        public void VoegToe(Gebruiker gebruiker)
        {
            checkConnection();
            db.InsertUser(new UserGebruiker(gebruiker));
            db.CloseConnection();
        }

    }
}
