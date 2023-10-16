import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int count = 0, last, in;
        try(Scanner sc = new Scanner(System.in)){
            last = ask(sc, "Geef getal (-2000 om te stoppen): ");
            in = last;
            while(in != -2000){
                if(in<last) count++;
                last = in;
                in = ask(sc, "Geef getal (-2000 om te stoppen): ");
            }
        }
        System.out.printf("%d",count);
    }

    static int ask(Scanner sc, String s){
        System.out.printf(s);
        return sc.nextInt();
    }

}
