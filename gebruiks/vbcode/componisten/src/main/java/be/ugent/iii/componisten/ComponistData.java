package be.ugent.iii.componisten;


import java.util.HashMap;
import java.util.Map;

/**
 * Aangepast door Veerle Ongenae
 *
 * @author nbuser
 */
public class ComponistData {
    private final Map<String,Componist> composers =
            new HashMap<>();


    public Map<String,Componist> getComponists() {
        return composers;
    }

    public ComponistData() {

        composers.put("1", new Componist("1", "Johann Sebastian", "Bach", "Baroque"));
        composers.put("2", new Componist("2", "Arcangelo", "Corelli", "Baroque"));
        composers.put("3", new Componist("3", "George Frideric", "Handel", "Baroque"));
        composers.put("4", new Componist("4", "Henry", "Purcell", "Baroque"));
        composers.put("5", new Componist("5", "Jean-Philippe", "Rameau", "Baroque"));
        composers.put("6", new Componist("6", "Domenico", "Scarlatti", "Baroque"));
        composers.put("7", new Componist("7", "Antonio", "Vivaldi", "Baroque"));
        composers.put("8", new Componist("8", "Ludwig van", "Beethoven", "Classical"));
        composers.put("9", new Componist("9", "Johannes", "Brahms", "Classical"));
        composers.put("10", new Componist("10", "Francesco", "Cavalli", "Classical"));

        composers.put("11", new Componist("11", "Fryderyk Franciszek", "Chopin", "Classical"));
        composers.put("12", new Componist("12", "Antonin", "Dvorak", "Classical"));
        composers.put("13", new Componist("13", "Franz Joseph", "Haydn", "Classical"));
        composers.put("14", new Componist("14", "Gustav", "Mahler", "Classical"));
        composers.put("15", new Componist("15", "Wolfgang Amadeus", "Mozart", "Classical"));
        composers.put("16", new Componist("16", "Johann", "Pachelbel", "Classical"));
        composers.put("17", new Componist("17", "Gioachino", "Rossini", "Classical"));
        composers.put("18", new Componist("18", "Dmitry", "Shostakovich", "Classical"));
        composers.put("19", new Componist("19", "Richard", "Wagner", "Classical"));

        composers.put("20", new Componist("20", "Louis-Hector", "Berlioz", "Romantic"));
        composers.put("21", new Componist("21", "Georges", "Bizet", "Romantic"));
        composers.put("22", new Componist("22", "Cesar", "Cui", "Romantic"));
        composers.put("23", new Componist("23", "Claude", "Debussy", "Romantic"));
        composers.put("24", new Componist("24", "Edward", "Elgar", "Romantic"));
        composers.put("25", new Componist("25", "Gabriel", "Faure", "Romantic"));
        composers.put("26", new Componist("26", "Cesar", "Franck", "Romantic"));
        composers.put("27", new Componist("27", "Edvard", "Grieg", "Romantic"));
        composers.put("28", new Componist("28", "Nikolay", "Rimsky-Korsakov", "Romantic"));
        composers.put("29", new Componist("29", "Franz Joseph", "Liszt", "Romantic"));

        composers.put("30", new Componist("30", "Felix", "Mendelssohn", "Romantic"));
        composers.put("31", new Componist("31", "Giacomo", "Puccini", "Romantic"));
        composers.put("32", new Componist("32", "Sergei", "Rachmaninoff", "Romantic"));
        composers.put("33", new Componist("33", "Camille", "Saint-Saens", "Romantic"));
        composers.put("34", new Componist("34", "Franz", "Schubert", "Romantic"));
        composers.put("35", new Componist("35", "Robert", "Schumann", "Romantic"));
        composers.put("36", new Componist("36", "Jean", "Sibelius", "Romantic"));
        composers.put("37", new Componist("37", "Bedrich", "Smetana", "Romantic"));
        composers.put("38", new Componist("38", "Richard", "Strauss", "Romantic"));
        composers.put("39", new Componist("39", "Pyotr Il'yich", "Tchaikovsky", "Romantic"));
        composers.put("40", new Componist("40", "Guiseppe", "Verdi", "Romantic"));

        composers.put("41", new Componist("41", "Bela", "Bartok", "Post-Romantic"));
        composers.put("42", new Componist("42", "Leonard", "Bernstein", "Post-Romantic"));
        composers.put("43", new Componist("43", "Benjamin", "Britten", "Post-Romantic"));
        composers.put("44", new Componist("44", "John", "Cage", "Post-Romantic"));
        composers.put("45", new Componist("45", "Aaron", "Copland", "Post-Romantic"));
        composers.put("46", new Componist("46", "George", "Gershwin", "Post-Romantic"));
        composers.put("47", new Componist("47", "Sergey", "Prokofiev", "Post-Romantic"));
        composers.put("48", new Componist("48", "Maurice", "Ravel", "Post-Romantic"));
        composers.put("49", new Componist("49", "Igor", "Stravinsky", "Post-Romantic"));
        composers.put("50", new Componist("50", "Carl", "Orff", "Post-Romantic"));

    }

}
