package huisjetuintje.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

public class Veelhoek implements Tekenbaar, Verschuifbaar {
    private List<Coo> coordinaten;

    public Veelhoek(Coo... coo){
        coordinaten = Arrays.asList(coo);
    }

    public void teken(Color kleur, GraphicsContext context){
        int aantalHoekptn = coordinaten.size();
        context.setStroke(kleur);
        for(int i=0; i<aantalHoekptn-1; i++){
            tekenLijn(context,coordinaten.get(i),coordinaten.get(i+1));
        }
        tekenLijn(context,coordinaten.get(aantalHoekptn-1),coordinaten.get(0));
    }

    private void tekenLijn(GraphicsContext context,Coo start, Coo stop){
        Pixels a = new Pixels(start);
        Pixels b = new Pixels(stop);
        context.strokeLine(a.kolom, a.rij, b.kolom, b.rij);
    }

    public void verschuif(Coo delta){
        for(Coo coo : coordinaten){
            coo.verschuif(delta);
        }
    }
}
