#include <stdio.h>
#include <stdlib.h>


int cijfersom(char *c);

int main(int argc, char **argv){
	int sum = cijfersom(argv[1]);
	printf("%d",sum);

return 0;}

int cijfersom(char *c){
	int sum = 0;
	while(*c){
		sum += (int)*c - (int)'0';
		c++;
	}
	return sum;
}
