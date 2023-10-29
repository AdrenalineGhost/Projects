package domein;

public class Tankstation {
    public static final int MAX_POMPEN = 5;
    public static final int MIN_LITER = 5;
    public static final int MAX_LITER = 80;
	private int[] pompen;

	public Tankstation() {
        pompen = new int[MAX_POMPEN];
        for(int i = 0; i < MAX_POMPEN; i++){
			pompen[i] = 100;
        }
	}

	public boolean tank(int pompNummer, int aantalLiter) {
		if(
			pompNummer>=1&&pompNummer<=MAX_POMPEN
			&&aantalLiter>=MIN_LITER&&aantalLiter<=MAX_LITER
			&&geefInhoud(pompNummer)>=aantalLiter
		){
			pompen[pompNummer-1]-=aantalLiter;
			return true;
		} return false;
	}

	public int geefInhoud(int pompNummer) {
        // exception handling
        if(pompNummer<1||pompNummer>MAX_POMPEN) return -1;
        return pompen[pompNummer-1];
	}

	public String toString() {
		String resultaat = "";
		for (int i = 0; i < pompen.length; i++) {
			resultaat += String.format("Pomp #%d: %d liter%n", i + 1, pompen[i]);
		}
		return resultaat;
	}

}
