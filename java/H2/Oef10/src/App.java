import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // oef10a();
        oef10b();
    }

    static int ask(Scanner sc, String question){
        System.out.print(question);
        return sc.nextInt();
    }

    static void oef10a(){
        int in, sum= 0, count = 0;
        try(Scanner sc = new Scanner(System.in)){
            in = ask(sc, "Geef getal: ");
            while(in != 0){
                if(in<0) {sum+=in; count++;}
                in = ask(sc, "Geef getal: ");
            } 
        }
        if(count==0){
            System.out.println("Geen negatieve getallen!");
        } else {
            System.out.println(String.format(
                "%d negatieve getallen met een gemiddelde van %.1f",
                count,
                (double)sum/count
            ));
        }
    }

    static void oef10b(){
        int max,min,in;
        try(Scanner sc = new Scanner(System.in)){
            in = ask(sc, "Geef getal: ");
            max = in; min = in;
            while (in !=0){
                if (in>max) max = in;
                else if (min>in) min=in;
                in = ask(sc, "Geef getal: ");
            } 
        }
        if(max == 0){
            System.out.println("DONT");
        } else{
            System.out.println(String.format(
                "min: %d%nmax: %d",
                min, max
            ));
        }
    } 

}
