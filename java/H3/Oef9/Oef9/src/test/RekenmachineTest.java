package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Rekenmachine;

public class RekenmachineTest {

	Rekenmachine rm;

	@BeforeEach
	void maakRekenmachine() {
		rm = new Rekenmachine();
	}

	@Test
	void maakRekenmachine_MaaktRekenmachine() {
		assertEquals(0, rm.getResultaat());
	}

	@Test
	void telOp_maaktSom() {
		rm.telOp(2.5, 6.8);
		assertEquals(9.3, rm.getResultaat(), 0.00000000001);
	}

	@Test
	void trekAf_maaktVerschil() {
		rm.trekAf(2.5, 6.8);
		assertEquals(-4.3, rm.getResultaat(), 0.00000000001);
	}

	@Test
	void deel_maaktDeling() {
		rm.deel(2.5, 6.8);
		assertEquals(0.3676470588235294, rm.getResultaat(), 0.00000000001);
	}

	@Test
	void vermenigvuldig_maaktProduct() {
		rm.vermenigvuldig(2.5, 6.8);
		assertEquals(17, rm.getResultaat(), 0.00000000001);
	}

}
