import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        // Persoon vader = new Persoon("mostafa, elkhallouki");
        // Persoon dochter = new Persoon("safa, elkhallouki");
        // Persoon zoon = new Persoon("iyaas, elkhallouki");
        // vader.zetOpRekening(5000, true); vader.zetOpRekening(1000, false);
        // System.out.println(vader.toString()); 
        // System.out.println(zoon.toString()); 
        // System.out.println(dochter.toString());
        // vader.geefZakgeldAan(zoon, 70);
        // vader.geefZakgeldAan(dochter, 5.5);
        // vader.geefSpaarcentAan(zoon, 30);
        // vader.geefSpaarcentAan(dochter, 30);
        // vader.versluisNaarSpaar(vader.getSaldoZicht()-600);
        // System.out.println(vader.toString()); 
        // System.out.println(zoon.toString()); 
        // System.out.println(dochter.toString());

        ArrayList<String[]> s = new ArrayList<>();
        ArrayList<Persoon> p = new ArrayList<>();
        Scanner sc = new Scanner(new File("C:\\Users\\Marwa\\GIT\\Projects\\ExamenVoorbereiding\\reeks3\\file\\src\\personenMetGeld.csv"));
        while (sc.hasNextLine()) {
            s.add(sc.nextLine().split(";"));
        }
        s.forEach(x -> p.add(
            new Persoon(x[0])
                .zetOpRekening(Double.parseDouble(x[1]), false)
                .zetOpRekening(Double.parseDouble(x[2]), true)
        ));
        p.forEach(System.out::println);
    }
}
