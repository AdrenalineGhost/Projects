package domein;

public class Tankstation {
	private int[] pompen;

	public Tankstation() {
		// TODO
	}

	public boolean tank(int pompNummer, int aantalLiter) {
		// TODO
	}

	public int geefInhoud(int pompNummer) {
		// TODO
	}

	public String toString() {
		String resultaat = "";
		for (int i = 0; i < pompen.length; i++) {
			resultaat += String.format("Pomp #%d: %d liter%n", i + 1, pompen[i]);
		}
		return resultaat;
	}

}
