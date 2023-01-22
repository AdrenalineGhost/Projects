package adressen;

import java.io.FileNotFoundException;

/**
 *
 * @author tiwi
 */
public class Test_AdressenDAO extends Testklasse{

    public static void main(String[] args) throws FileNotFoundException {
        AdressenDAO dao = new AdressenDAO("adressen.csv");
        Adres[] selectieAdressen = dao.getAdressenMetStraat("Asselkouter");   
        
        controleerEquals("aantal gevonden adressen?",3,selectieAdressen.length);
        controleerEquals("eerste adres?","Asselkouter 167\n9820 Merelbeke",selectieAdressen[0].toString().trim());
        controleerEquals("tweede adres?","Asselkouter 113\n9820 Munte",selectieAdressen[1].toString().trim());
        controleerEquals("derde adres?","Asselkouter 113\n9820 Merelbeke",selectieAdressen[2].toString().trim());
    }
    
}
