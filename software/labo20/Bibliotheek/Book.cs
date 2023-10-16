namespace Bibliotheek
{
    public class Book : LibraryItem
    {

        public Book(string author, string title, int numberOfPages) : base(title)
        {
            Author = author;
            NumberOfPages = numberOfPages;
        }

        public string Author { get; }

        public int NumberOfPages
        {
            get;
        }

    }
}
