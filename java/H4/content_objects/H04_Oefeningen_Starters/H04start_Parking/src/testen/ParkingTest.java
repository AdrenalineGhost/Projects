package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Parking;

class ParkingTest {

	private Parking parking;

	@BeforeEach
	void setup() {
		parking = new Parking();
	}

	@Test
	void maakParking_maaktParkingMet5VrijePlaatsen() {
		assertEquals(5, parking.geefAantalVrijePlaatsen());
	}

	@Test
	void parkeer_geldigeNummerplaat_retourneertUniekNummerVanParkeerplaats() {
		Set<Integer> plaatsen = new HashSet<>();
		for (int i = 1; i <= 5; i++) {
			int plaats = parking.parkeer("1-ABC-11" + i);
			assertTrue(plaats >= 0 && plaats <= 5);
			plaatsen.add(plaats);
		}
		assertEquals(5, plaatsen.size());
	}

	@Test
	void parkeer_parkingVol_retourneertMin1() {
		for (int i = 1; i <= 5; i++) {
			parking.parkeer("1-ABC-11" + i);
		}
		assertEquals(-1, parking.parkeer("VOL"));
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "    ", "A", "AB", "ABCDEFGHIJ", "ABCDEFGHIJKLMNOP" })
	void parkeer_ongeldigeNummerplaat_retourneertMin1EnParkeertWagenNiet(String nummerplaat) {
		parking.parkeer("EERSTE");
		parking.parkeer("TWEEDE");
		assertEquals(-1, parking.parkeer(nummerplaat));
		assertEquals(3, parking.geefAantalVrijePlaatsen());
	}

	@Test
	void verlaat_legeParking_retourneertFalse() {
		assertFalse(parking.verlaat("LEEG"));
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "DERDE" })
	void verlaat_parkingNietLeegMetNummerplaatNietGeparkeerdeWagen_retourneertFalseEnMaaktGeenPlaatsVrij(
			String nummerplaat) {
		parking.parkeer("EERSTE");
		parking.parkeer("TWEEDE");
		assertFalse(parking.verlaat(nummerplaat));
		assertEquals(3, parking.geefAantalVrijePlaatsen());
	}

	@Test
	void verlaat_parkingNietLeegMetNummerplaatVanGeparkeerdeWagen_retourneertTrueEnMaaktPlaatsVrij() {
		parking.parkeer("EERSTE");
		parking.parkeer("TWEEDE");
		assertTrue(parking.verlaat("TWEEDE"));
		assertEquals(4, parking.geefAantalVrijePlaatsen());
	}

}
