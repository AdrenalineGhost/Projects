package domein;

public class Wapen extends Voorwerp {
    private int kracht;
    private boolean gebruikt;
    private static final int MAX_NIVEAU =5;

    public Wapen(String naam, double gewicht, int niveau, int deur){
        super(naam, gewicht, niveau);
    }

    public int getKracht() {
        return this.kracht;
    }

    public void setKracht(int kracht) {
        this.kracht = kracht;
    }

    public boolean isGebruikt() {
        return this.gebruikt;
    }

    public void setGebruikt(boolean gebruikt) {
        this.gebruikt = gebruikt;
    }


    @Override
    public String toString() {
        return "{" +
            " kracht='" + getKracht() + "'" +
            ", gebruikt='" + isGebruikt() + "'" +
            "}";
    }



}
