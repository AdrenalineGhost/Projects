#include <stdio.h>
#include <stdlib.h>

const int SIZE = 18;

char * plaats_van(char*,char);

void print(char *);

int main(int argc, char **argv){
	char letters [] = {'p','o','r','e','o','i','f','o','i','e','c','i','i',':','a','-','t','('};

	if(/*argc==2*/ 0==0){
		char * newp = plaats_van(letters, /*argv[1][0]*/'e');
		*newp += 2;
		printf("%p/n",newp);
		printf("\t%c\n",*newp);
		print(letters);
	}
	return 0;
}


char * plaats_van(char *t, char g)
{

	for (int j = 0; j < SIZE; j++)
	{

	if (g==*t){break;}
	t++;

	}

	return t;

}

void print(char * t){
	printf("%c",*t); t++;
	for (int j = 1; j < SIZE; j++)
	{
		printf(", %c",*t);
		t++;
	}
}
