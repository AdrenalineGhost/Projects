package boggledeel1;

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
    
    public static void controleerEquals(String boodschap, char verwacht, char berekend) {
        if (verwacht == berekend) {
            System.out.println("test passed " );
        } else {
            System.out.println("TEST FAILED " + boodschap + " verwacht: " + verwacht + "; berekend: " + berekend);
        }
    }
    
    public static void controleerTrue(String boodschap, boolean berekend) {
        if (berekend) {
            System.out.println("test passed " );
        } else {
            System.out.println("TEST FAILED " + boodschap);
        }
    }
}

