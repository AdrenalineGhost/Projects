
namespace Catalogus
{
    public abstract class ABibComposite : ABibItem
    {
        protected ICollection<IBibItem> elementen;

        public override string Toon(int insprong)
        {
            string toon = "";
            for (int i = 0; i < insprong; i++)
            {
                toon += "-";
            }
            toon += Inhoud+": \n";
            foreach(IBibItem bibitem in elementen)
            {
                toon += bibitem.Toon(insprong + 2) + " \n";
            }

            return toon;
        }
        public override void Verwijder(IBibItem bibItem)
        {
            if (elementen.Contains(bibItem))
            {
                elementen.Remove(bibItem);
                bibItem.Ouder = null;
            }
        }
        public override void VoegToe(IBibItem bibItem)
        {
            elementen.Add(bibItem);
            bibItem.Ouder = this;
        }
        public override IBibItem Zoek(string id)
        {
            IBibItem item= base.Zoek(id);
            if (item == null) //niet gevonden
            {
                foreach (IBibItem bibitem in elementen)
                {
                    IBibItem iitem = bibitem.Zoek(id);
                    if (iitem != null) return iitem;
                }
            }
            return item;
        }
        public override ISet<IBibItem> ZoekTrefwoord(string trefwoord)
        {
            ISet<IBibItem> set = base.ZoekTrefwoord(trefwoord);
            foreach (IBibItem bibitem in elementen)
            {
                set.UnionWith(bibitem.ZoekTrefwoord(trefwoord));
            }
            return set;
           
        }

    }
}
