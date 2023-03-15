using System;
using System.Collections.Generic;

namespace Bibliotheek
{
    public class BoekenLijst
    {
        readonly List<Boek> boeken = new();
        public BoekenLijst()
        {
            InitBoekenLijst();
        }
        //public void Print(Action<string> action, Func<Boek, string> f, Func<Boek, Boek, int> sortmethod)
        public void Print(ShowDelegate action, FormatDelegate f, SortDelegate sortmethod)
        {
            boeken.Sort((b1, b2) => sortmethod(b1, b2));
            string result = "";
            foreach (Boek b in boeken)
            {
                result += f(b) + "\n";
            }
            action(result);
        }
        private void InitBoekenLijst()
        {
            boeken.Add(new Boek { Id = "ID01", Titel = "Duizend manen", Auteur = "Sebastian Barry", Uitgeverij = "Querido", Jaartal = 2020 });
            boeken.Add(new Boek { Id = "ID02", Titel = "De geheime gasten", Auteur = "Benjamin Black / John Banville", Uitgeverij = "Querido", Jaartal = 2020 });
            boeken.Add(new Boek { Id = "ID03", Titel = "De berenrug", Auteur = "Dimitri Bontenakel", Uitgeverij = "Wereldbibliotheek", Jaartal = 2020 });
            boeken.Add(new Boek { Id = "ID04", Titel = "De waterdanser", Auteur = "Ta-Nehisi-Coates", Uitgeverij = "Meulenhoff", Jaartal = 2020 });
            boeken.Add(new Boek { Id = "ID05", Titel = "The Mercies", Auteur = "Kiran Millwood", Uitgeverij = "Picador", Jaartal = 2020 });
            boeken.Add(new Boek { Id = "ID06", Titel = "1794", Auteur = "Niklas Natt och Dag", Uitgeverij = "Prometheus", Jaartal = 2020 });
            boeken.Add(new Boek { Id = "ID07", Titel = "Hamnet", Auteur = "Maggie O’Farrell", Uitgeverij = "Nijgh & Van Ditmar", Jaartal = 2020 });
            boeken.Add(new Boek { Id = "ID08", Titel = "Last", Auteur = "Ellen Ombre", Uitgeverij = "Nijgh & Van Ditmar", Jaartal = 2020 });
            boeken.Add(new Boek { Id = "ID09", Titel = "Kom Atir kom", Auteur = "Agnita de Ranitz", Uitgeverij = "De Brouwerij", Jaartal = 2020 });
            boeken.Add(new Boek { Id = "ID10", Titel = "Tropenbruid", Auteur = "Susan Smit", Uitgeverij = "Lebowski", Jaartal = 2020 });
            boeken.Add(new Boek { Id = "ID11", Titel = "Een wolf bij zijn oren pakken", Auteur = "Sana Valiulina", Uitgeverij = "Prometheus", Jaartal = 2020 });
            boeken.Add(new Boek { Id = "ID12", Titel = "Ik, alleen", Auteur = "Sophie Zijlstra", Uitgeverij = "Querido", Jaartal = 2020 });
            boeken.Add(new Boek { Id = "ID13", Titel = "De leeuwen van Sicilië", Auteur = "Stefania Auci", Uitgeverij = "Cargo", Jaartal = 2019 });
            boeken.Add(new Boek { Id = "ID14", Titel = "De drukker van Venetië", Auteur = "Javier Azpeitia", Uitgeverij = "Wereldbibliotheek", Jaartal = 2019 });
            boeken.Add(new Boek { Id = "ID15", Titel = "De stilte van de vrouwen", Auteur = "Pat Barker", Uitgeverij = "Ambo | Anthos", Jaartal = 2019 });
            boeken.Add(new Boek { Id = "ID16", Titel = "Nog zoveel om voor te leven", Auteur = "Louis de Bernières", Uitgeverij = "De Arbeiderspers", Jaartal = 2018 });
            boeken.Add(new Boek { Id = "ID17", Titel = "Over de grens", Auteur = "Mechtild Borrmann", Uitgeverij = "A.W. Bruna", Jaartal = 2019 });
            boeken.Add(new Boek { Id = "ID18", Titel = "Morgenster", Auteur = "Dirk Van Boxem", Uitgeverij = "Polis", Jaartal = 2019 });
            boeken.Add(new Boek { Id = "ID19", Titel = "De maan danst op het erf van de doden", Auteur = "Rebekka W.R. Bremmer", Uitgeverij = "Querido", Jaartal = 2019 });
            boeken.Add(new Boek { Id = "ID20", Titel = "Het boek van de vergeten artiesten", Auteur = "Vera Buck", Uitgeverij = "Karakter Uitgevers", Jaartal = 2018 });
            boeken.Add(new Boek { Id = "ID21", Titel = "Miss Birma", Auteur = "Charmaine Craig", Uitgeverij = "Meulenhoff", Jaartal = 2019 });
            boeken.Add(new Boek { Id = "ID22", Titel = "In de verte RecensieIn de verte", Auteur = "Hernan Diaz", Uitgeverij = "Atlas Contact", Jaartal = 2019 });
            boeken.Add(new Boek { Id = "ID23", Titel = "Het wit en het purper", Auteur = "Willemijn van Dijk", Uitgeverij = "Ambo | Anthos", Jaartal = 2019 });
            boeken.Add(new Boek { Id = "ID24", Titel = "Stad van meisjes", Auteur = "Elizabeth Gilbert", Uitgeverij = "Cargo", Jaartal = 2019 });
            boeken.Add(new Boek { Id = "ID25", Titel = "De patiënten van dokter García", Auteur = "Almudena Grandes", Uitgeverij = "Signatuur", Jaartal = 2019 });
        }
    }
}