using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CoderingenGui
{
    internal class Coderingen
    {
        internal static string wissel(string zin)
        {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < zin.Length; i += 2)
            {
                char[] toadd;
                try
                {
                    toadd = new[] { zin[i + 1], zin[i] };
                }
                catch (Exception)
                {
                    toadd = new[] { '0', zin[i] };
                }
                sb.Append(toadd);
            }
            return sb.ToString();

        }

        internal static string cijfer(string zin)
        {
            StringBuilder sb = new StringBuilder();
            foreach (char c in zin)
            {
                sb.Append((int)c);
            }
            return sb.ToString();
        }

        internal static string blok(string zin)
        {
            // init the needed values and classes
            StringBuilder sb = new StringBuilder();
            string check = "azert12yuiopq3s48dfghnjk97lm6w50xcvb";
            // 1
            foreach (char c in zin)
            {
                if (char.IsWhiteSpace(c) || !(char.IsLetterOrDigit(c))) { sb.Append(0); }
                else if (char.IsUpper(c)) { sb.Append(char.ToLower(c)); }
                else { sb.Append(c); }
            }
            // 2
            if (sb.Length % 2 == 1) { sb.Append(0); }
            // 3

            string[] pairs = new string[sb.Length / 2];
            var str = sb.ToString();

            // group into pairs
            for (int i = 0; i < sb.Length + 1 / 2; i += 2)
            {
                pairs[i / 2] = "" + str[i] + str[i + 1];
            }

            // clear the stringbuilder to reuse the same stringbuilder
            sb.Clear();

            foreach (var pair in pairs)
            {
                char c1 = pair[0]; char c2 = pair[1];
                if (checkrow(c1, c2) || checkcolumn(c1, c2))
                {
                    switchc(ref c1, ref c2);
                }
                else
                {
                    boxChange(ref c1, ref c2);
                }
                sb.Append("" + c1 + c2);
            }

            // check if the chars are in the same row
            bool checkrow(char c1, char c2)
            {
                int c1i = check.IndexOf(c1);
                int c2i = check.IndexOf(c2);
                return ((c1i - c1i % 6) == (c2i - c2i % 6)) ? true : false;
            }

            // check if the chars are in the same column
            bool checkcolumn(char c1, char c2) { return (check.IndexOf(c1) % 6 == check.IndexOf(c2) % 6) ? true : false; }

            // get the new chars from the box formula
            void boxChange(ref char c1, ref char c2)
            {
                // get the index in the string
                int c1i = check.IndexOf(c1);
                int c2i = check.IndexOf(c2);
                //get the difference between the columns
                int change = c2i % 6 - c1i % 6;
                //use the difference to get the new chars out of the string
                char newc1 = check[c1i + change];
                char newc2 = check[c2i - change];
                // make the changes
                c1 = newc1; c2 = newc2;
            }

            void switchc(ref char c1, ref char c2)
            {
                char buffer = c1; c1 = c2; c2 = buffer;
            }

            return sb.ToString();
        }


    }

}
