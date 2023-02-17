#include <iostream>
#include <fstream>

using namespace std;

int chartoint(char);
int getcommonchartoint(string, string ,string);

// parses input0.txt 3 lines at a time
int main()
{
	string text;
	string texts[3];
	int endtotal = 0;
	ifstream File("input0.txt");
	int counter = 0;
	while (getline(File, text)){
		if (counter == 2){
			endtotal += getcommonchartoint(texts[0], texts[1], texts[2]);
		}
		if (text != "\n" && text != " " && text != ""){
			texts[counter] = text;
			counter++;
			counter = counter%3;
		}
	}
	File.close();
	cout << endtotal;
return 0;}

// tries to find a common char in 3 strings and returns the int value of that char acoring to ::chartoint
int getcommonchartoint(string te, string xt, string xtra){
	if (te != "\n" && xt != "\n" && xtra != "\n"){
		cout << "Text: " << te << " == " << xt << " == " << xtra << endl;
		for (char& char1:te){
			for (char& char2:xt){
				for (char& char3:xtra){
					if (char1 == char2 && char2 == char3 && char1 == char3){
						cout << "Found common = " << char1 << " with " << chartoint(char1) << " being the number." << endl << endl;
						return chartoint(char1);
					}
				}
			}
		}
	}
	cout << "None Found?" << endl << endl;
	return 0;
}

// returns a int counting up form a			a=1,b=2,c=3, ... ,z=26,A=27, ... , Z=...
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

