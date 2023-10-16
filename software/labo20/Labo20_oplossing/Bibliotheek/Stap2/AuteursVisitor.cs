
namespace Bibliotheek.Stap2
{
    public class AuteursVisitor : AVisitor
    {
        private HashSet<string> auteurs = new HashSet<string>();

        public override void Visit(Article article)
        {
            auteurs.Add(article.Author);
        }

        public override void Visit(Book book)
        {
            auteurs.Add(book.Author);
        }

        public override void Visit(Journal journal)
        {

            foreach (Article artikel in journal.Articles)
            {
                Visit(artikel);
                //artikel.Visit(this);  //lukt niet - geen aparte methode in artikel
            }
        }

        protected override void Show()
        {
            Console.WriteLine("Auteurs (" + auteurs.Count + "):");
            foreach (string auteur in auteurs)
            {
                Console.WriteLine(auteur);
            }
        }
    }
}
