
namespace Bibliotheek
{
    public class Journal : LibraryItem
    {

        public Journal(string title, List<Article> articles) : base(title)
        {
            Articles = articles;
        }

        public List<Article> Articles { get; }

        public override void Accept(IVisitor visitor)
        {
            visitor.Visit(this);
        }
    }
}
