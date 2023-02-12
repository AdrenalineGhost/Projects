package adressen;

/**
 *
 * @author tiwi
 */
public class Testklasse {

    public static void controleerEquals(String boodschap, String verwacht, String berekend) {
        if (verwacht.equals(berekend)) {
            System.out.println("test passed " );
        } else {
            System.out.println("TEST FAILED " + boodschap + " verwacht: " + verwacht + "; berekend: " + berekend);
        }
    }

    public static void controleerEquals(String boodschap, int verwacht, int berekend) {
        if (verwacht == berekend) {
            System.out.println("test passed " );
        } else {
            System.out.println("TEST FAILED " + boodschap + " verwacht: " + verwacht + "; berekend: " + berekend);
        }
    }
}

