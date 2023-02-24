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
            for (int i = 0; i < zin.Length; i += 2)
            {
                Console.WriteLine(i);
                char[] toadd;
                try
                {
                    toadd = { zin[i + 1] , zin[i] };
                }
                catch (Exception)
                {
                    toadd = { '0', zin[i] };
                }
                sb.Append(toadd);
            }
            return sb.ToString();
        }

    }
}
