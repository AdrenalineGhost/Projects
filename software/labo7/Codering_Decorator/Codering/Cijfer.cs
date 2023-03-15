using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Coderingen
{
    public class Cijfer :ACodering //kan ook public zijn
    {
        public Cijfer(ICodering codering) : base(codering)
        {
        }

        public override string Codeer(string zin)
        {
            zin = codering.Codeer(zin); //voer eerst de vorige codering uit
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < zin.Length; i++)
            {
                int code = zin[i];
                result.Append(code);
            }
            return result.ToString();
        }

        public override string ToString()
        {
            return "Cijfer";
        }
    }
}
