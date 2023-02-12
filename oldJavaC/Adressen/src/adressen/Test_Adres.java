package adressen;

/**
 *
 * @author tiwi
 */
public class Test_Adres extends Testklasse{

    public static void main(String[] args) {
             
        Adres adres = new Adres(9860,"Scheldewindeke","Stationstraat",55);
        controleerEquals("gemeente juist?","Scheldewindeke",adres.getGemeente());
        controleerEquals("straat juist?","Stationstraat",adres.getStraat());
        controleerEquals("postcode (int!) juist?",9860,adres.getPostcode());
        controleerEquals("toString juist?","Stationstraat 55\n9860 Scheldewindeke",adres.toString().trim());
        
        adres = new Adres(9860,"Scheldewindeke","Stationstraat",55,"C");
        controleerEquals("gemeente juist?","Scheldewindeke",adres.getGemeente());
        controleerEquals("straat juist?","Stationstraat",adres.getStraat());
        controleerEquals("postcode (int!) juist?",9860,adres.getPostcode());
        controleerEquals("toString juist?","Stationstraat 55 bus C\n9860 Scheldewindeke",adres.toString().trim());
        
    }
    
}
