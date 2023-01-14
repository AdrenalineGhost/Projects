#include <stdio.h>

void schrijf_aantal(char * p, int n){
	for (int i = 0; i < n; i++){printf("%c \t",p[i]);}
}

void schrijf(char * b, char * e){
	char *s = b;
	while(s!=e){printf("%c \t",*s);s++;}
}




int main(){

    char letters [] = {'p','o','r','g','o','e','d','o','i','e','o','k','i',':','a','-','t','('};
    char *p = letters;

    schrijf_aantal(letters+3,4);
    printf("\n");
    schrijf(p+10,p+12);
    return 0;
}
