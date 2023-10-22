package domein;

public class Pennenzak {
    private String kleur = null; private boolean open = false; private int lengte = 0;
    public Pennenzak(String kleur, int lengte){
        setKleur(kleur);setLengte(lengte);
    }

    public Pennenzak(int lengte){
        this("Blauw", lengte);
    }

    public Pennenzak(){
        this(10);
    }

    private final void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public String getKleur() {
        return kleur;
    }

    public final void setLengte(int lengte) {
        this.lengte = lengte;
    }

    public int getLengte() {
        return lengte;
    }

    public boolean isOpen() {
        return open;
    }

    public void maakOpen(){
        open = true;
    }

    public void maakDicht(){
        open = false;
    }

}
