#include <stdio.h>
int main(){
    int t[6] = {0,10,20,30,40,50};
    int* pt[3];

    for(int i=0; i<3; i++){
        pt[i] = &t[2*i];
    }

    pt[1]++;
    pt[2] = pt[1];
    *pt[1] += 1;
    *pt[2] *= 2;
	// 0 62 62
	// 0 10 20 62 40 50


    int ** ppt = &pt[0];
	//ppt -> pt[0] -> 0
    (*ppt)++;
	//ppt -> pt[0] -> 10
    **ppt += 1;
	//ppt -> pt[0] -> 11
    for(int i=0; i<6; i++){
        printf("%d ",t[i]);
    }//0 11 20 62 40 50
    printf("\n");
    for(int i=0; i<3; i++){
        printf("%d ",*pt[i]);
    }//11 62 62
    printf("\n");
    return 0;
}
