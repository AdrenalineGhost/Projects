#include <memory>
#include <iostream>
using namespace std;

void schrijf(const string * s, int aantal){
    // cout << endl;
    // for(int i=0; i < aantal-1; i++){
    //     cout << s[i] << " - ";
    // }
    // cout << s[aantal-1];
    cout << endl << s[0];
    for (size_t i = 1; i < aantal; i++)
    {
        cout << " - " << s[i];
    } cout << endl;
    
}

void verwijder(string * s, int &aantal, int volgnr){
   for(int i = volgnr; i < aantal-1; i++){
       s[i] = s[i+1];
   }
   s[aantal-1] = "";  //laatste element leeg maken
   aantal--;
}

int main(){
    string namen[]={"Rein","Ada","Eppo","Pascal","Ilse"};
    int aantal = sizeof(namen)/sizeof(namen[0]);
    schrijf(namen,aantal);
    verwijder(namen,aantal,1);
    schrijf(namen,aantal); //alle namen tonen
    return 0;
}