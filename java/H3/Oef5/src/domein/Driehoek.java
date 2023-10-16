package domein;
public class Driehoek {
    private int a,b,c;
    /**
     * @param a
     * @param b
     * @param c
     */
    public Driehoek(int a, int b, int c){
        this.a=a;this.b=b;this.c=c;
    }
    private void setA(int a){this.a=a;}
    private void setB(int b){this.b=b;}
    private void setC(int c){this.c=c;}
    public int getA(){return a;}
    public int getB(){return b;}
    public int getC(){return c;}

    public boolean isRechthoekig(){
        return (a*a+b*b==c*c||a*a+c*c==b*b||b*b+c*c==a*a);
    }
}
