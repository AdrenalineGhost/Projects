package cui;

import java.util.Scanner;

import domein.Parking;

public class ParkingApp {

	public static void main(String[] args) {
		new ParkingApp().simuleerParking();
	}

	private void simuleerParking() {
		Parking parking = new Parking();
		int keuze = geefMenuKeuze();
		while (keuze != 3) {
			switch (keuze) {
			case 1 -> parkeer(parking);
			case 2 -> verlaat(parking);
			}
			toonOverzichtParking(parking);
			keuze = geefMenuKeuze();
		}
	}

	private void parkeer(Parking parking) {
		// TODO
	}

	private void verlaat(Parking parking) {
		// TODO
	}

	private void toonOverzichtParking(Parking parking) {
		int vrijePlaatsen = parking.geefAantalVrijePlaatsen();
		System.out.printf("%n%18s=== PARKING (%d vrije plaats%s) ===%n%s%n%n", "", vrijePlaatsen,
				vrijePlaatsen == 1 ? "" : "en", parking);
	}

	private int geefMenuKeuze() {
		Scanner invoer = new Scanner(System.in);
		boolean geldigeInvoer;
		int keuze;
		do {
			System.out.printf("1. Parkeer%n2. Verlaat parking%n3. Stop%nGeef je keuze op: ");
			keuze = invoer.nextInt();
			geldigeInvoer = keuze >= 1 && keuze <= 3;
			if (!geldigeInvoer)
				System.out.println("Enkel 1, 2 of 3 zijn geldig...");
		} while (!geldigeInvoer);
		return keuze;
	}

	private String geefNummerplaat() {
		Scanner invoer = new Scanner(System.in);
		boolean geldigeInvoer;
		String nummerplaat;
		do {
			System.out.print("Geef de nummerplaat in > ");
			nummerplaat = invoer.nextLine();
			geldigeInvoer = nummerplaat.length() >= 3 && nummerplaat.length() <= 9;
			if (!geldigeInvoer)
				System.out.printf("Een geldige nummerplaat bevat 3 tot 9 karakters...%n");
		} while (!geldigeInvoer);
		return nummerplaat;
	}
}
