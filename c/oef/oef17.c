#include <stdio.h>

int main(){
	int i=7, j;
	double d;
	int *ip, *jp, *tp;
	double *dp;
	void *v;
	const int * p1;
	int * const p2 = &i;
	int t[5] = {10,20,30,40,50};

	/* 1*/ jp = &i;
	/* 2*/ j = *jp;
// \/ Segmetation fault \/
//	/* 3*/ *ip = i;
	/* 4*/ ip = jp;
//	/* 5*/ &i = ip;
	/* 6*/ (*ip)++;

	/* 7*/ tp = t+2;
	/* 8*/ j = &t[4] - tp;
//	/* 9*/ t++;
	/*10*/ (*t)++;
	/*11*/ j = (*tp)++;
	/*12*/ i = *tp++;

	/*13*/ v = tp++;
//	/*14*/ printf("%d", *v);
//	/*15*/ v++;

	/*16*/ p1 = ip;
//	/*17*/ jp = p1;
//	/*18*/ (*p1)--;
//	/*19*/ dp = &i;
	/*20*/ dp = v;

	/*21*/ jp = p2;
//	/*22*/ p2 = p1;
	/*23*/ *p2 += i;
	return 0;
}
