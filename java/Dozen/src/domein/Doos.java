package domein;

public class Doos {
    private static final String DEFAULT_KLEUR = "ROOD";
    private static final double DEFAULT_RIBBE = 1.0;
    private static int aantalDozenGemaakt;
    private double lengte;
    private double breedte;
    private double hoogte;
    private String code;
    private String kleur;


    // Constructor
    public Doos(double lengte, double breedte, double hoogte, String kleur) { 
        setLengte(lengte);
        setBreedte(breedte);
        setHoogte(hoogte);
        setKleur(kleur);
        aantalDozenGemaakt++;
    }

    // Overloaded Constructors
    public Doos(double lengte, double breedte, double hoogte) { this(lengte, breedte, hoogte, DEFAULT_KLEUR); }
    public Doos(String kleur) { this(DEFAULT_RIBBE,DEFAULT_RIBBE,DEFAULT_RIBBE,kleur); }
    public Doos() { this(DEFAULT_RIBBE,DEFAULT_RIBBE,DEFAULT_RIBBE,DEFAULT_KLEUR); }
    
    // Getters and Setters
    public static int getAantalDozenGemaakt() {
        return aantalDozenGemaakt;
    }
    private static void setAantalDozenGemaakt(int aantalDozenGemaakt) {
        Doos.aantalDozenGemaakt = aantalDozenGemaakt;
    }
    public double getLengte() {
        return lengte;
    }
    private void setLengte(double lengte) {
        this.lengte = lengte;
    }
    public double getBreedte() {
        return breedte;
    }
    private void setBreedte(double breedte) {
        this.breedte = breedte;
    }
    public double getHoogte() {
        return hoogte;
    }
    private void setHoogte(double hoogte) {
        this.hoogte = hoogte;
    }
    public String getCode() {
        return code;
    }
    private void stelCodeIn() {
        this.code = code;
    }
    public String getKleur() {
        return kleur;
    }
    private void setKleur(String kleur) {
        this.kleur = kleur;
    }

    // Methods
    private void controleerAfmeting(String afmeting, double minWaarde, double waarde){
        
    }

}
