import java.util.Arrays;

public class Oef10 {
    public static void main(String[] args) {
        int aantal = 27;
        boolean hoofdletter = true;

        System.out.println("aantal is " + aantal);
        char currChar = ' ';
        int correctie = hoofdletter?32:0;

        for (int i = 1; i < aantal+1; i++) {
            currChar = i%2==1?'*':(char)('a'-correctie);
            for (int j = 0; j < i; j++) {
                System.out.print(currChar);
            }
            System.out.println();
        }

        System.out.println("\n*");
        for (int i = 2; i <= aantal; i++) {
            currChar = aantal==i?'!':(char)('a'+i-2-correctie);
            for (int j = 0; j < i; j++) {
                System.out.print(currChar);
            }
            System.out.println();
        }
    }
}
