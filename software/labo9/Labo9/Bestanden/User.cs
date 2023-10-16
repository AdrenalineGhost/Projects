using System;
using System.Collections.Generic;
using System.Text;

namespace Bestanden
{
    public class User
    {
        public string username { get; }
        public bool isAdmin { get; }
        public User(string username, bool isAdmin)
        {
            this.username = username; this.isAdmin = isAdmin;
        }

        

    }
}
