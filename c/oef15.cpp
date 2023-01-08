#include <C:\Users\marwan.elk2014\Desktop\txt\headers\containers.h>
#include <iostream>
#include <string>
#include <iomanip>
#include <random>
#include <algorithm>
#include <functional>
#include <set>
#include <map>
#include <unordered_set>
#include <fstream>

using namespace std;

void print_woorden(const string &zoek, const vector<map<char,set<string> > > & v) {
    if (zoek.size() < v.size()) {
    	//geen [ ] gebruiken op de map!!
        map<char,set<string> >::const_iterator it = v[zoek.size()].find(zoek[0]);
        if (it != v[zoek.size()].end()) {
            cout << it->second;
        } else {
            cout << "geen woorden van die lengte met startletter " << zoek[0] << endl;
        }
    } else {
        cout << "geen woorden gevonden die zo lang zijn" << endl;
    }
}

int main() {
    vector<map<char,set<string> > > v(10); //vertrek van 10 elementen
    string woord;
    cout << "geef woorden, eindig met STOP" << endl;
    cin >> woord;
    while (woord!="STOP") {
        if (woord.size() > v.size()-1)
            v.resize(woord.size()+1);
        v[woord.size()][woord[0]].insert(woord);
        cin >> woord;
    }
    print_woorden("sinterklaas",v);
    return 0;
}