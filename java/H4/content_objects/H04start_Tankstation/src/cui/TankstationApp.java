package cui;

import java.util.Scanner;

import domein.Tankstation;

public class TankstationApp {

	private static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		new TankstationApp().startTanken();
	}

	private void startTanken() {
		Tankstation tankstation = new Tankstation();
		int count =0;
		int totalLiter =0;
		int liter;
		int pomp = geefPompNummer(tankstation.MAX_POMPEN);
		while(pomp != 0){
			liter = geefAantalLiter(tankstation.MIN_LITER, tankstation.MAX_LITER);

			if(liter > tankstation.geefInhoud(pomp)) System.out.printf("%nSorry, er is onvoldoende brandstof aan pomp %d", pomp);
			else {
				tankstation.tank(pomp,liter);
				totalLiter+=liter;
				System.out.printf("%nJe hebt %d liter getankt aan pomp %d",liter, pomp);
				count++;
			}

			System.out.printf("%n%s",tankstation);

			pomp = geefPompNummer(tankstation.MAX_POMPEN);
		}
		if(count == 0){
			System.out.printf("Er waren geen tankbeurten:%n%s",tankstation);
		} else {
			System.out.printf("Er werd in totaal %d liter getankt in %d tankbeurten.", totalLiter, count);
		}
	}

	private int geefAantalLiter(int min, int max) {
		int liter;
		liter = vraag(String.format("Hoeveel liter wens je te tanken (%d tot %d)? ", min, max));
		while(liter<min||liter>max){
			liter = vraag(String.format("Hoeveel liter wens je te tanken (%d tot %d)? ", min, max));
		} return liter;
	}

	private int geefPompNummer(int max) {
		int pomp;
		pomp = vraag(String.format("Aan welke pomp wens je te tankern (1-%d), druk 0 om te stoppen? ", max));
		while(pomp<0||pomp>max){
			System.out.printf("%nWe hebben geen pomp met nummer %d! Probeer opnieuw...", pomp);
			pomp = vraag(String.format("Aan welke pomp wens je te tankern (1-%d), druk 0 om te stoppen? ", max));
		}
		return pomp;
	}

	private int vraag(String string){
		System.out.printf("%n%s",string);
		return sc.nextInt();
	}
}
