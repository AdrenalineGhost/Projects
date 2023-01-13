#include <stdio.h>
#include <time.h>
int main(){

srand(time(NULL));
for (int i = 0; i< 20;i++){printf("%d ",100 + rand()%26);}

return 0;}
