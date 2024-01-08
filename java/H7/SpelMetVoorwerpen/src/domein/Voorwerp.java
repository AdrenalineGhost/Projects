package domein;

public class Voorwerp {
    private final String naam;
    private double gewicht;
    private int niveau;
    private static final int MAX_NIVEAU = 10;
    private static final int MAX_GEWICHT = 1000;
    private static final int MIN_NIVEAU = 0;
    private static final int MIN_GEWICHT = 1;
    private static final int DEFAULT_NIVEAU = 1;


    public Voorwerp(String naam, double gewicht, int niveau){
        this.naam = naam;
        setGewicht(gewicht);
        setNiveau(niveau);
    }

    public Voorwerp(String naam, double gewicht){
        this(naam, gewicht, DEFAULT_NIVEAU);
    }

    private void controleerNaam(String naam){

    }

    @Override
    public String toString() {
        return "Voorwerp %s met gewicht %.3f kg uit niveau %d".formatted(getNaam(), getGewicht(), getNiveau());
    }

    public String getNaam() {
        return this.naam;
    }

    public double getGewicht() {
        return this.gewicht;
    }

    private void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public int getNiveau() {
        return this.niveau;
    }

    private void setNiveau(int niveau) {
        this.niveau = niveau;
    }

}
