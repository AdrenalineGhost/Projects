using Catalogus;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.ConstrainedExecution;
using System.Text;
using System.Threading.Tasks;
using YamlDotNet.Serialization;

namespace BibliotheekConsole.Pattern
{
    internal class Director
    {
        private readonly IBuilder _builder;

        public Director()
        {
            _builder = new BibliotheekBuilder();
        }

        public IBibItem BuildLibraryFromYAML(string filename)
        {
            StreamReader streamReader = new StreamReader("bestanden//library.yaml");
            string content = streamReader.ReadToEnd();
            var deserializer = new DeserializerBuilder().Build();
            var library = deserializer.Deserialize<dynamic>(content);
            _builder.NewLibrary(library["id"], library["name"]);
            _BuildRecursive(library["afdelingen"], "afdelingen");
            return _builder.Build();
        }

        private void _testRead(dynamic item)
        {
            Console.WriteLine(item.ToString());
            if (item.GetType().IsGenericType && item.GetType().GetGenericTypeDefinition() == typeof(Dictionary<,>))
            {
                foreach (var items in item.Values)
                {
                    _testRead(items);
                }
            }
        }

        private void _BuildRecursive(dynamic item, string type)
        {
            
            switch (type)
            {
                case "afdelingen":
                    foreach (var afdeling in item)
                    {
                        log("afdeling made", "green");
                        _builder.StartAfdeling(afdeling["id"], afdeling["name"]);
                        foreach (var i in afdeling)
                        {
                            _BuildRecursive(i.Value, i.Key);
                        }
                        _builder.EndAfdeling();
                    }
                    break;
                case "boeken":
                    foreach (var boek in item)
                    {
                        log("boek made", "yellow");
                        _builder.AddBoek(boek["id"], boek["title"], boek["auteur"], boek["uitgeverij"], int.Parse(boek["jaartal"]));
                    }
                    break;
                case "tijdschriften":
                    foreach (var tijdschrift in item)
                    {
                        log("tijdschrift made", "yellow");
                        _builder.StartTijdschrift(tijdschrift["id"], tijdschrift["title"], (DateTime.Parse(tijdschrift["date"])), tijdschrift["uitgeverij"]);
                        foreach (var i in tijdschrift["artikels"])
                        {
                            _builder.AddArtikel(i["id"], i["title"], i["auteur"]);
                        }
                        _builder.EndTijdschrift();
                    }
                    break;
                default:
                    log("defaulted","red");
                    break;
            }
        }

        private void log(string message, string color)
        {
            switch (color) 
            {
                case "red":
                    Console.ForegroundColor= ConsoleColor.Red;
                    break;
                case "yellow":
                    Console.ForegroundColor= ConsoleColor.Yellow;
                    break;
                case "green":
                    Console.ForegroundColor= ConsoleColor.Green;
                    break;
                case "purple":
                    Console.ForegroundColor= ConsoleColor.Magenta;
                    break;
                default:
                    Console.ForegroundColor= ConsoleColor.Gray;
                    break;
                    
            }
            Console.WriteLine(message);
            Console.ForegroundColor= ConsoleColor.Gray;
        }
         private void log(string message)
        {
            log(message, "");
        }

    }
}
