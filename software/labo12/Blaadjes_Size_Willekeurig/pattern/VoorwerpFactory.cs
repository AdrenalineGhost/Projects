using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Blaadjes.pattern
{
    internal class VoorwerpFactory
    {
        public static string[] SOORTEN = { "blad", "groenBlad", "roodBlad", "pluim" };
        Dictionary<string, IVoorwerp> voorwerpen = new();
        Random random = new Random();

        public VoorwerpFactory()
        {
            //maak direct de vier objecten aan - kan ook worden uitgesteld tot de eerste keer dat ze opgevraagd worden
            foreach (string soort in SOORTEN)
            {               

                IVoorwerp afbeelding;
                if (soort.Equals("pluim"))
                {
                    afbeelding = new Pluim();
                }
                else
                {
                    afbeelding = new Blad(soort);
                }

                voorwerpen.Add(soort, afbeelding);
            }
        }

        public IVoorwerp this[string soort]
        {
            get { return voorwerpen[soort]; }
        }

        public string KiesBlad()
        {

            int k = random.Next(SOORTEN.Length - 1); //de laatste niet
            return SOORTEN[k];
        }
    }
}

