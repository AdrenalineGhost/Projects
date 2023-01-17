#include <stdio.h>
#include <stdlib.h>

typedef unsigned int uint;

int bit_i(uint,int);

int main()
{
return 0;
}

int bit_i(uint x, int i)
{
return (x >> i)&1;
}

uint eenbit(int i)
{
return 1<<i;
}

int aantal_eenbits(uint x)
{
int counter = 0;
while (x){counter+=x&1;x>>1;} return counter;
}

uint bit_i_aangezet(uint x, int i)
{
	return x | eenbit(i);
}

uint bit_i_uitgezet(uint x, int i)
{
	return x & ~(eenbit(i));
}

uint bit_i_gewisseld(uint x, int i)
{
	return x ^ eenbit(i);
}

uint zijn_gewisseld(uint x, uint y)
{
	return x^y;
}

uint is_even(uint x)
{
	return ~(x&1);
}

