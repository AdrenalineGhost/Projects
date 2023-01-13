//long/double/long long/unsigned long long
#include <stdio.h>
#include <stdlib.h>

unsigned long long fac(int amount){
unsigned long long end = 1;
for (int i = 1; i <= amount;i++){
	end *= i;
}
return end;

}


int main(int argc, char **argv){
int insert = argc==2?atoi(argv[1]):10;
unsigned long long number = fac(insert);
printf("%llu\n",number);

return 0;}

