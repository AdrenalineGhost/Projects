#include <stdio.h>

void zoek_extremen(const int t[], int n, int * min, int * max){
*max = t[0];
*min = t[0];
for (int i = 0; i < n; i++){

	if (t[i]>*max){*max=t[i];} else if (t[i]<*min){*min=t[i];}

}
}

int main(){

const int N = 5;
int t[] = {2,7,3,9,1};
int max, min;
zoek_extremen(t,N,&min,&max);
printf("min= %d\tmax= %d",min,max);

return 0;}
