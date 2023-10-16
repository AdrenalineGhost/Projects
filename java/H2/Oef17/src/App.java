import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int in;
            System.out.print("Geef een geheel getal:");
            in = sc.nextInt();

            if(in > 0){
                System.out.println("Het getal was strikt positief en is verminderd met 10.");
                System.out.println("het getal is nu " +(in-10));
            } else {
                System.out.println("Het getal was negatief en is vermeerderd met 10.");
                System.out.println("het getal is nu " +(in+10));
            }
            

        }
    }
}
