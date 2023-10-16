import java.util.Random;

public class Oef6 {
    public static void main(String[] args) {
        Random rand = new Random();
        rand.doubles(10).map(x -> x*10+10).forEach(System.out::println);
    }
}
