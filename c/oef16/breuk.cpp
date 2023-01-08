#include <iostream>

using namespace std;

int mijn_ggd(int a, int b){
    if(a < 0 || b < 0){
        return mijn_ggd(abs(a),abs(b));
    }
    if(b == 0){
        return a;
    }
    return mijn_ggd(b,a%b);
}