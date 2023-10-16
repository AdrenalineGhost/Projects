using System;
using System.Collections.Generic;
using System.Text;

namespace Bestanden
{
    public class AuthenticationProxyFile:IFile
    {
        private IFile file;
        User user { get; } string filename;
        public AuthenticationProxyFile(User user, string filename)
        {
            this.filename = filename; this.user = user; 
            if (!user.isAdmin && filename == ".secretfile.txt")
            {
                throw new Exception("FileAccesException");
            }
            this.file = new CachingProxyFile(filename);

        }
        public string Content 
        {
            get {  return file.Content; }
        }

    }
}
