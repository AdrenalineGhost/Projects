package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Rekening;

public class RekeningTest {
	private Rekening rek;

	@BeforeEach
	public void before() {
		rek = new Rekening();
	}

	@Test
	public void maakRekening_defaultWaarden_maaktRekening() {
		assertEquals("onbekend", rek.getNaamHouder());
		assertEquals(123456789, rek.getRekeningNummer());
		assertEquals(0.0, rek.getSaldo());
	}

	@Test
	public void maakRekening_metRekeningNummer_maaktRekening() {
		rek = new Rekening(4545678912345L);
		assertEquals(4545678912345L, rek.getRekeningNummer());
		assertEquals(0.0, rek.getSaldo());
		assertEquals("onbekend", rek.getNaamHouder());
	}

	@Test
	public void maakRekening_metRekeningNummerEnHouder_maaktObject() {
		rek = new Rekening(2323456789123L, "Sofie");
		assertEquals(2323456789123L, rek.getRekeningNummer());
		assertEquals(0.0, rek.getSaldo());
		assertEquals("Sofie", rek.getNaamHouder());
	}

	@Test
	public void stort_geldigBedrag_verhoogtSaldo() {
		rek.stort(50);
		boolean resultaat = rek.stort(100);
		assertTrue(resultaat);
		assertEquals(150, rek.getSaldo());
	}

	@Test
	public void stort_minimumBedrag_verhoogtSaldo() {
		rek.stort(50);
		boolean resultaat = rek.stort(.01);
		assertTrue(resultaat);
		assertEquals(50.01, rek.getSaldo());
	}

	@Test
	public void stort_negatiefBedrag_wijzigtSaldoNiet() {
		rek.stort(50);
		boolean resultaat = rek.stort(-100);
		assertFalse(resultaat);
		assertEquals(50, rek.getSaldo());
	}

	@Test
	public void stort_bedragNul_wijzigtSaldoNiet() {
		rek.stort(50);
		boolean resultaat = rek.stort(.01);
		assertTrue(resultaat);
		assertEquals(50.01, rek.getSaldo());
	}

	@Test
	public void haalAf_geldigBedrag_verlaagtSaldo() {
		rek.stort(50);
		boolean resultaat = rek.haalAf(20);
		assertTrue(resultaat);
		assertEquals(30, rek.getSaldo());
	}

	@Test
	public void haalAf_minimumBedrag_verlaagtSaldo() {
		rek.stort(50);
		boolean resultaat = rek.haalAf(.01);
		assertTrue(resultaat);
		assertEquals(49.99, rek.getSaldo());
	}

	@Test
	public void haalAf_negatiefBedrag_wijzigtSaldoNiet() {
		rek.stort(50);
		boolean resultaat = rek.haalAf(-20);
		assertFalse(resultaat);
		assertEquals(50, rek.getSaldo());
	}

	@Test
	public void haalAf_bedragNul_wijzigtSaldoNiet() {
		rek.stort(50);
		boolean resultaat = rek.haalAf(0);
		assertFalse(resultaat);
		assertEquals(50, rek.getSaldo());
	}

	@Test
	public void haalAf_bedragGroterDanSaldo_wijzigtSaldoNiet() {
		rek.stort(50);
		boolean resultaat = rek.haalAf(100);
		assertFalse(resultaat);
		assertEquals(50, rek.getSaldo());
	}

	@Test
	public void haalAf_bedragNetGroterDanSaldo_wijzigtSaldoNiet() {
		rek.stort(50);
		boolean resultaat = rek.haalAf(50.01);
		assertFalse(resultaat);
		assertEquals(50, rek.getSaldo());
	}

	@Test
	public void haalAf_bedragGelijkAanSaldo_verlaagtSaldo() {
		rek.stort(50);
		boolean resultaat = rek.haalAf(50);
		assertTrue(resultaat);
		assertEquals(0, rek.getSaldo());
	}
}
