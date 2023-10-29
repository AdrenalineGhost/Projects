package cui;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Startup {

	public static void main(String[] args) {
		new Startup().maakLijstMetTevredenheidsscoresEnToonSamenvatting();
	}

	private void maakLijstMetTevredenheidsscoresEnToonSamenvatting() {
		// Maak en vul de lijst scores
		SecureRandom sr = new SecureRandom();
		int aantalScores = sr.nextInt(10, 15);
		List<Integer> scores = new ArrayList<>();
		for (int i = 0; i < aantalScores; i++) {
			scores.add(sr.nextInt(1, 6));
		}

		// TODO hier verder aanvullen
	}

}
