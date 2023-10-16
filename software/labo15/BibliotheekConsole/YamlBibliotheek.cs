using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Catalogus;
using YamlDotNet.Serialization;

namespace BibliotheekConsole
{
    internal class YamlBibliotheek
    {
        Afdeling bib;
        internal YamlBibliotheek()
        {
            StreamReader streamReader = new StreamReader("bestanden//library.yaml");
            string content = streamReader.ReadToEnd();
            var deserializer = new DeserializerBuilder().Build();
            var library = deserializer.Deserialize<dynamic>(content);
            bib = new Afdeling { Id = library["id"], Naam = library["name"] };

            foreach (var afdeling in library["afdelingen"])
            {
                Afdeling afd = new Afdeling { Id = afdeling["id"], Naam = afdeling["name"] };
                bib.VoegToe(afd);
                foreach (var subAfdeling in afdeling["afdelingen"])
                {
                    Afdeling subafd = new Afdeling { Id = subAfdeling["id"], Naam = subAfdeling["name"] };
                    afd.VoegToe(subafd);

                    try
                    {
                        foreach (var item in subAfdeling["boeken"])
                        {
                            Boek boek = new Boek
                            {
                                Id = item["id"],
                                Titel = item["title"],
                                Auteur = item["auteur"],
                                Uitgeverij = item["uitgeverij"],
                                Jaartal = Int32.Parse(item["jaartal"])
                            };

                            afd.VoegToe(boek);
                        }

                    }
                    catch { }
                    try
                    {
                        foreach (var item in subAfdeling["tijdschriften"])
                        {
                            TijdSchrift tijdschrift = new TijdSchrift
                            {
                                Id = item["id"],
                                Titel = item["title"],
                                Uitgeverij = item["uitgeverij"],
                                Jaartal = Int32.Parse(item["jaartal"])
                            };

                            try
                            {
                                foreach (var art in item["artikels"])
                                {
                                    Artikel artikel = new Artikel
                                    {
                                        Id = item["id"],
                                        Titel = item["title"],
                                        Auteur = item["auteur"]
                                    };
                                    tijdschrift.VoegToe(artikel);
                                }
                            }
                            catch { }
                            afd.VoegToe(tijdschrift);
                        }

                    }
                    catch { }
                }


            }
        }
        public IBibItem Bibliotheek
        {
            get { return bib; }
        }
    }
}
