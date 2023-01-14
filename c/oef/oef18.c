
#include <stdio.h>

void wissel(int *a, int *b){
	printf("  Bij start van de wisselprocedure hebben we a=%d en b=%d.\n",*a,*b);
	int  hulp = *a;
	*a = *b;
	*b = hulp;
	printf("  Op het einde van de wisselprocedure hebben we a=%d en b=%d.\n",*a,*b);
}

int main(){
	int x = 5;
	int y = 10;

	printf("Eerst hebben we x=%d en y=%d.\n",x,y);
	wissel(&x,&y);
	printf("Na de wissel hebben we x=%d en y=%d.\n",x,y);

	return 0;
}
