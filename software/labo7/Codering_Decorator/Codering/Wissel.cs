using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Coderingen
{
    public class Wissel: ACodering
    {
        public Wissel(ICodering codering) : base(codering)
        {
        }

        public override string Codeer(string zin)
        {
            zin = codering.Codeer(zin); //voer eerst de vorige codering uit
            // lengte even?
            if (zin.Length % 2 != 0)
            {
                zin += '0';
            }
            // codering door wisselen
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < zin.Length; i += 2)
            {
                // letters verwisselen
                result.Append(zin[i + 1]);
                result.Append(zin[i]);
            }
            return result.ToString();
        }

        public override string ToString()
        {
            return "Wissel";
        }

    }
}
