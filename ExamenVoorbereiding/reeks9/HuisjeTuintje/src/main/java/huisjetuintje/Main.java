
package huisjetuintje;


import java.util.stream.Stream;

import huisjetuintje.model.Coo;
import huisjetuintje.model.Ovaal;
import huisjetuintje.model.Veelhoek;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import huisjetuintje.model.Pixels;


public class Main extends Application {

    // declaratie en initialisatie van alle punten op de wiskundige schets
    // (zie opgave, linkertekening)
    private Coo a = new Coo(7,2);
    private Coo b = new Coo(8,2);
    private Coo extra = new Coo(8,2);
    private Coo c = new Coo(8,8);
    private Coo d = new Coo(7,8);
    private Coo e = new Coo(12,2);
    private Coo f = new Coo(12,5);
    private Coo g = new Coo(13,5);
    private Coo h = new Coo(13,2);

    private Coo x = new Coo(9,5);
    private Coo y = new Coo(11,5);
    private Coo z = new Coo(9,4);
    private Coo u = new Coo(11,4);

    private Coo k = new Coo(8,7);
    private Coo l = new Coo(11,10);
    private Coo m = new Coo(14,7);

    private Coo v = new Coo(14,2);

    private Coo p = new Coo(12,9);
    private Coo q = new Coo(13,8);
    private Coo r = new Coo(13,10);
    private Coo s = new Coo(12,10);

    private Coo center = new Coo(7.5,11);


    // declaratie van alle onderdelen van de tekening
    // (onderdelen van het huis en van de boom)
    private Veelhoek gevel = new Veelhoek(extra,v,m,k);
    private Veelhoek raam = new Veelhoek(x,y,u,z);
    private Veelhoek deur = new Veelhoek(e,f,g,h);
    private Veelhoek dak = new Veelhoek(k,l,m);
    private Veelhoek schouw = new Veelhoek(p,q,r,s);
    private Veelhoek stam = new Veelhoek(a,b,c,d);
    private Ovaal kruin = new Ovaal(center,4.2,6.2);

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("huisje tuintje");

        Group group = new Group();

        Canvas canvas = new Canvas(1000,750);
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setLineWidth(4);

        // Op het canvas (1000 pixels breed, 750 pixels hoog) zal getekend worden;
        // de gebruiker heeft z'n schets gemaakt op een kladblad
        // met Cartesiaans assenstelsel: de oorsprong ligt linksonder,
        // de rechterbovenhoek heeft coördinaten (20,15).
        Pixels.stelInOpCanvas(canvas,new Coo(20,15));

        // stam en kruin worden verschoven (2 eenheden naar links, 1 eenheid naar onder)
        // vul aan
        stam.verschuif(new Coo(-1, 0));
        kruin.verschuif(new Coo(-1, 0));

        // boom wordt getekend
        stam.teken(Color.BROWN,context);
        kruin.teken(Color.GREEN,context);

        // huis wordt getekend
        schouw.teken(Color.GRAY,context);
        gevel.teken(Color.ORANGE,context);
        raam.teken(Color.YELLOW,context);
        deur.teken(Color.YELLOW,context);
        dak.teken(Color.RED,context);



        group.getChildren().add(canvas);

        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

