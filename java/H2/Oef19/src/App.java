import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int km;
        try(Scanner sc = new Scanner(System.in)){
            km = askKm(sc);
        }

        for(int i = 40; i <= 140 ; i+= 10){
            System.out.printf(
                "%20s%20s%20s%n",
                String.format("%d km", km),
                String.format("%d km/u", i),
                String.format("%d u %d min",
                                km/i,
                                (int)(((km*1.0)*60)/i)%60
                )
            );
        }
        
    }
    
    static int askKm(Scanner sc){
        int in;
        do{
            in =askInt(sc, "Geef een afstand in km (strikt positief): ");
        }while(in<=0);
        return in;
    }

    static int askInt(Scanner sc, String s){
        System.out.printf(s);
        return sc.nextInt();
    }


}
