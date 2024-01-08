package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domein.Auto;

class AutoTest {

	@Test
	void maakAuto_DrieArgumenten_MaaktAuto() {
		Auto a = new Auto(false, 250.5, 3);
		Assertions.assertFalse(a.isElektrisch());
		Assertions.assertEquals(250.5, a.getAantalKilometers());
		Assertions.assertEquals(3, a.getVergoeding());
	}

	@Test
	void maakAuto_DrieArgumentenMinGrensKilometersVergoeding_MaaktAuto() {
		Auto a = new Auto(false, 0, 1);
		Assertions.assertFalse(a.isElektrisch());
		Assertions.assertEquals(0, a.getAantalKilometers());
		Assertions.assertEquals(1, a.getVergoeding());
	}

	@Test
	void maakAuto_DrieArgumentenMaxGrensKilometersVergoeding_MaaktAuto() {
		Auto a = new Auto(false, 1000, 5);
		Assertions.assertFalse(a.isElektrisch());
		Assertions.assertEquals(1000, a.getAantalKilometers());
		Assertions.assertEquals(5, a.getVergoeding());
	}

	@Test
	void maakAuto_DrieArgumentenTeKleinKilometersVergoeding_MaaktAuto() {
		Auto a = new Auto(false, -0.1, 0);
		Assertions.assertFalse(a.isElektrisch());
		Assertions.assertEquals(400.50, a.getAantalKilometers());
		Assertions.assertEquals(2, a.getVergoeding());
	}

	@Test
	void maakAuto_DrieArgumentenTeGrootKilometersVergoeding_MaaktAuto() {
		Auto a = new Auto(false, 1000.1, 6);
		Assertions.assertFalse(a.isElektrisch());
		Assertions.assertEquals(400.50, a.getAantalKilometers());
		Assertions.assertEquals(2, a.getVergoeding());
	}

	@Test
	void maakAuto_TweeArgumenten_MaaktAuto() {
		Auto a = new Auto(350.5, 4);
		Assertions.assertTrue(a.isElektrisch());
		Assertions.assertEquals(350.5, a.getAantalKilometers());
		Assertions.assertEquals(4, a.getVergoeding());
	}

	@Test
	void maakAuto_TweeArgumentenMinGrensKilometersVergoeding_MaaktAuto() {
		Auto a = new Auto(0, 1);
		Assertions.assertTrue(a.isElektrisch());
		Assertions.assertEquals(0, a.getAantalKilometers());
		Assertions.assertEquals(1, a.getVergoeding());
	}

	@Test
	void maakAuto_TweeArgumentenMaxGrensKilometersVergoeding_MaaktAuto() {
		Auto a = new Auto(1000, 5);
		Assertions.assertTrue(a.isElektrisch());
		Assertions.assertEquals(1000, a.getAantalKilometers());
		Assertions.assertEquals(5, a.getVergoeding());
	}

	@Test
	void maakAuto_TweeArgumentenTeKleinKilometersVergoeding_MaaktAuto() {
		Auto a = new Auto(-0.001, 0);
		Assertions.assertTrue(a.isElektrisch());
		Assertions.assertEquals(400.50, a.getAantalKilometers());
		Assertions.assertEquals(2, a.getVergoeding());
	}

	@Test
	void maakAuto_TweeArgumentenTeGrootKilometersVergoeding_MaaktAuto() {
		Auto a = new Auto(1000.001, 6);
		Assertions.assertTrue(a.isElektrisch());
		Assertions.assertEquals(400.50, a.getAantalKilometers());
		Assertions.assertEquals(2, a.getVergoeding());
	}

	@Test
	void maakAuto_EenArgument_MaaktAuto() {
		Auto a = new Auto(1);
		Assertions.assertTrue(a.isElektrisch());
		Assertions.assertEquals(400.5, a.getAantalKilometers());
		Assertions.assertEquals(1, a.getVergoeding());
	}

	@Test
	void maakAuto_EenArgumentTeKleinVergoeding_MaaktAuto() {
		Auto a = new Auto(0);
		Assertions.assertTrue(a.isElektrisch());
		Assertions.assertEquals(400.5, a.getAantalKilometers());
		Assertions.assertEquals(2, a.getVergoeding());
	}

	@Test
	void maakAuto_EenArgumentTeGrootVergoeding_MaaktAuto() {
		Auto a = new Auto(6);
		Assertions.assertTrue(a.isElektrisch());
		Assertions.assertEquals(400.5, a.getAantalKilometers());
		Assertions.assertEquals(2, a.getVergoeding());
	}

	@Test
	void setAantalKilometers_geldigeWaarde_wijzigtAantalKilometers() {
		Auto auto = new Auto(true, 200, 2);
		auto.setAantalKilometers(350.5);
		Assertions.assertEquals(350.5, auto.getAantalKilometers());
	}
	
