#include <iostream>
#include <string>
#include <iomanip>
#include <random>
#include <algorithm>
#include <functional>
#include <map>
#include <set>
#include <iterator>

using namespace std;

// ostream for vectors
template<typename T>
ostream& operator<<(ostream &out, vector<T> &v){
    for (size_t i = 0; i < v.size(); i++)
    {
        out << v[i] << " ";
    } out << endl;
    return out;
}

// ostream for sets
template<typename T>
ostream& operator<<(ostream &out, const set<T> &s) {
    out << "{ ";
    typename set<T>::const_iterator it = s.begin();
    for (int i=0 ; i<s.size()-1 ; i++) {
        out << *it++ << " , ";
    }
    out << *it << " }";
    return out;
}

template<typename S, typename D>
ostream& operator<<(ostream& out, const map<S,D> &m) {
    typename map<S,D>::const_iterator it = m.begin();
    while (it != m.end()) {
        out << "  " << it->first << " --> "
            << it->second << endl;
        it++;
    }
    return out;
}