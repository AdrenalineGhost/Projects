package main;

import java.io.File;
import java.util.*;

import javax.xml.transform.Templates;


public class Puzzelhulp {

    private List<String> woorden = new ArrayList<>();

    int countletters(String x, char...letters){
        int temp = 0;
        for (char c : letters) {
            temp += x.chars().filter(z -> z == c).count();
        } return temp;
    }

    public Puzzelhulp(String bestandsnaamWoordenlijst) {
        try {
            Scanner sc = new Scanner(new File(bestandsnaamWoordenlijst));
            while (sc.hasNextLine()) {
                woorden.add(sc.nextLine());
            } sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int aantalWoordenMetLengte(int lengte) {
        return (int)(woorden.stream().distinct().filter(x -> x.length() == lengte).count());
    }

    public List<String> woordenMetLengte(int lengte) {
        return woorden.stream().distinct().filter(x -> x.length() == lengte).toList();
    }

    public List<String> woordenMetMeerKlinkersDanMedeklinkers() {
        return woorden.stream()
            .distinct()
            .filter(
                x -> countletters(x, 'a','e','u','i','o','y','A','E','U','I','O','Y') > x.length() - countletters(x, 'a','e','u','i','o','y','A','E','U','I','O','Y')
            )
            .sorted()
            .toList();
    }


    public void schrijfWoordenMetLetters(char... letters) {
        woorden.stream()
        .map(x->x.toLowerCase())
        .filter(
            x -> {
                for (char c : letters) {
                    if (!x.contains(Character.toString(c))) return false;
                }return true;
            }
        ).distinct()
        .sorted()
        .forEach(x -> System.out.print(x + " - "));
    }

    public String alfabetischEerste(int lengte) {
        return woorden.stream()
        .filter(x -> x.length() == lengte)
        .reduce("-".repeat(lengte+1), (x , y) -> x = x.length()>y.length()||x.compareToIgnoreCase(y)>0?y:x);
    }

    public String alfabetischLaatste(int lengte) {
        return woorden.stream()
        .filter(x -> x.length() == lengte)
        .reduce("-".repeat(lengte), (x , y) -> x = x.compareToIgnoreCase(y)<0?y:x);
    }

    // This is a test for GIT
}

