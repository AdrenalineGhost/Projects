import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int in;
            // Map<Integer, String> hm = new HashMap<>();
            // hm.put(9300, "Aalst");
            // hm.put(2000, "Antwerpen");
            // hm.put(1000, "Brussel");
            // hm.put(9200, "Dendermonde");
            // hm.put(9000, "Gent");
            // hm.put(8500, "Kortrijk");
            // hm.put(9700, "Oudenaarde");
            // hm.put(2300, "Turnhout");
            do{
                in = getInput(sc);
            } while (!(in>999&&in<9999));
            // String found = hm.get(in);
            String found = switch(in){
                case 9300 -> "Aalst";
                case 2000 -> "Antwerpen";
                case 1000 -> "Brussel";
                case 9200 -> "Dendermonde";
                case 9000 -> "Gent";
                case 8500 -> "Kortrijk";
                case 9700 -> "Oudenaarde";
                case 2300 -> "Turnhout";
                default -> "";
            };
            if(!found.isEmpty())
                System.out.println(String.format("Postnummer %d komt overeen met de stad %s.", in, found));
             else 
                System.out.println(String.format("Postnummer %d komt niet overeen met een stad.", in));

        }
    }
    static int getInput(Scanner sc){
        System.out.print("Geef een postcode(4 cijfers): ");
        return sc.nextInt();
    }
}
