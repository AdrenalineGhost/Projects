#include <stdio.h>

int main(){
     for(int i=10; i>0; i--){
         //tests every loop so very slow
          if(i==10){
               printf("Hello world!\n");
          }
          printf("%d ",i);
          if(i==1){
               printf("\nSTART");
          }
     }
    /* return 0; */
}
