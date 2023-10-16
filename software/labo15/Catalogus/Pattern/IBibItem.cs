using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Catalogus
{
    public interface IBibItem
    {
        // unieke identificatie
         string Id { get; set; } 
        // ouder waartoe het item (bv. artikel, afdeling, ...) behoort of null
        IBibItem Ouder { get; set; }
        // item toevoegen aan dit item 
        void VoegToe(IBibItem bibItem);
        // item verwijderen uit dit item 
        void Verwijder(IBibItem bibItem);
        // een item zoeken op basis van id
        IBibItem Zoek(string id);        
        // een item zoeken op basis van een trefwoord
        ISet<IBibItem> ZoekTrefwoord(string trefwoord);
        // dit item verplaatsen naar een ander item
        void VerplaatsNaar(IBibItem bibItem);
        // item weergeven als string met een aantal karakters als indentatie
        string Toon(int insprong);
    }
}
