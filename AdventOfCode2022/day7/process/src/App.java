import java.io.File;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collector;

import Files.Dir;
// Find all of the directories with a total size of at most 100000. What is the sum of the total sizes of those directories?
public class App {
    public static void main(String[] args) throws Exception {
        // mke the full dir
        try(Scanner sc = new Scanner(new File("input"))){
            sc.nextLine();
            Stack<Files.Dir> history = new Stack<>();
            history.add(new Dir("root"));
            while(sc.hasNextLine()){
                String[] string = sc.nextLine().split(" ");
                // Check for cd and put at top of stack
                // TODO: add another check for / 
                if( string[0].equals("$") && string[1].equals("cd") && !"..".equals(string[2])){
                    history.add(
                        history.peek().findDir(string[2])
                    );
                } else if(string[2] != null && string[2].equals("..")){
                    history.pop();
                } else {
                    if(string[0].equals("$")){continue;}
                    try {
                        int size = Integer.parseInt(string[0]);
                        history.peek().addChild(new Files.File(string[1], size));
                    } catch (Exception e) {
                        history.peek().addChild(new Dir(string[1]));
                    }
                }
                
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        // Do the excersize

    }
}
