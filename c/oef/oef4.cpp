#include <iostream>
#include <string>
#include <iomanip>
#include <random>
#include <algorithm>

using namespace std;

string genereer_string(int len)
{
    string s = "";
    for (size_t i = 0; i < len; i++)
    {
        s += (char)((rand()%26)+(int)'a');
    }
    return s;
}

void vul_array_met_strings(string tab[], int n, int len)
{
    srand(time(0));
    for (size_t i = 0; i < n; i++)
    {
        string tempString = genereer_string(len);
        tab[i] = tempString;
    }
    
}

void schrijft(string tab[], int n)
{
for (size_t i = 0; i < n; i++)
{
    cout << tab[i] << endl;
}

}

void bepaal_min_en_max(string tab[], int n, string &min, string &max)
{
    for (size_t i = 0; i < n; i++)
    {
        if (min > tab[i] || min.empty())
        {
            min = tab[i];
        }

        if (tab[i] > max || max.empty());
        {
            max = tab[i];
        }
    }
    
}

void splits_woorden(string tab[], int aantal, string zin) 
{
    for (size_t i = 0; i < aantal; i++)
    {
        tab[i] = zin.substr(0,zin.find(' '));
        zin = zin.substr(zin.find(' ')+1);
    }
    
}

int main(int argc, char const *argv[])
{
    // int len = 1;
    string line;
    getline(cin,line);
    int N = count(line.begin(),line.end(),' ')+1;
    string tab[N];
    // while ((len < 5) || (len > 15))
    // {
    //     cout << "Geef een getal in tussen het inteval [5 , 15]" << endl;
    //     cin >> len;
    //     cout << endl;
    // }

    // vul_array_met_strings(tab, N, len);


    splits_woorden(tab,N,line);

    schrijft(tab , N);

    string min, max;
    bepaal_min_en_max(tab,N,min,max);
    cout << endl << "min: " << min << setw(20) << "max: " << max <<endl;
    return 0;
}

