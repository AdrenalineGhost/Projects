using System.Collections;

namespace Bibliotheek
{
  
    public class Library{
        private List<LibraryItem> items;

        public Library()
        {
            items = new List<LibraryItem>();
            Init();
        }

        public List<LibraryItem> Items
        {
            get { return items; }
        }


        private void Init()
        {
            items.Add(new Book("Geert Colpaert", "Het boek der ontwenning", 759));
            items.Add(new Book("Christophe Vekeman", "Marie", 189));
            List<Article> articles = new List<Article>();
            articles.Add(new Article("Tom Engelshoven", "Tom Barman", 44, 48));
            articles.Add(new Article("Tom Engelshoven", "Bruce Springsteen", 40, 43));
            articles.Add(new Article("Willem Jongeneelen", "Het geluk van België", 50, 55));
            articles.Add(new Article("Swie Tio", "Never mind The Sex Pistols, here's the ... Buzzcocks", 62, 67));
            items.Add(new Journal("Oor", articles));
            items.Add(new Book("Sarah Lark", "De roep van het land", 604));
            articles = new List<Article>();
            articles.Add(new Article("Ivo De Kock", "Beasts of the southern wild : levendig, magisch en realistisch", 12, 13));
            articles.Add(new Article("Sarah Skoric", "Ice dragon : Zweedse ninja's on the road", 20, 21));
            articles.Add(new Article("Ivo De Kock", "Killing them softly : dit is geen land maar een business", 22, 23));
            articles.Add(new Article("Dirk Michiels", "Le capital : dissectie van het bankkapitalisme", 24, 25));
            articles.Add(new Article("Piet Goethals", "Skyfall : ravissant, schizofreen en gedenkwaardig", 29, 29));
            items.Add(new Journal("Filmmagie", articles));
        }
    }
}