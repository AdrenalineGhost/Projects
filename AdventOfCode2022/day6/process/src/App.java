import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(new File("input"));
            String string = sc.nextLine();
            System.out.println(string.length());
            LinkedList<Character> ll = new LinkedList<>();
            int count = 1;
            int distinctcount = 14;
            for (char c : string.toCharArray()) {
                System.out.println(ll + " -> " + c + "\t" + count);
                if(ll.size() < distinctcount-1){ ll.add(c); }
                else if(ll.stream().distinct().count() == distinctcount-1 && !ll.contains((Character)c)) break;
                else { ll.add((Character)c); ll.removeFirst(); }
                // if(count > 50) break;
                count++;
            }
            System.out.println(count);
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
