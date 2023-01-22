public class boogsin {
    public static void main(String[] args){

        double x = -0.5;
        double exp  = 1;
        double sum = x;
        int n = 10, e = 2, o = 1;


        for (int i = 2; i <= n; i++){
            exp += 2;

            sum += (double)(o/e) * (double)(Math.pow(x, exp)/exp);

            o = o * (o+2);
            e = e * (e+2);
        }
        System.out.println(sum);
    }
}