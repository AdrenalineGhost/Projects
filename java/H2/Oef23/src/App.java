import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int deler = getInput(sc, in->in>0,"Geef een deler");
            long hoeveel = getInputArray(sc, x->x==-1, "Geef een getal")
                                .stream()
                                .map(x->{return x%deler==0;})
                                .filter(x -> x)
                                .count();
            System.out.println(hoeveel);
        }
    }

    static int getInput(Scanner sc, IntPredicate pre, String question){
        Integer in;
        do{
            in = ask(sc, question);
        } while(!pre.test(in));
        return in;
    }

    static List<Integer> getInputArray(Scanner sc, IntPredicate pre, String question){
        List<Integer> in = new ArrayList<>();
        Integer tempIn = ask(sc, question);
        while(!pre.test(tempIn)){
            in.add(tempIn);
            tempIn = ask(sc, question);
        }
        return in;
    }

    static int ask(Scanner sc, String question){
        System.out.print(String.format("%s: ", question));
        return sc.nextInt();
    }

}