	@Test
	void setAantalKilometers_minGrens_wijzigtAantalKilometers() {
		Auto auto = new Auto(true, 200, 2);
		auto.setAantalKilometers(0);
		Assertions.assertEquals(0, auto.getAantalKilometers());
	}

	@Test
	void setAantalKilometers_maxGrens_wijzigtAantalKilometers() {
		Auto auto = new Auto(true, 200, 2);
		auto.setAantalKilometers(1000.0);
		Assertions.assertEquals(1000.0, auto.getAantalKilometers());
	}
	
	@Test
	void setAantalKilometers_teKlein_wijzigtAantalKilometersNaarDefault() {
		Auto auto = new Auto(true, 200, 2);
		auto.setAantalKilometers(-0.01);
		Assertions.assertEquals(400.5, auto.getAantalKilometers());
	}
	
	@Test
	void setAantalKilometers_teGroot_wijzigtAantalKilometersNaarDefault() {
		Auto auto = new Auto(true, 200, 2);
		auto.setAantalKilometers(1000.01);
		Assertions.assertEquals(400.5, auto.getAantalKilometers());
	}
	
	@Test
	void setVergoeding_geldigeWaarde_wijzigtVergoeding() {
		Auto auto = new Auto(true, 200, 2);
		auto.setVergoeding(3);
		Assertions.assertEquals(3, auto.getVergoeding());
	}
	
	@Test
	void setVergoeding_minGrens_wijzigtVergoeding() {
		Auto auto = new Auto(true, 200, 2);
		auto.setVergoeding(1);
		Assertions.assertEquals(1, auto.getVergoeding());
	}
	
	@Test
	void setVergoeding_maxGrens_wijzigtVergoeding() {
		Auto auto = new Auto(true, 200, 2);
		auto.setVergoeding(5);
		Assertions.assertEquals(5, auto.getVergoeding());
	}
	
	@Test
	void setVergoeding_teKlein_wijzigtVergoedingNaarDefault() {
		Auto auto = new Auto(true, 200, 2);
		auto.setVergoeding(0);
		Assertions.assertEquals(2, auto.getVergoeding());
	}
	
	@Test
	void setVergoeding_teGroot_wijzigtVergoedingNaarDefault() {
		Auto auto = new Auto(true, 200, 2);
		auto.setVergoeding(6);
		Assertions.assertEquals(2, auto.getVergoeding());
	}
	
	@Test
	void heeftExtraVergoeding_extraVergoeding_retourneertTrue() {
		Auto auto = new Auto(true, 200, 2);
		Assertions.assertTrue(auto.heeftExtraVergoeding());
	}
	
	@Test
	void heeftExtraVergoeding_grensAantalKilometers_retourneertTrue() {
		Auto auto = new Auto(true, 400.5, 2);
		Assertions.assertTrue(auto.heeftExtraVergoeding());
	}
	
	@Test
	void heeftExtraVergoeding_nietElektrisch_retourneertFalse() {
		Auto auto = new Auto(false, 200, 2);
		Assertions.assertFalse(auto.heeftExtraVergoeding());
	}
	
	@Test
	void heeftExtraVergoeding_teveelKilometers_retourneertFalse() {
		Auto auto = new Auto(true, 400.501, 2);
		Assertions.assertFalse(auto.heeftExtraVergoeding());
	}
	
	@Test
	void berekenTotaleVergoeding_geenExtraVergoeding_600_1_retourneertTotaleWaarde() {
		Auto auto = new Auto(true, 600, 1); 
		//1000-600=400*1=400
		Assertions.assertEquals(400, auto.berekenTotaleVergoeding());
	}

	@Test
	void berekenTotaleVergoeding_geenExtraVergoeding_700_2_retourneertTotaleWaarde() {
		Auto auto = new Auto(true, 700, 2); 
		//1000-700=300*2=600
		Assertions.assertEquals(600, auto.berekenTotaleVergoeding());
	}
	
	@Test
	void berekenTotaleVergoeding_metExtraVergoeding_100_3_retourneertTotaleWaarde() {
		Auto auto = new Auto(true, 100, 3);
		//1000-100=900*3=2700*2=5400
		Assertions.assertEquals(5400, auto.berekenTotaleVergoeding());
	}
	
	@Test
	void berekenTotaleVergoeding_metExtraVergoeding_50_5_retourneertTotaleWaarde() {
		Auto auto = new Auto(true, 350, 5);
		//1000-350=650*5=3250*2=6500
		Assertions.assertEquals(6500, auto.berekenTotaleVergoeding());
	}
}
