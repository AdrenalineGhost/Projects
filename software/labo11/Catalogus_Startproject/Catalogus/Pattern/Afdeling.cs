namespace Catalogus
{
    public class Afdeling : IBibItem
    {
        public string Id { get; set; }
        public string Naam { get; set; }
        public string Inhoud
        {
            get
            {
                return Naam;
            }
        }

    }
}
