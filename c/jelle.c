#include <stdio.h>
#include <stdbool.h>
void verzetNaarEersteHoofdletter(const char **);
const char *pointerNaarEersteKleineLetter(char *);

int main()
{
    char zus1[50] = "sneeuwWITje";
    char zus2[50] = "rozeROOD";
    const char *begin = zus1;
    verzetNaarEersteHoofdletter(&begin);
    printf("%s", begin);
    /*const char *eind = pointerNaarEersteKleineLetter(begin);
    schrijf(begin, eind); */
    /*printf("\n");
    begin = zus2;
    verzetNaarEersteHoofdletter(&begin);
    eind = pointerNaarEersteKleineLetter(begin);
    schrijf(begin, eind); */

    return 0;
}
void verzetNaarEersteHoofdletter(const char **pbegin)
{

    while (**pbegin && !('A' <= **pbegin && **pbegin <= 'Z'))
    {
        (*pbegin)++;
        printf("hey");
    }
}
