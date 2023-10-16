
namespace Bibliotheek.Stap1
{
    public class PrintVisitor : IVisitor
    {
        private int tel = 0;
        public void Visit(Article article)
        {
            tel += article.NumberOfPages;
        }

        public void Visit(Book book)
        {
            tel += book.NumberOfPages;
        }

        public void Visit(Journal journal)
        {
            foreach(Article artikel in journal.Articles)
            {
                Visit(artikel);
            }
        }

        public void Visit(Library library)
        {
           foreach(LibraryItem item in library.Items)
            {
                item.Accept(this);
            }
            Console.WriteLine("Aantal paginas:"  +tel);
        }
    }
}
