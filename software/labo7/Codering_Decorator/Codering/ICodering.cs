using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Coderingen
{
    public interface ICodering
    {
        string Codeer(string zin);
        ICodering Undo();
    }
}
