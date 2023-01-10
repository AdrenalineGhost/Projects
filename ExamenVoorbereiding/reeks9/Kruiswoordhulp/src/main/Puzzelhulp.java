package main;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class Puzzelhulp {

    private List<String> woorden;

    int countletters(String x, char...letters){
        int temp = 0;
        for (char c : letters) {
            temp += x.chars().filter(z -> z == c).count();
        } return temp;
    }

    public Puzzelhulp(String bestandsnaamWoordenlijst) {

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
                x -> countletters(x, 'a','e','u','i','o','y') > x.length() - countletters(x, 'a','e','u','i','o','y')
            )
            .sorted()
            .toList();
    }


    public void schrijfWoordenMetLetters(char... letters) {
        woorden.stream().filter(x -> x.contains(letters.toString())).sorted().forEach(System.out::print);;
    }

    public String alfabetischEerste(int lengte) {
        return "-";
    }

    public String alfabetischLaatste(int lengte) {
        return "-";
    }


}

