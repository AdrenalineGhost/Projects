
using System.Reflection;

namespace Bibliotheek.Stap2
{
    public abstract class AVisitor:IVisitor
    { //Array van de types voor de parameter bevat maar 1 element in dit voorbeeld
        private void ReflectiveVisit(LibraryItem element)
        {
            Type[] types = new Type[] { element.GetType() };           

            MethodInfo methodInfo = GetType().GetMethod("Visit", types);

            methodInfo?.Invoke(this, new object[] { element });

        }

        //Wordt altijd op dezelfde manier afgehandeld
        public void Visit(Library library) 
        {
            foreach (LibraryItem item in library.Items)
            {
                ReflectiveVisit(item);
            }
            //...
            //Template pattern wordt gebruikt
            Show(); //het resultaat is afhankelijk van de implementatie
        }

        
        public abstract void Visit(Article article);
        public abstract void Visit(Book book);
        public abstract void Visit(Journal journal);
        
        //deze mag protected
        protected abstract void Show();
    }
}
