public class Oef5 {
    public static void main(String[] args) {
        double startValue = 2.0;
        double result = 1.0;
        int i = 0;
        while(result<10000){
            print(startValue,result,i);
            i++;
            result *= startValue;
        }
    }

    static void print(double original, double resulting, int i){
        System.out.println("De " + i + "de macht van " + original + " is " + resulting);
    }
}
