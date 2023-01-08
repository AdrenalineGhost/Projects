#include <iostream>
#include <string>
#include <iomanip>
#include <random>
#include <algorithm>
#include <functional>

using namespace std;


struct persoon{
    string naam;
    int leeftijd;
    int lengte;
};

ostream& operator<<(ostream& out, const persoon & p){
    out << p.naam << " (" << p.leeftijd << " jaar, " << p.lengte  << "cm" ")";
    return out;
}

void initialiseer(persoon &pers, string naam, int leeftijd, int lengte) 
{
    pers.naam = (string)naam; 
    pers.leeftijd = (int)leeftijd; 
    pers.lengte = (int)lengte;
}

template<typename T>
ostream& operator<<(ostream &out, vector<T> &v){
    out << v[0];
    for (size_t i = 1; i < v.size(); i++)
    {
        out << " " << v[i];
    }
    return out;
}

int main(int argc, char const *argv[])
{
    persoon p;
    initialiseer(p,"Jan",12,1.83);

    cout << p << endl;

    vector<int> v1 = {10,15,5,6,23,74};
    cout << v1 << endl;

    vector<bool> v2 = {true,false,false,false,true,false};
    cout << v2 << endl;

    vector<int> v3 = {1,541,54,435,5354};

    vector<vector<int>> v4 = {v1,v3};
    cout << v4 << endl;

    return 0;
}
