using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Druk
{
    public interface ISubject
    {
        void Register(IObserver observer);
        double Druk { get; set; }
        double Max { get; }

        string Eenheid { get; }
        string Naam { get; }
    }
}

