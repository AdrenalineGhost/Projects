namespace Catalogus
{
    public abstract class ABibItem : IBibItem
    {
        public string Id { get; set; }
        public IBibItem Ouder { get; set; }
        
        public virtual IBibItem Zoek(string id)
        {
            {
                if (id.Equals(Id))
                    return this;
                else return null;
            }
        }

        public void VerplaatsNaar(IBibItem bibItem)
        {
            Ouder.Verwijder(this); //hier wegnemen
            Ouder = bibItem;
            Ouder.VoegToe(this);
        }

        public virtual string Toon(int insprong)
        {
            string toon = "";
            for (int i = 0; i < insprong; i++)
            {
                toon += "-";
            }
            toon += Inhoud;
            return toon;
        }

        public abstract  string Inhoud { get; }

        public virtual void Verwijder(IBibItem bibItem)
        {
            //niet geimplementeerd - kan fout opwerpen
        }
        public virtual void VoegToe(IBibItem bibItem)
        {
            //niet geimplementeerd - kan fout opwerpen
        }

        public virtual ISet<IBibItem> ZoekTrefwoord(string trefwoord)
        {
            ISet<IBibItem> set = new HashSet<IBibItem>();
            if (HasTrefwoord(trefwoord))
            {
                set.Add(this);
            }
            return set;
        }

        public abstract bool HasTrefwoord(string trefwoord);
    }
}
