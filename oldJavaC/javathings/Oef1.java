public class Oef1 {
    public static void main(String[] args) {
        double in = 5.0;
        System.out.println(String.format("Het dubbel van %f is %f", in, in*2));
        System.out.println(String.format("De helft van %f is %f", in, in/2));
        System.out.println(String.format("Het kwadraat van %f is %f", in, in*in));
        System.out.println(String.format("De vierkantswortel van %f is %f", in, Math.sqrt(in)));
    }
}
