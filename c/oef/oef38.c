#include <stdio.h>
#include <stdlib.h>

typedef struct knoop knoop;
struct knoop{
    int getal;
    knoop * volgend;
};

void vernietig_lijst(knoop **);
void voeg_vooraan_toe(int, knoop **);
void print(knoop *);
void vernietig_lijst(knoop ** l);

int main(){
    knoop * lst = 0;
    voeg_vooraan_toe(7,&lst);
    voeg_vooraan_toe(3,&lst);
    print(lst);
	vernietig_lijst(&lst);
    return 0;
}

void voeg_vooraan_toe(int number, knoop ** l){

	knoop * temp = *l;
	*l = malloc(sizeof(knoop));
	(*l)->getal = number;
	(*l)->volgend = temp;
}

void print(knoop * kn){
	while (kn){
		printf("%d ",kn->getal);
		kn = kn->volgend;
	}
}

void vernietig_lijst(knoop ** l)
{
	while (*l)
	{
		knoop * remember = *l;
		*l = remember->volgend;
		printf("\nfreed: %d",remember->getal);
		free(remember);
	}
}
