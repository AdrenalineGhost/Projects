#include <stdio.h>

int main(int argc, char **argv)
{
	int freq[26]={0};
	char letters[] = "Als je tevreden bent met weinig, bezit je veel.";
	int size = sizeof(letters)/sizeof(letters[0]);
	for (int i = 0; i < size;i++){
		if (letters[i]>='A'&&letters[i]<='Z'){letters[i] = (char)(letters[i]+32);}
		freq[(int)letters[i]-(int)'a']++;
	}
	for (int i = 0; i < 26; i++){
		printf("%c\t",'a'+i);
		for (int j = 0; j < freq[i]; j++){
			printf("*");
		}
		printf("\n");
	}
return 0;
}


