#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	if (argc <= 1) return 0;
	for (int i = 1; i < argc; i+=2)
	{
		switch (atoi(argv[i])){
			case 1:
				printf("first one: %s\n", argv[i+1]);
				break;
			case 2:
				printf("second one: %s\n", argv[i+1]);
				break;
			default:
				printf("n/a\n");
		}
	}
	return 0;
}
