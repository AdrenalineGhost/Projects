package domein;

public class Sleutel extends Voorwerp {
    private int deur;
    private int aantalInOmloop;


    public Sleutel(String naam, double gewicht, int niveau, int deur) {
        super(naam, gewicht, niveau);
        setDeur(deur);
    }

    public int getDeur() {
        return this.deur;
    }

    public void setDeur(int deur) {
        this.deur = deur;
    }

    public int getAantalInOmloop() {
        return this.aantalInOmloop;
    }

    public void setAantalInOmloop(int aantalInOmloop) {
        this.aantalInOmloop = aantalInOmloop;
    }


}
