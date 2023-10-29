package cui;

import java.security.SecureRandom;

public class VierOpEenRijApp {

	public static void main(String[] args) {
		new VierOpEenRijApp().vulArrayEnControleerOpVierOpEenRij();
	}

	private void vulArrayEnControleerOpVierOpEenRij() {
		// Maken en opvullen van de array karakters
		SecureRandom sr = new SecureRandom();
		char[] karakters = new char[10];
		for (int i = 0; i < karakters.length; i++) {
			karakters[i] = sr.nextBoolean() ? 'X' : 'O';
		}

		// TODO hieronder aanvullen
		// ga na als karakters vier zelfde karakters op rij bevat
		// en verzorg de uitvoer

	}

}
