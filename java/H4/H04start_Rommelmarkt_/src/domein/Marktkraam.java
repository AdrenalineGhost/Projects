package domein;

public class Marktkraam {
    // variables
    private String kraamhouder;
    private int breedte;
    private double inkomsten;

    private final static int MIN_BREEDTE = 2;
    private final static int MAX_BREEDTE = 10;
    private final static int DEFAULT_BREEDTE = 10;

    // constuctor
    public Marktkraam(String kraamhouder, int breedte){
        setKraamhouder(kraamhouder);
        setBreedte(breedte);
    }
    // overloaded constuctor
    public Marktkraam(String kraamhouder){
        this(kraamhouder, 0);
    }
    // getters and setters
    public String getKraamhouder() {
        return kraamhouder;
    }
    public int getBreedte() {
        return breedte;
    }
    private void setKraamhouder(String kraamhouder) {
        if(
            kraamhouder == null ||
            kraamhouder.isBlank()
        ) this.kraamhouder = "anoniem";
        else this.kraamhouder = kraamhouder;
    }
    private void setBreedte(int breedte) {
        if(
            breedte < MIN_BREEDTE||
            breedte > MAX_BREEDTE
        ) this.breedte = DEFAULT_BREEDTE;
        else this.breedte = breedte;
    }
// class methods
    public void ontvang(double bedrag){
        inkomsten += bedrag>0?bedrag:0;
    }
    
    public double geefWinst(){
        double rate = 5>=breedte?3.0:2.5;
        return inkomsten - rate * breedte;
    }

}
