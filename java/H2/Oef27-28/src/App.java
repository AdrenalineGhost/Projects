import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int in1 = 0, in2 = 0, in3 = 0, in4 = 0;
        try(Scanner sc = new Scanner(System.in)){
            int count = 0;
            int in;
            do{
                in = geefAntwoord(sc, ++count);
                switch(in){
                    case 1 -> in1++;
                    case 2 -> in2++;
                    case 3 -> in3++;
                    case 4 -> in4++;
                }

            }while(in!=0); count--;
        }
        System.out.printf("1 = %d%n2 = %d%n3 = %d%n4 = %d", in1,in2,in3,in4);
    }

    static int geefAntwoord( Scanner sc, int hoeveel){
        
        int in = ask(sc, String.format("Geef antwoord %d in: ", hoeveel));
        while(in<0||in>4){
            in = ask(sc, String.format( "Incorrect antwoord!%nGeef antwoord %d in: ", hoeveel));
        }

        return in;
    }


    static int ask(Scanner sc, String vraag){

        System.out.print(vraag);
        return sc.nextInt();


    }

}
