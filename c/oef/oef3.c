#include <stdio.h>

// Version of oef1.c
// Shit cause has to check every number if it is either 1 or 10

int main(){

     for(int i=10; i>0; i--){
          if(i==10){
               printf("Hello world!\n");
          }
          printf("%d ",i);
          if(i==1){
               printf("\nSTART");
          }
     }

return 0;}
