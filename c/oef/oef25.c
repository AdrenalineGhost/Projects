#include <stdio.h>


void freq(char letters[], int * fs, int size){
	for (int i = 0; i < size;i++){
		if (letters[i]>='A' && letters[i]<='z'){
			if (letters[i]>='A'&&letters[i]<='Z'){letters[i] = (char)(letters[i]+32);}
			fs[(int)letters[i]-(int)'a']++;
		}
	}
}


int main(int argc, char **argv)
{
	int fr[26]={0};
	char * string = "hello There skywalker";
	int size = sizeof(string)/sizeof(string[0]);
	freq(string, fr,size);
	for (int i = 0; i < 26; i++){
		printf("%c\n", fr[i]!=0?'a'+i:' ');
	}
	return 0;
}

