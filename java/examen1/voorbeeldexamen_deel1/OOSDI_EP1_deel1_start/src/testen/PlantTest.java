package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Plant;

class PlantTest {


	@Test
	void maakPlant_geldigeWaarden_maaktPlant() 
	{
		Plant pl = new Plant("Rufa", 'A', 60, 18.99, 50);
		assertEquals("Rufa", pl.getNaam());
		assertEquals('A', pl.getSoortCode());
		assertEquals(60, pl.getHoogteInCm());
		assertEquals(18.99, pl.getPrijsInEuro());
		assertEquals(50, pl.getAantalInVoorraad());
	}
	
	@Test
	void maakPlant_geldigeNaamSoortCodeWaarden_maaktPlant() 
	{
		Plant pl = new Plant("Rufa", 'A');
		assertEquals("Rufa", pl.getNaam());
		assertEquals('A', pl.getSoortCode());
		assertEquals(100, pl.getHoogteInCm());
		assertEquals(0, pl.getPrijsInEuro());
		assertEquals(0, pl.getAantalInVoorraad());
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"   ", "\t"})
	void maakPlant_ongeldigeNaam_werptException(String naam) 
	{
		assertThrows(IllegalArgumentException.class, 
				() -> new Plant(naam, 'A', 60, 18.99, 50));
	}
	
	@ParameterizedTest
	@ValueSource(chars = {'a', 'D'})
	void maakPlant_ongeldigeSoortCode_werptException(char code) 
	{
		assertThrows(IllegalArgumentException.class, 
				() -> new Plant("Rufa", code, 60, 18.99, 50));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {0,401,-80, 500})
	void maakPlant_ongeldigeHoogte_werptException(int hoogte) 
	{
		assertThrows(IllegalArgumentException.class, 
				() -> new Plant("Rufa", 'A', hoogte, 18.99, 50));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {-1, -5})
	void maakPlant_ongeldigAantalInVoorraad_werptException(int aantal) 
	{
		assertThrows(IllegalArgumentException.class, 
				() -> new Plant("Rufa", 'A', 60, 18.99, aantal));
	}
	
	@Test
	void berekenVerkoopprijs_retourneerVerkoopprijs()
	{
		Plant pl = new Plant("Rufa", 'A', 60, 18.99, 50);
		assertEquals(22.9779, pl.berekenVerkoopprijs(),0.0001);
	}

}
