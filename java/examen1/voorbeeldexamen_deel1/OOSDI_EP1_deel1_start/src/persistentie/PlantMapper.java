package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Plant;

public class PlantMapper 
{
	public List<Plant> geefPlanten()
	{
		List<Plant> planten = new ArrayList<>();
		
		planten.add(new Plant("Boerenhortensia", 'B', 150, 9.99, 5));
		planten.add(new Plant("Rufa", 'A', 60, 18.99, 50));
		planten.add(new Plant("Vlinderstruik", 'C', 40, 10.99, 15));
		planten.add(new Plant("Boerenjasmijn", 'C'));
		planten.add(new Plant("Esdoorn", 'C'));
		
		return planten;
				
	}

}
