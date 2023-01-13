#include <stdio.h>
#include <stdlib.h>

int index_van(char*,char);

int main(int argc, char **argv){
char letters [] = {'p','o','r','e','o','i','f','o','i','e','c','i','i',':','a','-','t','('};
if(argc==2){printf("%d",index_van(letters, argv[1][0]));}
return 0;}

int index_van(char *t, char g)
{

int counter = 0;

while (t)
{

if (g==*t){return counter;}
counter++;
t++;

}

return -1;

}
