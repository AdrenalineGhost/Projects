package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Marktkraam;

public class MarktkraamTest {
	private Marktkraam kraamBreedte3;

	@BeforeEach
	public void before() {
		kraamBreedte3 = new Marktkraam("Jan", 3);
	}

	@ParameterizedTest
	@ValueSource(ints = { 2, 5, 10 })
	public void maakMarktkraam_GeldigeNaamEnGeldigeLengte_maaktMarktkraam(int breedte) {
		Marktkraam kraam = new Marktkraam("Jan", breedte);
		assertEquals("Jan", kraam.getKraamhouder());
		assertEquals(breedte, kraam.getBreedte());
	}

	@ParameterizedTest
	@ValueSource(strings = { "X", "Jan", "Jan-Willem", "Mr. Jan" })
	public void maakMarktkraam_GeldigeNaamEnGeldigeBreedte_maaktMarktkraam(String naam) {
		Marktkraam kraam = new Marktkraam(naam, 5);
		assertEquals(naam, kraam.getKraamhouder());
		assertEquals(5, kraam.getBreedte());
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { " ", "   ", "\t", "\n" })
	public void maakMarktkraam_GeenNaamIngevuldNaamEnGeldigeBreedte_steltNaamInOpAnoniem(String naam) {
		Marktkraam kraam = new Marktkraam(naam, 5);
		assertEquals("anoniem", kraam.getKraamhouder());
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, -10, 11, 15 })
	public void maakMarktkraam_GeldigeNaamEnBreedteBuitenInterval_steltBreedteInOp10(int breedte) {
		Marktkraam kraam = new Marktkraam("Jan", breedte);
		assertEquals(10, kraam.getBreedte());
	}

	@Test
	public void voegToeAanInkomsten_KraamVanBreedte3PositieveInkomst_voegtInkomstToe() {
		kraamBreedte3.ontvang(10);
		kraamBreedte3.ontvang(5);
		Assertions.assertEquals(6, kraamBreedte3.geefWinst(), 0.1);
	}

	@Test
	public void voegToeAanInkomsten_KraamVanBreedte3NegatieveInkomst_voegtInkomstNietToe() {
		kraamBreedte3.ontvang(10);
		kraamBreedte3.ontvang(-5);
		Assertions.assertEquals(1, kraamBreedte3.geefWinst(), 0.1);
	}

	@Test
	public void voegToeAanInkomsten_KraamVanBreedte3InkomstNul_voegtNietsAanInkomstToe() {
		kraamBreedte3.ontvang(10);
		kraamBreedte3.ontvang(0);
		Assertions.assertEquals(1, kraamBreedte3.geefWinst(), 0.1);
	}

	@Test
	public void berekenWinst_KraamVanBreedte3ZonderInkomsten_retourneertWinst() {
		Assertions.assertEquals(-9, kraamBreedte3.geefWinst(), 0.1);
	}

	@Test
	public void berekenWinst_KraamVanBreedte5ZonderInkomsten_retourneertWinst() {
		Marktkraam kraamBreedte5 = new Marktkraam("Jan", 5);
		Assertions.assertEquals(-15, kraamBreedte5.geefWinst(), 0.1);
	}

	@Test
	public void berekenWinst_KraamVanBreedte6ZonderInkomsten_retourneertWinst() {
		Marktkraam kraamBreedte6 = new Marktkraam("Jan", 6);
		Assertions.assertEquals(-15, kraamBreedte6.geefWinst(), 0.1);
	}

	@Test
	public void berekenWinst_KraamVanBreedte8ZonderInkomsten_retourneertWinst() {
		Marktkraam kraamBreedte8 = new Marktkraam("Jan", 8);
		Assertions.assertEquals(-20, kraamBreedte8.geefWinst(), 0.1);
	}

	@Test
	public void berekenWinst_KraamMetNegatieveWinst_retourneertWinst() {
		kraamBreedte3.ontvang(2.5);
		Assertions.assertEquals(-6.5, kraamBreedte3.geefWinst(), 0.1);
	}

	@Test
	public void berekenWinst_KraamMetPositieveWinst_retourneertWinst() {
		kraamBreedte3.ontvang(30.5);
		Assertions.assertEquals(21.5, kraamBreedte3.geefWinst(), 0.1);
	}

	@Test
	public void berekenWinst_KraamMetWinstNul_retourneertWinst() {
		kraamBreedte3.ontvang(9);
		Assertions.assertEquals(0, kraamBreedte3.geefWinst(), 0.1);
	}

}
