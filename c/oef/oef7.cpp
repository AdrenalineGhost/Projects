#include <iostream>
#include <string>
#include <iomanip>
#include <random>
#include <algorithm>
#include <fstream>

int main(int argc, char const *argv[])
{
    std::ifstream inv1("stationnetje.txt");
    std::ifstream inv2("paddestoel.txt");
    std::ofstream uitv("mix.txt");
    if (!inv1) {std::cout << "cant find file inv1";} else if (!inv2) {std::cout << "cant find file inv2";} else if (!uitv) {std::cout << "cant find file uitv";} // Check for files being there
    // uitv.app; inv1.app; inv2.app;
    
    int index = 1;
    
    while (!inv1.eof() && !inv2.eof())
    {
        std::string temp = "";
        if (index == 1)
        {
            getline(inv1,temp);
            uitv << temp << "\n";
            getline(inv2,temp);
        } else {
            getline(inv2,temp);
            uitv << temp << "\n";
            getline(inv1,temp);
        }
        index *= -1;
    }
    inv1.close(); inv2.close(); uitv.close();
    return 0;
}
