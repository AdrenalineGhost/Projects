public class App {
    public static void main(String[] args) throws Exception {
        int lions = 50;
        double rate = 1.15;
        int count = 0;

        do{
            lions*=rate;
            count++;
        } while(lions<1000);
        System.out.println(count);
    }
}
