#include <stdio.h>
int main(int argc, char *argv[])
{
    long long fact = 1L;
    for (int i = 2; i < 20; i++) {
        fact *= i;
        printf("%lld\n",fact);
    }
    return 0;
}
