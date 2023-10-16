public class Oef9 {
    public static void main(String[] args) {
        double x = (0.4);
        System.out.println(arcsin(x, 7));
        System.out.println(Math.asin(x));
    }
    static double arcsin(double in){
        return arcsin(in, 3);
    }
    static double arcsin(double in, int itter) {
        double pre = 1;
        double x = in;
        double total = x;
        for (int i = 1; i < itter + 2; i++) {
            pre *= (i * 2.0 - 1.0) / (i * 2.0);
            x *= 1.0 * x * x;
            total += x * pre * 1.0 / (i * 2.0 + 1);
            System.out.println(String.format("%.9e * %f / (%d * 2 + 1) => %.9e",x ,pre, i, total));
        }
        return total;
    }
}
