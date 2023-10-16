import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
        // Build the dict
        Scanner sc = new Scanner(new File("src\\input"));
        String[] sl = new String[9];
        for(int i = 0; i < 9; i++){
            sl[i] = sc.nextLine();
        }
        sc.nextLine();
        Map<String,Stack<String>> map = new HashMap<>();
        for (int i = 1; i < sl[0].length(); i+=4) {
            for (int j = 7; j>=0;j--) {
                System.out.print(sl[j].charAt(i));
                // sl[8].charAt(i)+"" -> number associated with stack
                // sl[j] -> go through letters to form stack (back to front)
                map.putIfAbsent(sl[8].charAt(i)+"", new Stack<String>());
                String tmp = sl[j].charAt(i)+"";
                if(!tmp.isBlank()){
                    System.out.println(tmp);
                    map.get(sl[8].charAt(i)+"").push(tmp);
                }
            }
        }
        System.out.println();
        for (String string : map.keySet()) {
            System.out.println(string + " -> " + map.get(string));
        }
        // parse the instructions
        while(sc.hasNextLine()){
            String tempforprint = sc.nextLine();
            String[] templine = tempforprint.split(" ");
            // System.out.println(tempforprint);
            Stack<String> tempstack = new Stack<>();
            int amountofmoves = Integer.parseInt(templine[1]);
            for(int i = 0; i < amountofmoves; i++){
                // System.out.println(templine[5] + " " + templine[3]);
                // do the switch
                // map.get(templine[5]).push(map.get(templine[3]).pop());
                tempstack.push(map.get(templine[3]).pop());
            }
            for(int i = 0; i < amountofmoves; i++){
                map.get(templine[5]).push(tempstack.pop());
            }
        }
        for (String string : map.keySet()) {
            System.out.println(string + " -> " + map.get(string));
        }
        for (String string : map.keySet()) {
            System.out.print(map.get(string).peek());
        }
        sc.close();
    }
}
