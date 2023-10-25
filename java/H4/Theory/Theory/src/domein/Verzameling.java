package domein;
import java.security.SecureRandom;

public class Verzameling {
	private static final int LIMIT = 100;
	
	private SecureRandom random = new SecureRandom();
	boolean[] arr = new boolean[LIMIT];
	
	public int simuleerVerzamelingCompleet()
	{
		int aantal = 0;
		do {
			int nrPlaatje = random.nextInt(LIMIT) ; //geeft een
			//random getal terug tussen 1 en 6, grenzen inbegrepen
			
			arr[nrPlaatje] = true;

			aantal++;
			
			
		}while (!compleet());
		return aantal;
	}
	
	public boolean compleet()
	{
		for(boolean b : arr){
			if(!b) return false;
		} return true;
	}
}
