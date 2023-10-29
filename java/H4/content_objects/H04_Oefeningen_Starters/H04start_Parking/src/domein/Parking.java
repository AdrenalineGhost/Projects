package domein;

public class Parking {
	private String[] nummerplaten = new String[5];

	public int parkeer(String nummerplaat) {
		// TODO
		return -1;
	}

	public boolean verlaat(String nummerplaat) {
		// TODO
		return false;
	}

	public int geefAantalVrijePlaatsen() {
		int aantalVrij = 0;
		for (String np : nummerplaten) {
			aantalVrij += np == null ? 1 : 0;
		}
		return aantalVrij;
	}

	public String toString() {
		String plaatsen = "";
		for (int i = 0; i < nummerplaten.length; i++) {
			plaatsen += String.format("%12d", i);
		}
		plaatsen += "\n";
		for (String np : nummerplaten) {
			plaatsen += String.format("%12s", np == null ? "--vrij--" : np);
		}
		return plaatsen;
	}
}
