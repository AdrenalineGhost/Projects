#include <C:\Users\marwan.elk2014\Desktop\txt\headers\containers.h>
#include <iostream>
#include <string>
#include <iomanip>
#include <random>
#include <algorithm>
#include <functional>
#include <set>
#include <map>

using namespace std;

template<typename T>
ostream& operator<<(ostream &out, set<T> &s)
{
    out << "( ";
    for (T t : s)
    {
        out << t;
        if(t != s.end()) out << ",";
    } return out;
}


template<typename T , typename D>
ostream& operator<<(ostream &out, map<T , D> &m)
{
    typename map<T , D>::iterator it;
    for (it = m.begin(); it != m.end(); it++)
    {
        out << it->first << " -> " << it->second << endl;
    } return out;
}


int main(int argc, char const *argv[])
{

    return 0;
}


