import java.util.Random;

public class Oef7 {
    public static void main(String[] args) {
        Random rand = new Random();
        int thrown = dobbel(rand);
        int max = dobbel(rand);
        int min = dobbel(rand);
        int tries = 1;
        if (max < min){
            int temp = max;
            max = min;
            min = temp;
        }
        System.out.println(String.format("Onder- en bovengrens zijn %d en %d", min, max));
        while(thrown < min || thrown > max){
            tries++;
            thrown = dobbel(rand);
            System.out.println("\t(ik gooide " +thrown+ ")");
        }
        System.out.println("\t(ik gooide " +thrown+ ")");
        System.out.println(String.format("Er was/waren %d poging nodig om binnen de grenzen %d en %d te mikken.", tries, min, max));
    }
    static int dobbel(Random rand){
        return rand.nextInt(6)+1;
    }
}
