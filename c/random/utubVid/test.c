#include <stdio.h>

int check(int);

int main(){
    for(int index = 0; index <= 3, index++;){
        printf("%d", index);
        int input=0;
        scanf("%d", &input);
        int checked = check(input);
        printf("%d", checked);
    }
    return 0;
}

int check(int in){
    printf("%d",in);
    return in>0?1:0;
}
