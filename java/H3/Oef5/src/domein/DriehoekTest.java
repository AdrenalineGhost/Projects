package domein;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class DriehoekTest {
    @Test
    void testIsRechthoekig() {
        Driehoek dh1 = new Driehoek(3, 4, 5);
        assertEquals("Should be equal", true, dh1.isRechthoekig());

        Driehoek dh2 = new Driehoek(3, 4, 6);
        assertEquals("Should be equal", false, dh1.isRechthoekig());
    }
}
