package cui;

import java.util.Scanner;

import domein.Marktkraam;

public class RommelmarktApp {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		new RommelmarktApp().simuleerRommelmarkt();
	}

	private void simuleerRommelmarkt() {
		int aantal = geefAantalKramen();
		int breedte; 
		String kraamhouder;
		StringBuilder sb = new StringBuilder();
		Marktkraam[] mk = new Marktkraam[aantal];

		sb.append("%nAan welk kraam wil je iets kopen?%n");

		for (int i = 1; i <= mk.length; i++) {
			breedte = geefBreedteKraam(i);
			kraamhouder = geefKraamhouder(i);
			mk[i-1] = new Marktkraam(kraamhouder, breedte);
			sb.append("%d. Kraam van %s.%n".formatted(i, kraamhouder));
		}

		sb.append("%nKies je kraam (of geef 0 om te stoppen): ");

		int keuze = geefKeuze(mk.length, sb.toString());
		double bedrag;
		while(keuze!=0){
			bedrag = geefBedrag();
			mk[keuze-1].ontvang(bedrag);
			keuze = geefKeuze(mk.length, sb.toString());
		}

		for (Marktkraam marktkraam : mk) System.out.printf("%nKraamhouder %s maakte %.2f Euro winst", marktkraam.getKraamhouder(), marktkraam.geefWinst());
		
		
	}

	private double geefBedrag() {
		double answer = askDouble("%nGeef op voor hoeveel Euro je kocht: ");
		while(answer<0) answer = askDouble("%nDe prijs moet strikt positief zijn...%nGeef op voor hoeveel Euro je kocht:");
		return answer;
	}

	private int geefKeuze(int aantalKramen, String menu) {
		int answer = askInt(menu);
		while(0>answer||answer>aantalKramen) answer = askInt("%nDit is geen geldige keuze! Probeer opnieuw...%n%s".formatted(menu));
		return answer;
	}

	private int geefAantalKramen() {
		int answer = askInt("%nGeef het aantal kramen dat op de rommelmarkt staan: ");
		while(answer<=0) answer = askInt("%nHet aantal moet groter dan 0 zijn, probeer opnieuw...%nGeef het aantal kramen dat op de rommelmarkt staan: ");
		return answer;
	}

	private String geefKraamhouder(int kraamnummer) {
		String answer = askString("%nGeef de naam van de kraamhouder voor kraam %d op: ".formatted(kraamnummer));
		while(answer.isBlank()) answer = askString("%nDe naam van de kraamhouder moet je opgeven...%nGeef de naam van de kraamhouder voor kraam %d op: ".formatted(kraamnummer));
		 return answer;
	}

	private int geefBreedteKraam(int kraamnummer) {
		int answer = askInt("%nGeef de breedte van kraam %d op: ".formatted(kraamnummer));
		while(2>answer||answer>10) answer = askInt("%nDe breedte moet tussen 2 en 10 meter liggen...%nGeef de breedte van kraam %d op: ".formatted(kraamnummer));
		return answer;
	}

	private int askInt(String string){
		System.out.printf(string);
		return sc.nextInt();
	}

	private String askString(String string){
		System.out.printf(string);
		// String temp = sc.next();
		// System.out.printf(temp);
		// return temp;
		return sc.next();
	}

	private double askDouble(String string){
		System.out.printf(string);
		return sc.nextDouble();
	}
}
