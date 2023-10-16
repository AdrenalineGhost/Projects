namespace Bibliotheek
{
    public interface IVisitor
    {
        void Visit(Article article);
        void Visit(Book book);
        void Visit(Journal journal);
        void Visit(Library library);
    }
}
