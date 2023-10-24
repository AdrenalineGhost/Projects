import java.util.Scanner;

import domein.*;

public class RekenmachineApp {
    private static Scanner sc = new Scanner(System.in);
    private static final int SOM = 1;
    private static final int VERSCHIL = 2;
    private static final int VERMENIGVULDIGING = 3;
    private static final int DELING = 4;
    private static final int STOPPEN = 5;
    public static void main(String[] args) {
        new RekenmachineApp().start();
    }
    private void start(){
        Rekenmachine rm = new Rekenmachine();
        int menuKeuze = maakMenuKeuze();
        while (menuKeuze!=5){
            double in1 = leesGetal("eerste");
            double in2 = leesGetal("tweede");
            char c;
            switch(menuKeuze){
                case SOM                -> {rm.telOp(in1, in2); c='+'; }
                case VERSCHIL           -> {rm.trekAf(in1, in2); c='-'; }
                case VERMENIGVULDIGING  -> {rm.vermenigvuldig(in1, in2); c='*'; }
                case DELING             -> {rm.deel(in1, in2); c='/'; }
                default                 -> c = ' ';
            }
            toonResultaat(in1, in2, c, menuKeuze);
            menuKeuze = maakMenuKeuze();
        }
    }
    private double leesGetal(String string){
        System.out.printf("Geef het %s getal in: ", string);
        return sc.nextDouble();
    }
    private void toonResultaat(double getal1, double getal2, char c, double resultaat){
            System.out.printf("%.2f %c %.2f = %.2f %n%n", getal1, c, getal2, resultaat);
    }
    private int maakMenuKeuze(){
        int keuze;
        do{
            System.out.printf("Welke actie wil je uitvoeren?  %nl. Som %n2. Verschil %n3. Vermenigvuldiging %n4. Deling %n5. Stoppen %nGeef je keuze in: ");
            keuze = sc.nextInt();
        } while (keuze>5||keuze<1);
        return keuze;
    }
}
