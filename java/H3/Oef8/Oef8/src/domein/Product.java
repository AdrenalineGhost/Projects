package domein;

public class Product {
    private static final int PRIJSEXCLBTW = 1;
    private static final int BTWPERCENTAGE = 21;
    private static final int KORTINGSTUKSPRECENTAGE = 0;
    private static final int MAXBTW = 21;
    private static final int MINBTW = 6;
    private static final int MAXKORTING = 50;
    private static final int MINKORTING = 0;
    private String naam;
    private double prijsExclBtw;
    private int btwPercentage;
    private int kortingStuksPercentage;
    public Product(String naam, double prijsExclBtw, int btwPercentage, int kortingStuksPercentage){
        setNaam(naam);
        setPrijsExclBtw(prijsExclBtw);
        setBtwPercentage(btwPercentage);
        setKortingStuksPercentage(kortingStuksPercentage);
    }


    public String getNaam() {
        return naam;
    }
    private void setNaam(String naam) {
        this.naam = naam;
    }
    public double getPrijsExclBtw() {
        return prijsExclBtw;
    }
    public void setPrijsExclBtw(double prijsExclBtw) {
        // this.prijsExclBtw = prijsExclBtw>0?prijsExclBtw:1;
        this.prijsExclBtw = prijsExclBtw>0?prijsExclBtw:PRIJSEXCLBTW;
    }
    public int getBtwPercentage() {
        return btwPercentage;
    }
    public void setBtwPercentage(int btwPercentage) {
        // this.btwPercentage = btwPercentage>=6&&btwPercentage<=21?btwPercentage:21;
        this.btwPercentage = btwPercentage>=MINBTW&&btwPercentage<=MAXBTW?btwPercentage:BTWPERCENTAGE;
    }
    public int getKortingStuksPercentage() {
        return kortingStuksPercentage;
    }
    public void setKortingStuksPercentage(int kortingStuksPercentage) {
        // this.kortingStuksPercentage = kortingStuksPercentage>0&&kortingStuksPercentage<=50?kortingStuksPercentage:0;
        this.kortingStuksPercentage = kortingStuksPercentage>MINKORTING&&kortingStuksPercentage<=MAXKORTING?kortingStuksPercentage:KORTINGSTUKSPRECENTAGE;
    }



    public double berekenPrijs(int aantal){
        if (aantal<0) return 0;
        boolean korting = aantal>=6;
        double hoeveelheidKoring = (korting?(100-getKortingStuksPercentage()):100);
        double btw = getPrijsExclBtw()*1.0*(getBtwPercentage()*1.0/100);
        return ( getPrijsExclBtw()*1.0 + btw) * aantal * hoeveelheidKoring/100;
    }

}
