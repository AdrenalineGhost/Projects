import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> c = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            c.add(Integer.toString(i));
        }
        Collect<String> s = new Collect<>(c);
        s.print();
        String[] t = {"hello", "there"};

        s.imput(t);
        s.print();
    }
}
