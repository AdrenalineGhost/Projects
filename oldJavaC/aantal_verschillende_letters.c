#include <stdio.h>
#include <math.h>
#include <malloc.h>

// ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;REDUNDANT
// typedef struct knoop knoop;
// struct knoop {
//     int getal;
//     knoop * volgend;
// };
typedef struct{
    int getal;
    knoop * volgend;
} knoop;

knoop * pointer_naar_knoop(knoop * lst, int g){
    knoop * kn = lst;
    while (kn)
    {
        if (kn->getal==g)
        {
            return kn;
        }
        kn = kn->volgend;
        
    }
    return 0;
}

void printknopen(knoop * lst){
    while (lst)
    {
        printf("%d\t",lst->getal);
        lst = lst->volgend;
    }
    printf("\n\n");
}

knoop* maak_lijst() {
    knoop *l = 0;
    int g; scanf("%d",&g);
    if (g) {
        l = malloc(sizeof(knoop));
        knoop *h = l; h->getal = g;
        scanf("%d",&g);
        while (g) {
            h->volgend = malloc(sizeof(knoop));
            h = h->volgend; h->getal = g; scanf("%d",&g);
        }
        h->volgend = 0;
    }
    return l;
}

int main(int argc, char const *argv[])
{
    knoop * kn = maak_lijst();
    knoop * newkn = pointer_naar_knoop(kn,20);
    printknopen(kn);
    if (newkn)
    {
        printknopen(newkn);
    }
    
    return 0;
}















// char* herhaal(char * s, int amount){
//     int size = (sizeof(s)/sizeof(s[0]));
//     char *newstring = (char *)malloc(size*amount+1);
//     for (size_t i = 0; i < amount; i++)
//     {
//         for (size_t j = 0; j < size; j++)
//         {
//             newstring[i*size+j] = s[j];
//         }
        
//     }
//     return newstring;
// }

// int main(int argc, char const *argv[])
// {
//     char str[50];
//     gets(str);
//     char *permstring = herhaal(str, 5);
//     puts(permstring);
//     free(permstring);
//     return 0;
// }














// void change(double(*)(double), double *, int);
// int main() {
//     double tab[] = {1.0,2.0,4.0,8.0};
//     change(sqrt,tab,4);
//     for (int i = 0; i < sizeof(tab)/sizeof(tab[0]); i++)
//     {
//         printf("%f\n",tab[i]);
//     }
    
// }
// void change(double(*fp)(double), double *t, int n) {
//     for (int i=0 ; i<n ; i++)
//     t[i] = fp(t[i]);
// }







// void schrijf_aantal(const char * p, int n){

//     for (size_t i = 0; i < n; i++)
//     {
//         printf("%c",*p++);

//     }
    
    
// }

// int sizeoff(const char * p){
//     int i = 0;
//     while (*p++!=NULL)
//     {
//         i++;
//     }
//     return i;
// }

// int main(){

//     char letters [] = {'p','o','r','g','o','e','d','o','i','e','o','k','i',':','a','-','t','('};
//     // char *p = letters+3;

//     schrijf_aantal(letters+3,4);
//     printf("\n");
//     // schrijf(p+10,p+12);
//     printf("Was size = %c\n",sizeoff(letters));
//     return 0;
// } 