package huisjetuintje.model;

import javafx.scene.canvas.Canvas;

public class Pixels {
    public int kolom;
    public int rij;

    public static double factorX;
    public static double factorY;
    public static int aantalPixelsInHoogte;

    public static void stelInOpCanvas(Canvas canvas, Coo rechtsboven) {
        factorX = canvas.getWidth() / rechtsboven.x;
        factorY = canvas.getHeight() / rechtsboven.y;
        aantalPixelsInHoogte = (int) canvas.getHeight();
    }

    public Pixels(int kolom, int rij) {
        this.kolom = kolom;
        this.rij = rij;
    }

    public Pixels(Coo coo) {
        kolom = (int) (factorX * coo.x);
        rij = (int) (factorY * coo.y);
        rij = aantalPixelsInHoogte - rij;
    }

    public static int breedteInPixels(double afm){
        return (int) (factorX * afm);
    }
    public static int hoogteInPixels(double afm){
        return (int) (factorY * afm);
    }

}
