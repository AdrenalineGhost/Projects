package huisjetuintje.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ovaal implements Tekenbaar, Verschuifbaar {

    private Coo center;
    private double breedte;
    private double hoogte;

    public Ovaal(Coo center, double breedte, double hoogte){
        this.center = center;
        this.breedte = breedte;
        this.hoogte = hoogte;
    }

    public void teken(Color kleur, GraphicsContext context){
        context.setStroke(kleur);
        Pixels pix = new Pixels(center);
        double breedteInPix = Pixels.breedteInPixels(breedte);
        double hoogteInPix = Pixels.hoogteInPixels(hoogte);
        context.strokeOval(pix.kolom-breedteInPix/2,pix.rij-hoogteInPix/2,breedteInPix,hoogteInPix);
    }
    public void verschuif(Coo delta){
        center.x += delta.x;
        center.y += delta.y;
    }

}
