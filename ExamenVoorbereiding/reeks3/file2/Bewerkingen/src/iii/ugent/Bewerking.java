package iii.ugent;

public class Bewerking {
    private String string;
    private double calc;

    public Bewerking(String s){
        s = s.strip();
        int index = 0; String s1; String s2; String op;
        for (int i = 0; i < s.length(); i++) {if (!Character.isDigit(s.charAt(i))&&s.charAt(i)!=' '&&i!=0) {index = i;break;}}
        s1 =   s.substring(0, index).trim()  ;
        op =   Character.toString(s.charAt(index)).trim()  ;
        s2 =   s.substring(index+1).trim()  ;
        init(s1, op, s2);
    }

    public Bewerking(String s1 , String op , String s2){
        init(s1, op, s2);
    }
    
    void init(String s1 , String op , String s2){
        switch (op.trim()) {
            case "+":
                this.calc = Double.parseDouble(s1) + Double.parseDouble(s2);
                break;
            case "-":
                this.calc = Double.parseDouble(s1) - Double.parseDouble(s2);
                break;
            case "*":
                this.calc = Double.parseDouble(s1) * Double.parseDouble(s2);
                break;
            case "/":
                this.calc = Double.parseDouble(s1) / Double.parseDouble(s2);
                break;
            default:
                this.calc = 0;
                break;
        }
        this.string = String.format("%s %s %s = ",s1.strip(),op.strip(),s2.strip()).replaceAll("\"", "");
    }

    public double oplossing(){return calc;}
    @Override
    public String toString() {return string;}
    public String toStringMetOplossing(){return this.toString().concat(Integer.toString((int)calc));} 
}
