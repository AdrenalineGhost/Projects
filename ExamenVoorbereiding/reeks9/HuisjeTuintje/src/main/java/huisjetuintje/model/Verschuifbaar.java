package huisjetuintje.model;

public interface Verschuifbaar {
    // verschuift over gewone wiskundige coördinaten (Y-as naar omhoog);
    // object Coo is een coördinaat in een Cartesiaans assenstelsel
    // waarbij de oorsprong linksonder ligt,
    // het gebied dat getekend wordt eindigt in de rechterbovenhoek
    // met coördinaten (20,15).
    public void verschuif(Coo delta);
}
