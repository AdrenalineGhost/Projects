package adressen;
public class Adres {
    private int postcode; private String gemeente; private String straat; private int huisNummer; private String bus;
    public Adres(int postcode, String gemeente, String straat, int huisNummer, String bus){
        this.postcode = postcode; this.gemeente = gemeente; this.straat = straat; this.huisNummer = huisNummer; this.bus = bus;
    }
    public Adres(int postcode, String gemeente, String straat, int huisNummer){
        this(postcode, gemeente, straat, huisNummer, "");
    }
    public String getStraat() {
        return straat;
    }
    public String getGemeente() {
        return gemeente;
    }
    public int getPostcode() {
        return postcode;
    }
    public String toString() {
        if (bus != "") {
            return String.format("%s %d bus %s\n%d %s", straat,huisNummer,bus,postcode,gemeente);
        }
        return String.format("%s %d %s\n%d %s", straat,huisNummer,bus,postcode,gemeente);
    }

}
