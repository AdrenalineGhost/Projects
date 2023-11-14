package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domein.Lied;

public class LiedTest {

	@Test
	void maakLied_GeldigeGegevens_MaaktLied() {
		Lied l = new Lied(5.5, 90);
		assertEquals(5.5, l.getDuurInMinuten());
		assertEquals(90, l.getBeatsPerMinute());
	}

	@Test
	void maakLied_DuurIsNetNietTeGroot_MaaktLied() {
		Lied l = new Lied(10, 90);
		assertEquals(10, l.getDuurInMinuten());
	}

	@Test
	void maakLied_DuurIsNetNietTeKlein_MaaktLied() {
		Lied l = new Lied(0.5, 90);
		assertEquals(0.5, l.getDuurInMinuten());
	}

	@Test
	void maakLied_BeatsPerMinuteIsNetNietTeGroot_MaaktLied() {
		Lied l = new Lied(5, 200);
		assertEquals(200, l.getBeatsPerMinute());
	}

	@Test
	void maakLied_BeatsPerMinuteIsNetNietTeKlein_MaaktLied() {
		Lied l = new Lied(5, 10);
		assertEquals(10, l.getBeatsPerMinute());
	}

	@Test
	void maakLied_DuurIsNetTeGroot_MaaktLiedMetEenDuurVan4Minuten() {
		double duur = Math.nextUp(10);
		Lied l = new Lied(duur, 90);
		assertEquals(4, l.getDuurInMinuten());
	}

	@Test
	void maakLied_DuurIsNetTeKlein_MaaktLiedMetEenDuurVan4Minuten() {
		double duur = Math.nextDown(0.5);
		Lied l = new Lied(duur, 90);
		assertEquals(4, l.getDuurInMinuten());
	}

	@Test
	void maakLied_DuurIsTeGroot_MaaktLiedMetEenDuurVan4Minuten() {
		Lied l = new Lied(30, 90);
		assertEquals(4, l.getDuurInMinuten());
	}

	@Test
	void maakLied_DuurIsTeKlein_MaaktLiedMetEenDuurVan4Minuten() {
		Lied l = new Lied(-30, 90);
		assertEquals(4, l.getDuurInMinuten());
	}

	@Test
	void maakLied_BeatsPerMinuteIsNetTeGroot_MaaktLiedVan100BPM() {
		Lied l = new Lied(5, 201);
		assertEquals(100, l.getBeatsPerMinute());
	}

	@Test
	void maakLied_BeatsPerMinuteIsNetTeKlein_MaaktLiedVan100BPM() {
		Lied l = new Lied(5, 9);
		assertEquals(100, l.getBeatsPerMinute());
	}

	@Test
	void maakLied_BeatsPerMinuteIsTeGroot_MaaktLiedVan100BPM() {
		Lied l = new Lied(5, 500);
		assertEquals(100, l.getBeatsPerMinute());
	}

	@Test
	void maakLied_BeatsPerMinuteIsTeKlein_MaaktLiedVan100BPM() {
		Lied l = new Lied(5, 2);
		assertEquals(100, l.getBeatsPerMinute());
	}

	@Test
	void geefTempo_LiedMetBPM10_RetourneertTraag() {
		Lied l = new Lied(4, 10);
		assertEquals("traag", l.geefTempo());
	}

	@Test
	void geefTempo_LiedMetBPM50_RetourneertTraag() {
		Lied l = new Lied(4, 50);
		assertEquals("traag", l.geefTempo());
	}

	@Test
	void geefTempo_LiedMetBPM70_RetourneertTraag() {
		Lied l = new Lied(4, 70);
		assertEquals("traag", l.geefTempo());
	}

	@Test
	void geefTempo_LiedMetBPM71_RetourneertRelax() {
		Lied l = new Lied(4, 71);
		assertEquals("relax", l.geefTempo());
	}

	@Test
	void geefTempo_LiedMetBPM80_RetourneertRelax() {
		Lied l = new Lied(4, 80);
		assertEquals("relax", l.geefTempo());
	}

	@Test
	void geefTempo_LiedMetBPM90_RetourneertRelax() {
		Lied l = new Lied(4, 90);
		assertEquals("relax", l.geefTempo());
	}

	@Test
	void geefTempo_LiedMetBPM91_RetourneertFris() {
		Lied l = new Lied(4, 91);
		assertEquals("fris", l.geefTempo());
	}

	@Test
	void geefTempo_LiedMetBPM100_RetourneertFris() {
		Lied l = new Lied(4, 100);
		assertEquals("fris", l.geefTempo());
	}

	@Test
	void geefTempo_LiedMetBPM120_RetourneertFris() {
		Lied l = new Lied(4, 120);
		assertEquals("fris", l.geefTempo());
	}

	@Test
	void geefTempo_LiedMetBPM121_RetourneertLevendig() {
		Lied l = new Lied(4, 121);
		assertEquals("levendig", l.geefTempo());
	}

	@Test
	void geefTempo_LiedMetBPM130_RetourneertLevendig() {
		Lied l = new Lied(4, 130);
		assertEquals("levendig", l.geefTempo());
	}

	@Test
	void geefTempo_LiedMetBPM180_RetourneertLevendig() {
		Lied l = new Lied(4, 121);
		assertEquals("levendig", l.geefTempo());
	}

	@Test
	void geefTempo_LiedMetBPM181_RetourneertSnel() {
		Lied l = new Lied(4, 181);
		assertEquals("snel", l.geefTempo());
	}

	@Test
	void geefTempo_LiedMetBPM190_RetourneertSnel() {
		Lied l = new Lied(4, 190);
		assertEquals("snel", l.geefTempo());
	}

	@Test
	void geefTempo_LiedMetBPM200_RetourneertSnel() {
		Lied l = new Lied(4, 200);
		assertEquals("snel", l.geefTempo());
	}

	@Test
	void geefDuurInSeconden_RetourneertDeDuurInSeconden() {
		Lied l = new Lied(3.6, 150);
		assertEquals(216, l.geefDuurInSeconden());
	}
}
