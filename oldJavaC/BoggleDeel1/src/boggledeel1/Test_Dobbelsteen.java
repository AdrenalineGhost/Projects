package boggledeel1;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author tiwi
 */
public class Test_Dobbelsteen extends Testklasse {
    
    public static void main(String[] args){
        Dobbelsteen dobbelsteen = new Dobbelsteen("AAAAAA");   
        
        controleerTrue("getWaarde() is een char?",dobbelsteen.getWaarde()=='A');
        
        dobbelsteen = new Dobbelsteen("EAVKIM");
        Set<Character> verz = new HashSet<>();
        for(int i=0; i<100; i++){
            dobbelsteen.dobbel();
            verz.add(dobbelsteen.getWaarde());
        }        
        controleerEquals("dobbel je juist?",6,verz.size());
        controleerTrue("komen alle letters voor?",verz.contains('E'));
        controleerTrue("komen alle letters voor?",verz.contains('A'));
        controleerTrue("komen alle letters voor?",verz.contains('V'));
        controleerTrue("komen alle letters voor?",verz.contains('K'));
        controleerTrue("komen alle letters voor?",verz.contains('I'));
        controleerTrue("komen alle letters voor?",verz.contains('M'));
    }
}
