#include <stdio.h>

int main(int argc, char **argv){

	char letters [] = {'p','o','r','e','o','i','f','o','i','e','c','i','i',':','a','-','t','('};

	int size = sizeof(letters)/sizeof(letters[0]);

	printf("%d\n",size);

	for (int i = 0; i < size; i+=2)
	{
		printf("%c",letters[i]);
	}

	return 0;
}
