import java.util.Scanner;

public class App {
    public static void main(String[] args) { }

    private static Scanner sc = new Scanner(System.in);

    private void start(){
        
    }

    private int askAfspeellijsten(){
        int invoer;
        do{
            invoer = askInt("\nHoeveel afspeellijsten: ");
        }while(invoer<1&invoer>5);
        return invoer;
    }

    private int askInt(String question){
        System.out.printf(question);
        return sc.nextInt();
    }

}
