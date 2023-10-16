namespace Bibliotheek
{
    public abstract class LibraryItem
    {
        public string Title { get; }

        public LibraryItem(string title)
        {
            Title = title;
        }

        public abstract void Accept(IVisitor visitor); //enkel nodig indien geen reflexie
    }
}
