package cui;

import java.util.Scanner;

import domein.DomeinController;
import domein.Plant;
import dto.PlantDTO;

public class TuincentrumApplicatie 
{
	private final DomeinController dc;
	
	private Scanner sc = new Scanner(System.in);

	public TuincentrumApplicatie(DomeinController dc) {
		this.dc =dc;
	}

	public void start() 
	{
		int keuze;
		do{
		String[] menuKeuzes = {"Toon overzicht alle planten", "Toon overzicht voorradige planten","Voeg plant toe","Geef overzicht per hoogte",  "Geef verkoopwaarde", "Stoppen"};
		keuze = maakMenuKeuze(menuKeuzes,"Wat kies je? ");
		switch (keuze){
			case 0 -> geefPlantenInVoorraad(false);
			case 1 -> geefPlantenInVoorraad(true);
			case 2 -> voegPlantToe();
			case 3 -> maakOverzichtPlantenPerHoogte();
			default -> toonVerkoopWaarde();
		}
		} while (keuze != 5);
	}
	
	private int maakMenuKeuze(String[] keuzes, String hoofding) 
	{
		System.out.println(hoofding);
		for (int i = 0; i < keuzes.length; i++) System.out.println("%d\t%s".formatted(i,keuzes[i]));

		int in =-1;
		in = sc.nextInt();
		while(in<0||in>=keuzes.length){
			System.out.println("%d ligt niet tussen 0 en %d!".formatted(in, keuzes.length-1));
			in = sc.nextInt();
		}
		return in;
	}


	private void toonVerkoopWaarde(){
		System.out.println("De totale verkoopprijs indien alles verkocht wordt zal neerkomen op %.2f euro.".formatted(dc.bepaalWaardeVerkoop()));
	}


	private void voegPlantToe()
	{
		System.out.println("Geef in deze volgorde: naam, soortcode, hoogte, prijs(in euro) en hoeveelheid in vooraad:\n");
		dc.voegPlantToe(sc.next(), sc.next().charAt(0), sc.nextInt(), sc.nextDouble(), sc.nextInt());
	}
	
	
	// Bepaal aantal planten tss 0-80cm, 80cm-1m, groter dan 1 m
	private void maakOverzichtPlantenPerHoogte()
	{
		int[] inta = dc.maakOverzichtPlantenPerHoogte();
		System.out.println("%20s%20s%20s%n%20s%20s%20s".formatted("Kleiner dan 80cm","80-100 cm","Groter dan 1m",inta[0],inta[1],inta[2]));
	}
	
	private void geefPlantenInVoorraad(boolean inVoorraad)
	{
		PlantDTO[] planten = dc.geefAllePlanten(inVoorraad);
		for (PlantDTO plant : planten) {
			System.out.println(plant);
		}
	}
}
