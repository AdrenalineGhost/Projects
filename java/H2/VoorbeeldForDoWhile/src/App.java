import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int som = 0;

        try(Scanner sc = new Scanner(System.in)){
            for(int i = 1; i <=5; i++){
                som += getGetal(sc);
            }
        }
        System.out.println(som);
    }

    
    static int getGetal(Scanner sc){
        int getal;
        do{
            System.out.print("Geef getal: ");
            getal = sc.nextInt();
        } while(!(getal<=10&&getal>=0));
        return getal;
    }

}
