package huisjetuintje.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public interface Tekenbaar {
    public void teken(Color kleur, GraphicsContext context);
}
