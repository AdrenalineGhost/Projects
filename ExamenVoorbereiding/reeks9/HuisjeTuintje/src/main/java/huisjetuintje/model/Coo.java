package huisjetuintje.model;

public class Coo {
    public double x;
    public double y;

    public Coo(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void verschuif(Coo delta){
        x += delta.x;
        y += delta.y;
    }
}
