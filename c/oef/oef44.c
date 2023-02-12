#include <stdio.h>
#include <stdlib.h>

typedef unsigned int uint;

void wijzig_eerste_cijfer(int *);

// USING ARGC/ARGV !!!
int main(int argc, char *argv[])
{
	int letter = atoi(argv[1]);
	printf("%d= %x\n",letter,letter);
	wijzig_eerste_cijfer(&letter);
	printf("%d= %x",letter,letter);
}

void wijzig_eerste_cijfer(int * g)
{
	int hulp = *g;
	int f = 0xf;
	hulp >>= 4;
	while(hulp)
	{
		f <<= 4;
		hulp >>= 4;
	}
	*g = *g | f;
}
