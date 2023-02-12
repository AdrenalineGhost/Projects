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
	knoop * l = maak_gesorteerde_lijst_automatisch(10,4);
	print(l);
	printf("\nnu worden dubbels verwijderd: \n");
	verwijder_dubbels(l);
	printf("\nna verwijderen van dubbels: \n\n");
	print(l);
	return 0;
}


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

// SWAP
void swap(int* xp, int* yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}

// SELECTION SORT
void selectionSort(int arr[], int n)
{
    int i, j, min_idx;

    // One by one move boundary of unsorted subarray
    for (i = 0; i < n - 1; i++) {

        // Find the minimum element in unsorted array
        min_idx = i;
        for (j = i + 1; j < n; j++)
            if (arr[j] < arr[min_idx])
                min_idx = j;

        // Swap the found minimum element
        // with the first element
        swap(&arr[min_idx], &arr[i]);
    }
}

// MAAK LIJST
knoop * maak_gesorteerde_lijst_automatisch(int n, int max)
{
	int random[n];

	for (int i = 0; i < n; i++)
	{
		random[i]=rand()%(max+1);
	}

	selectionSort(random, n);

	knoop * kn = 0;
	for (int i = 0; i < n; i++)
	{
		printf("Made new knoop %d\n",random[i]);
		voeg_vooraan_toe(random[i], &kn);
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
