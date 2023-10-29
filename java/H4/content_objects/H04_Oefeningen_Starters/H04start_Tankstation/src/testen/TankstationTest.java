package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Tankstation;

class TankstationTest {

	final static int AANTAL_POMPEN = 5;
	final static int CAPACITEIT = 100;

	private Tankstation ts;

	@BeforeEach
	void setup() {
		ts = new Tankstation();
	}

	@Test
	void maakTankstation_maaktTankstationMetVollePompen() {
		for (int i = 1; i <= AANTAL_POMPEN; i++) {
			assertEquals(100, ts.geefInhoud(i));
		}

	}

	@Test
	void tank_GeldigPompnummerEnGeldigAantalLiter_VermindertInhoudVanPomp() {
		ts.tank(1, 30);
		assertTrue(ts.tank(1, 20));
		assertEquals(50, ts.geefInhoud(1));
	}

	@Test
	void tank_GeldigPompnummerEnGeldigMaxAantalLiter_VermindertInhoudVanPomp() {
		ts.tank(1, 10);
		assertTrue(ts.tank(1, 80));
		assertEquals(10, ts.geefInhoud(1));
	}

	@Test
	void tank_GeldigPompnummerEnGeldigMinAantalLiter_VermindertInhoudVanPomp() {
		ts.tank(1, 30);
		assertTrue(ts.tank(1, 5));
		assertEquals(65, ts.geefInhoud(1));
	}

	@Test
	void tank_GeldigPompnummerEnAantalLiterGelijkAanPompinhoud_VermindertInhoudVanPomp() {
		ts.tank(1, 50);
		assertTrue(ts.tank(1, 50));
		assertEquals(0, ts.geefInhoud(1));
	}

	@ParameterizedTest
	@ValueSource(ints = { 81, 100, 4, -7 })
	void tank_GeldigPompnummerEnOngeldigAantalLiter_WijzigtPompNiet(int aantalLiter) {
		ts.tank(1, 25);
		assertFalse(ts.tank(1, aantalLiter));
		assertEquals(75, ts.geefInhoud(1));
	}

	@ParameterizedTest
	@ValueSource(ints = { 0, -5, 6, 10 })
	void tank_OnGeldigPompnummerEnGeldigAantalLiter_WijzigtStationNiet(int pompNummer) {
		ts.tank(1, 25);
		assertFalse(ts.tank(pompNummer, 20));
		assertEquals(75, ts.geefInhoud(1));
		for (int i = 2; i <= AANTAL_POMPEN; i++) {
			assertEquals(100, ts.geefInhoud(i));
		}
	}

	@Test
	void geefInhoud_GeldigPompnummer_RetourneertInhoud() {
		ts.tank(1, 50);
		assertEquals(50, ts.geefInhoud(1));
	}

	@Test
	void geefInhoud_OngeldigPompnummer_RetourneertMin1() {
		assertEquals(-1, ts.geefInhoud(100));
	}

}
