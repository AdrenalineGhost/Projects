package domein;

import java.util.ArrayList;
import java.util.List;

import persistentie.PlantMapper;

public class Tuincentrum 
{
	private List<Plant> planten;
	private final PlantMapper plantMapper;

	public Tuincentrum() 
	{
		plantMapper = new PlantMapper();
		this.planten = plantMapper.geefPlanten();
	}

	public void voegPlantToe(Plant plant) 
	{ 
		boolean contains = false;
		for (Plant currPlant: planten) {
			if (!contains&&currPlant.getNaam()==plant.getNaam()) {
				contains = true;
				currPlant.setAantalInVoorraad(currPlant.getAantalInVoorraad()+plant.getAantalInVoorraad());
			}
		}
	}

	public List<Plant> getPlanten() {
		return planten;
	}

	public int[] maakOverzichtPlantenPerHoogte(){
		int[] count = new int[3];
		for(Plant plant : planten){
			int height = plant.getHoogteInCm();
			count[height<=80?0:(height>100?2:1)]++;
		}
		return count;
	}
	
	

	public double bepaalWaardeVerkoop() {
		double total = 0;
		for (Plant plant : planten){
			total += plant.berekenVerkoopprijs()*plant.getAantalInVoorraad();
		}
		return total;
	}

	//TODO geefPlanten
	public List<Plant> geefPlanten(boolean inVoorraad){
		if (!inVoorraad) return planten;

		List<Plant> retList = new ArrayList<>();
		for (Plant plant : planten) if(plant.getAantalInVoorraad()!=0) retList.add(plant);
		return retList;
	}
	
	
	

}
