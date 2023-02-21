using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    internal class Codering
    {
        
        string Wissel(string zin)
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < zin.Length; i++)
            {
                if (i%2==0)
                {
                    char te = zin[i];
                } else if (i%2==1) { char xt = zin[i]; sb.Append(xt + te); }
            }
        }

    }
}
