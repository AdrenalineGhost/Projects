#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

typedef struct knoop knoop;
struct knoop{
    int getal;
    knoop * volgend;
};

void vernietig_lijst(knoop **);
void voeg_vooraan_toe(int, knoop **);
void print(knoop *);
void vernietig_lijst(knoop **);
knoop * maak_gesorteerde_lijst_automatisch(int, int);
void verwijder_dubbels(knoop *);

int main(){
    srand(time(NULL));
    knoop * m = maak_gesorteerde_lijst_automatisch(10,1000);
    knoop * n = maak_gesorteerde_lijst_automatisch(5,1000);
    printf("\nLIJST m:\n");    print(m);
    printf("\nLIJST n:\n");    print(n);
    printf("\nDeze worden gemerged. \n\n");

    knoop * mn = merge(...,...);

    printf("\nLIJST m:   \n");	print(m); //lege lijst
    printf("\nLIJST n:   \n");	print(n); //lege lijst
    printf("\nRESULTAAT: \n");	print(mn);
    ....   /* aan te vullen */
    return 0;
}

//// MERGE
//knoop * merge(knoop * kn1, knoop *kn2)
//{
//knoop * kn = malloc(sizeof(knoop));
//
//}

// VOEG KNOOP TOE
void voeg_vooraan_toe(int number, knoop ** l)
{

	knoop * temp = *l;
	*l = malloc(sizeof(knoop));
	(*l)->getal = number;
	(*l)->volgend = temp;
}


// PRINT LIJST
void print(knoop * kn)
{
	while (kn){
		printf("%d ",kn->getal);
		kn = kn->volgend;
	}
}


// REMOVE
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


// MAAK LIJST
knoop * maak_gesorteerde_lijst_automatisch(int n, int max)
{
	knoop * kn = 0;
	for (int i = 0; i < n; i++)
	{
		int random = rand()%(max+1);
		printf("Made new knoop %d\n",random);
		voeg_vooraan_toe(random, &kn);
	}
	return kn;
}


// VERWIJDER
void verwijder_dubbels(knoop * l)
{
	while(l)
	{
		while(l->volgend && l->getal == l->volgend->getal)
		{
			printf("%d ",l->getal);
			knoop * rember = l->volgend;
			l->volgend = rember->volgend;
			free(rember);
		}
		l = l->volgend;
	}
}
