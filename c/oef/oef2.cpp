#include <iostream>
#include <string>
#include <iomanip>
using namespace std;
int main(int argc, char const *argv[])
{
    for (size_t i = 0; i < 64; i++)
    {
        cout << setw(10) << dec << i << setw(10) << hex << i << setw(10) << oct << i << endl;
    }
    
    return 0;
}
