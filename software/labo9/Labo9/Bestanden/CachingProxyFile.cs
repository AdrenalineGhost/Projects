using System.Collections.Generic;

namespace Bestanden
{
    public class CachingProxyFile : IFile
    {

        string filename;

        string? content;

        public CachingProxyFile(string filename)
        {
            this.filename = filename;
        }

        public string Content
        {
            get
            {
                if (content == null)
                {
                    IFile file = new RealFile(filename);
                    content = file.Content;
                }
                return content;
            }
        }

    }
}

