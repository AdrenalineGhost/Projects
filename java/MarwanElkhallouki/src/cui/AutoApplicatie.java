package cui;

import java.util.Scanner;

import domein.Auto;

public class AutoApplicatie {
    public static void main(String[] args) {
        AutoApplicatie au = new AutoApplicatie();
        au.start();
    }

    private static final String KILOMETERS_VRAAG = "Geef aantal kilometers: ";
    private static final String VERGOEDINGS_VRAAG = "Geef Vergoeding: ";
    private Scanner sc = new Scanner(System.in);

    private void start(){
        int aantalVergoeding = 0, totaleVergoeding = 0, count = 0;
        int menuKeuze = askMenu();
        int vergoeding; double kilometers;

        while(menuKeuze!=-1){

            Auto auto = switch(menuKeuze){
                case 1 -> new Auto(false, askDouble(KILOMETERS_VRAAG), 1);
                case 2 -> new Auto(askDouble(KILOMETERS_VRAAG), askInt(VERGOEDINGS_VRAAG));
                case 3 -> new Auto(askInt(VERGOEDINGS_VRAAG));
                default -> null; // Dit moet hier staan want mijn compiler werkt anders niet
            };

            if (auto.heeftExtraVergoeding()) aantalVergoeding++;
            totaleVergoeding += auto.berekenTotaleVergoeding();
            count++;

            menuKeuze = askMenu();

        }
        if(count!=0){
        double gemVergoeding = totaleVergoeding*1.0/count;
        String correctWoord = count>1?"zijn %d auto\'s".formatted(count):"is 1 auto";
        System.out.printf("%n Er %s waar je recht hebt op extra vergoeding.%nGemiddelde totale vergoeding is %.2f", correctWoord, gemVergoeding);
        } else System.out.print("\nGeen auto\'s ingegeven!");
    }

    private int askMenu(){
        String vraag = "\nMenu\n1: niet elektrische auto\n2: elektrische auto met aantal kilometers en vergoeding\n3: elektrische auto met vergoeding\n-1: stoppen\n";
        int antwoord = askInt(vraag);
        while((antwoord<1||antwoord>3)&&antwoord!=-1){
            antwoord = askInt(vraag);
        } 
        return antwoord;
    }

    private int askInt(String string){
        System.out.printf(string);
        return sc.nextInt();
    }

    private double askDouble(String string){
        System.out.printf(string);
        return sc.nextDouble();
    }
}
