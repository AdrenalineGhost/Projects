#include <C:\Users\marwan.elk2014\Desktop\txt\headers\containers.h>
#include <iostream>
#include <string>
#include <iomanip>
#include <random>
#include <algorithm>
#include <functional>

using namespace std;

// For the amount of elements in TABEL
const int AANTAL = 5;


int main(int argc, char const *argv[])
{
    //oefening 1: array van vectoren
    vector<string> tabel[AANTAL];
    tabel[1].push_back("aap"); //nog geen elementen in de vector
    tabel[1].push_back("noot");
    tabel[1].push_back("mies");
    for (vector<string> v : tabel) 
        {cout << v;}
    cout << endl;

    //oefening 2
    vector<vector<int>> vv;
    vv.reserve(AANTAL);
    for (size_t i = 0; i < AANTAL; i++)
    {
        vector<int> tv;
        tv.reserve(i);
        for (size_t j = 0; j < i; j++) tv.push_back((int)(10+j*10));
        vv.push_back(move(tv));
    }
    cout << vv << endl;
    for (size_t i = vv.size(); i > 0; i--)
    {
        for (size_t j = vv[i-1].size(); j > 0; j--) cout << vv[i-1][j-1] << ' '; cout << endl;
    }
    
}
