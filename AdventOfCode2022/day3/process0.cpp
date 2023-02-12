#include <iostream>
#include <fstream>

using namespace std;

int chartoint(char);
int getcommonchartoint(string, string ,string);

int main()
{
	string text;
	string texts[3];
	int endtotal = 0;
	ifstream File("input0.txt");
	int counter = 0;
	while (getline(File, text)){
		if (text != "\n" && text != " " && text != ""){
			counter++;
			counter = counter%3;
			texts[counter] = text;
			if (counter == 2){
				endtotal += getcommonchartoint(texts[0], texts[1], texts[2]);
			}
		}
	}
	File.close();
	cout << endtotal;
return 0;}

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
