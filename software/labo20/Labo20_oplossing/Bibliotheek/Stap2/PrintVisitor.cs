namespace Bibliotheek.Stap2
{
    public class PrintVisitor : AVisitor
    {
        int tel = 0;

        public override void Visit(Article article)
        {
            tel+=article.NumberOfPages;
        }

        public override void Visit(Book book)
        {
            tel += book.NumberOfPages;
        }

        public override void Visit(Journal journal)
        {
            foreach (Article artikel in journal.Articles)
            {
                Visit(artikel);
            }
        }

        protected override void Show()
        {
            Console.WriteLine("Aantal pagina's " + tel);
        }
    }
}
