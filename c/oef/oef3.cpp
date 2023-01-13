#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

int main(int argc, char const *argv[])
{
    char c = 'x';
    string s = "" + c;
    cout << "karakter " <<  c  << " omgezet: " <<  s << "." << endl;

    char k = 'y';
    string w = "";
    w += k;
    cout << "karakter " <<  k  << " omgezet: " <<  w << "." << endl;
    return 0;
}
