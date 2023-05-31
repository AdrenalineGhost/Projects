#include <iostream>
#include <string>
using namespace std;

int main(int argc, const char *argv[]){
	int tabs = 0; int opened = 0;
	if (argc >= 2) {tabs = atoi(argv[1]);} else {tabs = 1;}
	if (argc == 3) {opened = atoi(argv[2]);} else {opened = 2;}


	cout << "started" << endl << "tabs= " <<tabs << endl;
	int counter = 0;
	int tab_count = 1;
	while(tab_count<tabs){
		counter++;
		tab_count += opened;
		tab_count -= 1;
	}
	cout << "ended with " << tab_count << " tabs and " << counter << " operations" << endl;
	return 0;
}
