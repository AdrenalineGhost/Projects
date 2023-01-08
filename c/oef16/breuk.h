#include <iostream>


using namespace std;

int mijn_gdd(int, int){}

class Breuk{
    private:
        int teller, noemer;
        void normaliseer();
    public:
        Breuk(int=0,int=1);
        Breuk operator+(const Breuk&) const;
        Breuk operator-(const Breuk&) const;
        Breuk operator-() const;
        Breuk& operator-=(const Breuk&);
        Breuk& operator+=(const Breuk&);
        Breuk& operator++();
        Breuk operator++(int);
        friend ostream& operator<<(ostream &, const Breuk &);
        Breuk operator+(int) const;
        bool operator<(const Breuk&) const;
        friend bool is_stambreuk(const Breuk&);
        bool operator==(const Breuk&) const;
        bool operator!=(const Breuk&) const;
};

Breuk::Breuk(int n, int t) : teller(t), noemer(n){ normaliseer();}

