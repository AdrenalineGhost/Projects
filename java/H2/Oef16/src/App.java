import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int in1, in2, in3, sum, avg, remainder, max;
            try{
                
                in1 = getGetal("Eerste", sc);
                in2 = getGetal("Tweede", sc);
                in3 = getGetal("Derde", sc);

                sum = in1 + in2 + in3;
                avg = (sum-sum%3)/3;
                remainder = sum%3;

                max = in1>in2?in1:in2;
                max = max>in3?max:in3;
                // max = Arrays.stream(new int[]{in1,in2,in3}).max().getAsInt();

                System.out.println(String.format("Van de ingevoerde getallen %d, %d en %d%nis de som %d", in1, in2, in3, sum));
                System.out.println("het gemiddelde " + avg);
                System.out.println("de rest is " + remainder);
                System.out.println("en het grootste getal " + max);
            }catch(Exception e){System.out.println("Wrong input!");}
        }
    }

    static int getGetal(String s, Scanner sc){
        System.out.println(String.format(
            "%s getal: ",
            s
        ));
        return sc.nextInt();
    }

}
