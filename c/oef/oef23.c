#include <stdio.h>

void print(char * t, char * e){while(*t!=*e&&*t){printf("%c\t",*t);t++;}}

// Count comes out as way too high, so fix it.
int distance(char * x, char *y){
	int count = 0;
	while (*x && x!=y){
		count++; x++;
	}
}


void pivoteer(char * b, char * pivot, char * e){
	int count = distance(b,pivot);
	if (pivot+count==e&&b+2*count==e){
		char hulp = *b;
		*b = *e;
		*e = hulp;
	} else {printf("not a pivot point! Count: %d \n",count);}
}



int main(){
    char tekst[] = {'b','d','?','z','g','o','e','z','e','b',
                    ' ','d','i','g','!','h','o','s','v'};
    pivoteer(tekst+7,tekst+12,tekst+17);
    print(tekst+4,tekst+15);
    return 0;
}
