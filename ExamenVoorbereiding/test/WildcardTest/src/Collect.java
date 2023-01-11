import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Collect<T> {
    private List<T> x = new ArrayList<>();
    public Collect(Collection<T> c){
        c.stream().forEach(System.out::println);
        c.stream().forEach(j->x.add(j));
    }

    public void print(){
        for (T t : x) {
            System.out.println(t);
        }
    }

    public void imput(T[] a) {
        for (T t : a) {
            x.add(t);
        }
    }
}
