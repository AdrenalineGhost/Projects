
namespace Bibliotheek.Stap1
{
    public class AuteursVisitor : IVisitor
    {
        private HashSet<string> auteurs = new HashSet<string>();
        public void Visit(Article article)
        {
            auteurs.Add(article.Author);
        }

        public void Visit(Book book)
        {
            auteurs.Add(book.Author);
        }

        public void Visit(Journal journal)
        {
            foreach(Article artikel in journal.Articles)
            {
                //Visit(artikel);
                artikel.Accept(this);
            }
        }

        //Deze methode kan ook in abstracte klasse - zie oplossing Reflexie
        public void Visit(Library library)
        {
            foreach(LibraryItem item in library.Items)
            {
                item.Accept(this);
            }
            Console.WriteLine("Auteurs ("+auteurs.Count+"):");
            foreach (string auteur in auteurs)
            {
                Console.WriteLine(auteur);
            }
        }
    }
}
