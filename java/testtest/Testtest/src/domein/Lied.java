package domein;

public class Lied {
    private double duurInMinuten;
    private int beatsPerMinute;

    public final static double DEFAULT_DUUR = 4;
    public final static int DEFAULT_BPM = 100;

    public Lied(double duurInMinuten, int beatsPerMinute){
        setDuurInMinuten(duurInMinuten);
        setBeatsPerMinute(beatsPerMinute);
    }

    public Lied(double duurInMinuten){
        this(duurInMinuten, DEFAULT_BPM);
    }

    public void setBeatsPerMinute(int beatsPerMinute) {
        this.beatsPerMinute = (beatsPerMinute>=10&&beatsPerMinute<=200)?beatsPerMinute:DEFAULT_BPM;
    }

    private void setDuurInMinuten(double duurInMinuten) {
        this.duurInMinuten = duurInMinuten>=0.5&&duurInMinuten<=10?duurInMinuten:DEFAULT_DUUR;
    }

    public double getDuurInMinuten() {
        return duurInMinuten;
    }

    public int getBeatsPerMinute() {
        return beatsPerMinute;
    }

    public int geefDuurInSeconden(){
        return (int)getDuurInMinuten()/60;
    }

    public String geefTempo(){

        if(beatsPerMinute>=10&&beatsPerMinute<=70) return "traag";
        if(beatsPerMinute>70&&beatsPerMinute<=90) return "relax";
        if(beatsPerMinute>90&&beatsPerMinute<=120) return "fris";
        if(beatsPerMinute>120&&beatsPerMinute<=180) return "levendig";
        if(beatsPerMinute>180) return "snel";
        return "";

    }

}
