#include <iostream>
#include <fstream>

using namespace std;

int getcommonchartoint(string)
int chartoint(char);

int main()
{
	string text;
	int endtotal = 0;
	ifstream File("input.txt");
	while (getline (File,  text)) {
		endtotal += getcommonchartoint(text);
	}
	File.close();
	cout << endtotal;
return 0;}

int getcommonchartoint(string text){
	string te;
	string xt;
	if (text != "\n"){
		te = text.substr(0, int(text.length()/2));
		xt = text.substr(int(text.length()/2), text.length());
		cout << "Text: " << te << " == " << xt << endl << endl;
		for (char& char1:te){
			for (char& char2:xt){
				if (char1 == char2 && broken == 0){
					return chartoint(char1);
				}
			}
		}
	}
	return 0;
}

int chartoint(char c){
	if (c >= 'a' && 'z' >= c){
		return c - 'a'+1;
	}
	if (c >= 'A' && 'Z' >= c){
		return c - 'A'+27;
	}
	printf("returned 0 \n");
	return 0;
}
