#include <iostream>
#include <string>
#include <iomanip>
#include <random>
#include <algorithm>

using namespace std;

struct persoon{
    string naam;
    int leeftijd;
    int lengte;
};

int grootte(int number) {return number;}
int grootte(double number) {return (int)number;}
int grootte(string zin) {return zin.size();}
int grootte(persoon pers) {return pers.leeftijd;}




template <typename T>
T grootste(T array[], int lengte) 
{
    T grst = array[0];
    for (size_t i = 0; i < lengte; i++)
    {
        if (grootte(grst) < grootte(array[i]))
        {
            grst = array[i];
        }
    }
    return grst;
}

void initialiseer(persoon &pers, string naam, int leeftijd, int lengte) 
{
    pers.naam = (string)naam; 
    pers.leeftijd = (int)leeftijd; 
    pers.lengte = (int)lengte;
}

void print(persoon pers)
{
    cout << pers.naam << setw(10) << pers.leeftijd << setw(10) << pers.lengte << endl << endl;
}

int main(int argc, char const *argv[])
{
    persoon personen[3];
    initialiseer(personen[0],"sam",19,177); 
    initialiseer(personen[1],"marwan",20,180);
    initialiseer(personen[2],"alina",21,179);

    persoon gr = grootste(personen, 3);
    print(gr);

    double getallen[5] = {5.5,7.7,2.2,9.9,9.8};
    string woorden[3] = {"geloof","hoop","de liefde"};
    cout << "Grootste getal is: " <<  grootste(getallen,5) << endl;
    cout << "Het grootste woord is: " << grootste(woorden,3) << "." << endl;
    return 0;
}
