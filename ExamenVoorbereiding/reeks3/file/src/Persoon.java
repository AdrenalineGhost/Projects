public class Persoon {
    private String naam = "";
    private String voornaam ="";
    private Rekening zichtRekening = new Rekening(0);
    private Rekening spaarRekening = new Rekening(0);
    public Persoon(String s){
        this.voornaam = s.split(",")[0].trim();
        this.naam = s.split(",")[1].trim();
    }
    double getSaldoZicht(){return zichtRekening.getSaldo();}
    double getVermogen(){return zichtRekening.getSaldo() + spaarRekening.getSaldo();}
    void versluisNaarSpaar(double bedrag){zichtRekening.schrijfOverNaar(spaarRekening, bedrag<0?0:bedrag);}
    void zetOpRekening(double bedrag, Boolean s){if(!s){zichtRekening.stort(bedrag);}else{spaarRekening.stort(bedrag);}}
    void geefZakgeldAan(Persoon P, double bedrag){zichtRekening.schrijfOverNaar(P.zichtRekening, bedrag);}
    void geefSpaarcentAan(Persoon P, double bedrag){zichtRekening.schrijfOverNaar(P.spaarRekening, bedrag);}
    @Override
    public String toString() {return String.format("%s %s (zicht %s, spaar %s)", naam, voornaam, zichtRekening.toString(), spaarRekening.toString());}
}
