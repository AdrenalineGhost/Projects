using System;
using System.Collections.Generic;
using Bestanden;

namespace Bestandsbeheer
{
    class Program
    {
        static void Main(string[] args)
        {
            var dict = new Dictionary<string, User>();
            dict.Add("gast", new User("gast", false));
            dict.Add("admin", new User("admin", true));

            Console.Out.Write("Enter username: ");
            string? username = Console.ReadLine();

            while(username == null && !dict.ContainsKey(username))
            {
                username = Console.ReadLine();
            }
            Console.WriteLine(dict[username].isAdmin);

            Console.Out.Write("Enter file name or STOP to exit: ");
            string? filename = Console.ReadLine();
            while (filename?.ToUpper() != "STOP")
            {
                IFile file = new AuthenticationProxyFile(dict[username],filename);

                Console.WriteLine("=== 1 === " + filename + " ======");
                Console.WriteLine(file.Content);

                Console.WriteLine("=== 2 === " + filename + " ======");
                Console.WriteLine(file.Content);  //twee keer de content ophalen

                Console.WriteLine("============================");
                Console.Out.Write("\nEnter file name or STOP to exit: ");
                filename = Console.ReadLine();
            }
        }

    }
}
