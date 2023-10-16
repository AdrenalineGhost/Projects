import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int in;
        int count = 0;
        try(Scanner sc = new Scanner(System.in)){
            do{
                in = ask(sc, "Geef een strikt positief getal: ");
            } while(!(in>0));
        }

        while(in != 1){
            count++;
            if(in%2==0){
                in/=2;
            } else{in=in*3+1;}
        }
        System.out.println(count);
    }
    static int ask(Scanner sc, String question){
        System.out.print(question);
        return sc.nextInt();
    }
}
