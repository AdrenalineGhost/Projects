import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int count = 0;
        try(Scanner sc = new Scanner(System.in)){
            int in = ask(sc, "Geef primegetal: ");
            boolean prime;
            while(in!=0){
                prime = isPrime(in);
                count += prime?1:0;
                System.out.printf("%d is %s primegetal!%n", in, prime?"WEL een":"GEEN" );
                in = ask(sc, "Geef een primegetal: ");
            }
        }
        System.out.printf("%nHet aantal primegetallen is %d", count);
    }

    static boolean isPrime(int x){
        if(x<2) return false;
        for(int i = 2; i <= x/2; i++){
            if(x%i==0) return false;
        }
        return true;
    }

    static int ask(Scanner sc, String s){
        System.out.printf(s);
        return sc.nextInt();
    }

}
