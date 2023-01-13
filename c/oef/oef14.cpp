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

using namespace std;

int main() {
    map<char,unordered_set<string> > m;
    string woord;
    cout << "geef woorden, eindig met STOP" << endl;
    cin >> woord;
    while (woord!="STOP") {
        m[woord[0]].insert(woord);
        cin >> woord;
    }
    cout << "geef een letter, ik zeg hoeveel verschillende woorden van daarnet met die letter starten ";
    char letter;
    cin >> letter;
    if (m.count(letter)==1) {
        cout << "er waren " << m[letter].size() << " verschillende woorden met die startletter" << endl;
    }
    else {
        cout << "er was geen enkel woord met die startletter" << endl;
    }
    return 0;
}