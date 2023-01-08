#include <iostream>
#include <memory>
#include <vector>
using namespace std;

template<typename T>
void dupliceer(vector<unique_ptr<T>> &v, int n) {
    int oorspr_grootte = v.size();
    v.resize(v.size()*n);
    for (int i=oorspr_grootte-1 ; i>=0 ; i--) {
        int pos = i*n;
        v[pos] = move(v[i]);
        for (int j = pos+1 ; j<pos+n ; j++)
           v[j] = make_unique<T>(*v[pos]);
    }
}

int main() {
   unique_ptr<string> namen[] = {make_unique<string>("Rein"),
       make_unique<string>("Ada"), make_unique<string>("Eppo"),
       make_unique<string>("Pascal"), make_unique<string>("Ilse")};
    vector<unique_ptr<string>> namenvector;
    namenvector.reserve(5);
    for (int i=0 ; i<5 ; i++)
       namenvector.push_back(move(namen[i]));
    dupliceer(namenvector,3);
    for (int i=0 ; i<namenvector.size() ; i++)
       cout << *namenvector[i] << "  ";
    return 0;
}