// Version of oef4.c
#include <stdio.h>
int main(){
    int macht = 1;
    // Gives less points cause has a check extra and has 2 hardcoded values.
    for(int i=0; i<20; i++){
        printf("%d ",macht);
        macht *= 2;
        if(macht > 10000){
            break;
        }
    }
    return 0;
}
