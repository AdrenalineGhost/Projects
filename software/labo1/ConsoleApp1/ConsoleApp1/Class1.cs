using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Labo2
{
    internal class Codering
    {

        internal static string wissel(string zin)
        {
            StringBuilder sb = new StringBuilder();
            char[] toadd;
            for (int i = 0; i < zin.Length; i += 2)
            {
                Console.WriteLine(i);
                try
                {
                    toadd = new[] { zin[i+1], zin[i]};
                }
                catch (Exception)
                {
                    toadd = new[] { '0', zin[i] };
                }
                sb.Append(toadd);
            }
            return sb.ToString();
        }

    }
}
