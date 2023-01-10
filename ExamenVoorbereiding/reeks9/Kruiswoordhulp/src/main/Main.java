package main;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        // AAN TE VULLEN: als het bestand niet gevonden wordt, dan vang je de fout HIER op.
        
        Puzzelhulp scrabble = new Puzzelhulp("puzzelwoorden.txt");
        System.out.println("met lengte 4: " + scrabble.aantalWoordenMetLengte(4));
        System.out.println("met lengte 5: " + scrabble.aantalWoordenMetLengte(5));
        System.out.println("met lengte 6: " + scrabble.aantalWoordenMetLengte(6));
        System.out.println("met lengte 7: " + scrabble.aantalWoordenMetLengte(7));

        System.out.println(scrabble.woordenMetLengte(4));

        System.out.println(scrabble.woordenMetMeerKlinkersDanMedeklinkers());

        System.out.print("\nWoorden met a, b en c in: ");
        scrabble.schrijfWoordenMetLetters('a', 'b', 'c');
        System.out.print("\nWoorden met x en y in: ");
        scrabble.schrijfWoordenMetLetters('x', 'y');

        System.out.println("\n");
        for (int i = 2; i < 9; i++) {
            System.out.println("Alfabetisch eerste voor lengte " + i + ": " + scrabble.alfabetischEerste(i));
        }
        System.out.println();
        for (int i = 2; i < 9; i++) {
            System.out.println("Alfabetisch laatste voor lengte " + i + ": " + scrabble.alfabetischLaatste(i));
        }

    }
}
