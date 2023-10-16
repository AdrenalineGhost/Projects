public class Oef8 {
    public static void main(String[] args) {
        for (int i = 'a'; i <= 'z'; i++) {
            System.out.println(String.format("De ASCII-code van de letter %c is %d",(char)i,i));
            System.out.println(String.format("De ASCII-code van de hoofdletter %c is %d",(char)(i-'a'+'A'),(i-'a'+'A')));
            System.out.println("Het verschil is " + ('a'-'A'));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("De ASCII-code van het cijfer %d is %d", i , '0'+i));
        }
        System.out.println("Alle ASCII-tekens :");
        for (int i = 0; i < 128; i++) {
            System.out.println(String.format("%d...%c***",i,(char)i));
        }
    }
}
