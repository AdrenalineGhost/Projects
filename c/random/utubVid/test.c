#include <stdio.h>
#include <stdlib.h>

int check(char *);

int main(){
    for(int index = 0; index <= 3, index++;){
        printf("%d", index);
        char* inp;
        scanf("%d", &inp);
        int checked = check(&inp);
        printf("%d", checked);
    }
    return 0;
}

int check(char string[]){
    printf("%d",string);
    return 0;
}
