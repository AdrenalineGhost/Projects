#include <stdio.h>
#include <string.h>
#include <stdlib.h>


char * lees();

int main(){
    for(int i=0; i<5; i++){
        char * tekst = lees();
        printf("Ik las ***%s*** \n",tekst);
		free(tekst);
    }
    return 0;
}

char * lees(){
	char string[256];
	fgets(string, sizeof(string), stdin);

	char * newstring = malloc(sizeof(string));

	strcpy(newstring, string);

	return newstring;
}
