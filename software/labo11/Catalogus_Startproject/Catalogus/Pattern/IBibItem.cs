using System;
using System.Collections.Generic;


namespace Catalogus
{
    public interface IBibItem
    {
        List<IBibItem> Items { get; }
        // unieke identificatie
         int Id { get; set; }
        // ouder waartoe het item (bv. artikel, afdeling, ...) behoort of null
        IBibItem Ouder { get; set; }
        // item toevoegen aan dit item 
        virtual void VoegToe(IBibItem bibItem)
        {
            Items.Add(bibItem);
        }
        // item verwijderen uit dit item 
        virtual void Verwijder(IBibItem bibItem)
        {
            Items.Remove(bibItem);
        }
        // een item zoeken op basis van id
        virtual IBibItem Zoek(string id)
        {
            return Items.Where(item => { item.Id == id; return item; });
        }
        // een item zoeken op basis van een trefwoord
        ISet<IBibItem> ZoekTrefwoord(string trefwoord);
        // dit item verplaatsen naar een ander item
        void VerplaatsNaar(IBibItem bibItem);
        // item weergeven als string met een aantal karakters als indentatie
        string Toon(int insprong);
    }
}
