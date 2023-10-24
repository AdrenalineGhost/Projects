package domein;

public class Rekenmachine {
    private double resultaat;
    public double getResultaat() {
        return resultaat;
    }
    public void telOp(double getal1, double getal2){
        resultaat = getal1+getal2;
    }
    public void trekAf(double getal1, double getal2){
        resultaat = getal1-getal2;
    }
    public void deel(double getal1, double getal2){
        if(getal2 == 0){ resultaat=0;}
        else { resultaat = getal1*1.0/getal2; }
    }
    public void vermenigvuldig(double getal1, double getal2){
        resultaat = getal1*getal2;
    }
}
