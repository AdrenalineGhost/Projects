#include <iostream>
#include <string>
#include <iomanip>
#include <random>
#include <algorithm>
#include <functional>



void schrijf(std::string text, int array[], int length)
{
    std::cout << text;
    for (size_t i = 0; i < length; i++)
    {
        std::cout << " " <<array[i];
    } std::cout << std::endl;
}

void vul_array(int a[],int b[],int c[],int n,std::function<int(int,int)> func){
    for (size_t i = 0; i < n; i++)
    {
        c[i] = func(a[i], b[i]);
    }
    
}

int main(){
     const int GROOTTE = 10;
     int a[] = {0,1,2,3,4,5,6,7,8,9};
     int b[] = {0,10,20,30,40,50,60,70,80,90};
     int c[GROOTTE];

     vul_array(a,b,c,GROOTTE,[](int x, int y){return x+y;});
     schrijf("SOM:      ",c,GROOTTE);
     /* output bovenstaande opdracht:
        SOM:      0 11 22 33 ...
     */

     vul_array(a,b,c,GROOTTE,[](int x, int y){return x*y;});
     schrijf("PRODUCT:  ",c,GROOTTE);
     /* output bovenstaande opdracht:
        PRODUCT:  0 10 40 60 ...
     */

     vul_array(a,b,c,GROOTTE,[](int x, int y){return x-y;});
     schrijf("VERSCHIL: ",c,GROOTTE);
     /* output bovenstaande opdracht:
        VERSCHIL: 0 -9 -18 -27 ...
     */

     return 0;
}