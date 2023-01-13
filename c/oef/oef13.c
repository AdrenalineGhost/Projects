#include <stdio.h>
#include <stdlib.h>

void schrijf_links(char *, int);

int main(int argc, char **argv){

	char rij[] = {'s','a','p','a','p','p','e','l'};
	int size = sizeof(rij)/sizeof(rij[0]);
	for (int i = 0; i < 3; i++){schrijf_links(rij,8);for (int j = 0; j < 8; j++){printf("%c",rij[j]);}printf("\n");}

return 0;}

void schrijf_links(char *t, int n){
	char newarray[n];
	for (int i = 0; i < n; i++)
	{
		newarray[i-1<0?i+n-1:i-1] = t[i];
	}
	for (int i = 0; i < n; i++)
	{
		t[i] = newarray[i];
	}
}
