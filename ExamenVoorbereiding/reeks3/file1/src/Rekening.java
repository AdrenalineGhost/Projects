public class Rekening {
    private double saldo = 0;
    public Rekening(double saldo){this.saldo = saldo;}
    public double getSaldo() {return saldo;}
    public void stort(double bedrag){saldo += bedrag;}
    public void haalAf(double bedrag){saldo -= bedrag;}
    public void schrijfOverNaar(Rekening R, double bedrag){haalAf(bedrag);R.stort(bedrag);}
    @Override
    public String toString() {return String.format("$ %.2f", saldo);}
}
