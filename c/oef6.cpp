#include <iostream>
#include <string>
#include <iomanip>
#include <random>
#include <algorithm>

using namespace std;

void schrijf(int array[], int aantal, bool achterstevoren = false, char tussenteken = ' ')
{
    if (!achterstevoren) 
    {
        cout << array[0];
        for (size_t i = 1; i < aantal; i++)
        {
            cout << tussenteken << array[i];
        } cout << endl;
    } else {
        cout << array[aantal-1];
        for (size_t i = aantal-1; i > 0; i--)
        {
            cout << tussenteken << array[i-1];
        } cout << endl;
    }
}

int main(int argc, char const *argv[])
{
    int t[] = {1, 3, 5, 7, 9, 11, 13};
    schrijf(t,7);
    schrijf(t,7,true);
    schrijf(t,7,false,'-');
    schrijf(t,7,true,'-');
    return 0;
}
