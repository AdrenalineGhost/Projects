import java.util.Scanner;

public class App {
    public static void main (String[] args) {

        try(Scanner sc = new Scanner(System.in)){

            int in1, in2;
        //oef1
            // do{
        //         System.out.println("Geef een strikt negatief oneven getal in");
        //         in = sc.nextInt();
        //     }
        //     while(in > 0 && in%2==1);
        //     System.out.println("correct");
        //oef2
            do {
                System.out.println("Geeft 2 getallen:");
                in1 = sc.nextInt();
                in2 = sc.nextInt();
            } while (in1%12==0||in1==1000||in2<=in1);
            System.out.println("correct");
        }
    }
}
