#include <stdio.h>


int main(int argc, char *argv[])
{
    float imp = 0.23;
    int fact = 1;
    float exp = imp;
    float result = imp;
    for (int term = 1; term < 10; term++) {
        fact *= (2*term) * (2*term+1);
        exp *= imp * imp;
        result += (-1+(2*(term%2)))  *  imp  /  fact;
        printf("%d\n",( 1-(2*(term%2))));
        printf("%f\n", result);
    }
    /* printf("%f\n",result); */
    return 0;
}
