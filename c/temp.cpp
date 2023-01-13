#include <iostream>
#include <string>
using namespace std;

int main(int argc, const char *argv[]){
	int tabs = 0; int opened = 0;
	if (argc >= 2) {tabs = atoi(argv[1]);} else {tabs = 1;}
	if (argc == 3) {opened = atoi(argv[2]);} else {opened = 2;}
	cout << "started" << endl << "argc= " << argc << endl << "tabs=" <<tabs << endl;
	int counter = 0;
	int number = 1;
	while(number<tabs){
		counter++;
		number += opened;
		number -= 1;
	}
	cout << "ended with " << number << " tabs and " << counter << " opperations" << endl;
	return 0;
}
