using System;
using System.Collections.Generic;
using System.Text;

namespace Bestanden
{
    internal class RealFile : IFile
    {
        string map = "C:\\test\\";  //de map waar de bestanden staan
        string filename;

        internal RealFile(string filename)
        {
            this.filename = filename;
        }

        public string Content
        {
            get
            {
                Console.ForegroundColor = ConsoleColor.DarkGreen;
                Console.Out.Write("[INF] ");
                Console.ResetColor();
                Console.Out.WriteLine("Loading file " + filename + " from disk...");
                return System.IO.File.ReadAllText($"{map}\\{filename}");
            }
        }
    }
}

