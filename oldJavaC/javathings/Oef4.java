public class Oef4 {
    public static void main(String[] args) {
        double startValue = 2.0;
        double result = 1.0;
        int power = 10;
        print(startValue,1.0,0);
        for (int i = 0; i < power; i++) {
            result *= startValue;
            print(startValue,result,i+1);
        }
    }


    static void print(double original, double resulting, int i){
        System.out.println("De " + i + "de macht van " + original + " is " + resulting);
    }
}
