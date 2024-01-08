package domein;

public class Auto {
    private boolean electrisch;
    private double aantalKilometers;
    private int vergoeding;

    
    public static final double MAX_KILOMETERS = 1000;
    public static final double DEFAULT_KILOMETERS = 400.5;
    public static final int MAX_VERGOEDING = 5;
    public static final int DEFAULT_VERGOEDING = 2;
    public static final boolean DEFAULT_ELEKTRISCH = true;

    public Auto(boolean electrisch, double aantalKilometers, int vergoeding){
        setElectrisch(electrisch);
        setAantalKilometers(aantalKilometers);
        setVergoeding(vergoeding);
    }
    public Auto(double aantalKilometers, int vergoeding){ 
        this(DEFAULT_ELEKTRISCH,aantalKilometers,vergoeding);
    }
    public Auto(int vergoeding){ 
        this(DEFAULT_KILOMETERS, vergoeding);
    }

    public boolean heeftExtraVergoeding(){
        return isElektrisch()&&getAantalKilometers()<=DEFAULT_KILOMETERS;
    }

    public double berekenTotaleVergoeding(){
        int rechtOpVergoeding = heeftExtraVergoeding()?2:1;
        return (MAX_KILOMETERS-getAantalKilometers())*vergoeding*rechtOpVergoeding;
    }

    public boolean isElektrisch() {
        return electrisch;
    }
    private void setElectrisch(boolean electrisch) {
        this.electrisch = electrisch;
    }
    public double getAantalKilometers() {
        return aantalKilometers;
    }
    public void setAantalKilometers(double aantalKilometers) {
        this.aantalKilometers = aantalKilometers>=0&&aantalKilometers<=MAX_KILOMETERS?aantalKilometers:DEFAULT_KILOMETERS;
    }
    public int getVergoeding() {
        return vergoeding;
    }
    public void setVergoeding(int vergoeding) {
        this.vergoeding = vergoeding>0&&vergoeding<=MAX_VERGOEDING?vergoeding:DEFAULT_VERGOEDING;
    }



}
