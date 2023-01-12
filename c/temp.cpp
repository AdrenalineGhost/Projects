#include <iostream>

using namespace std;

int main(){
	int counter = 0;
	int number = 1;
	while(number<90){
		counter++;
		number += 4;
		cout << "4 Opened" << endl;
		number -= 1;
		cout << "Window closed" <<endl << endl;
	} cout << "ended with " << number << " tabs and " << counter << " opperations" << endl;
	return 0;
}
