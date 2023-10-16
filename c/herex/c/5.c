#include <stdio.h>
int main(){
    int macht = 1;
    //dit volgende is hard gecodeert voor absoluut geen reden?
    for(int i=0; i<20; i++){
        printf("%d ",macht);
        macht *= 2;
        if(macht > 10000){
            //break is niet nodig indien bovenstaande comment gefixed wordt
            break;
        }
    }
    return 0;
}
