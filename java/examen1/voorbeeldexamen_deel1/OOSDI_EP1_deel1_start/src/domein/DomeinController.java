package domein;

import java.util.List;

import dto.PlantDTO;

public class DomeinController 
{
	private Tuincentrum tuincentrum;

	public DomeinController() {
		tuincentrum = new Tuincentrum();
	}

	public void voegPlantToe(String naam, char soortCode, int hoogteInCm, double prijsInEuro, int aantalInVoorraad) {
		tuincentrum.voegPlantToe(new Plant(naam, soortCode, hoogteInCm, prijsInEuro, aantalInVoorraad));
	}

	public PlantDTO[] geefAllePlanten(boolean inVoorraad) {
		List<Plant> planten = tuincentrum.geefPlanten(inVoorraad);
		PlantDTO[] plantDTO = new PlantDTO[planten.size()];

		int itt = 0;

		for (Plant plant : planten) {
			plantDTO[itt++] = new PlantDTO(plant.getNaam(), plant.getSoortCode(), plant.getHoogteInCm(), plant.getPrijsInEuro(), plant.getAantalInVoorraad());
		}

		return plantDTO;
	}

	
	public double bepaalWaardeVerkoop()
	{
		return tuincentrum.bepaalWaardeVerkoop();
	}

	public int[] maakOverzichtPlantenPerHoogte() 
	{
		return tuincentrum.maakOverzichtPlantenPerHoogte();
	}

}
