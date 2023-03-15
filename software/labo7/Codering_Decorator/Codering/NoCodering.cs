using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Coderingen
{
    public class NoCodering : ICodering
    {
        public string Codeer(string zin)
        {
            return zin;
        }

        public override string ToString()
        {
            return "Nocodering";
        }

        public ICodering Undo()
        {
            return this;
        }
    }
}
