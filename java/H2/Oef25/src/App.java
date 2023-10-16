import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int teller, noemer;
        try(Scanner sc = new Scanner(System.in)){
            teller = ask(sc, "Geef de teller: ");
            noemer = ask(sc, "Geeft de noemer: ");
        }
        int deling = teller/noemer;
        int rest = teller%noemer;
        System.out.printf(
            "%d/%d = %d%nRest = %d",
            teller,noemer,deling,
            rest
        );
        if(rest == 0){
            System.out.printf("%nVereenvoudigde breuk = %d / 1", deling);
        }

    }

    static int ask(Scanner sc, String s){
        System.out.printf(s);
        return sc.nextInt();
    }

}
