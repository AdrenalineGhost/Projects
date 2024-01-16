package domein;
import java.lang.IllegalArgumentException;

public class Plant 
{

	final private String naam;
	private char soortCode;
	private int hoogteInCm;
	private int aantalInVoorraad;
	private double prijsInEuro;

	private final static int MIN_HOOGTE =0;
	private final static int MAX_HOOGTE =400;
	private final static int BTW_PRECENTAGE =21;

	public Plant(String naam, char soortCode, int hoogteInCm, double prijsInEuro, int aantalInVoorraad){
		controleerNaam(naam);
		this.naam = naam; setSoortCode(soortCode); setHoogteInCm(hoogteInCm); setPrijsInEuro(prijsInEuro); setAantalInVoorraad(aantalInVoorraad);
	}

	public Plant(String naam, char soortCode){
		this(naam, soortCode, 100, 0, 0);
	}


	public String getNaam() {
		return naam;
	}

	public char getSoortCode() {
		return soortCode;
	}

	public int getHoogteInCm() {
		return hoogteInCm;
	}

	public int getAantalInVoorraad() {
		return aantalInVoorraad;
	}

	public double getPrijsInEuro() {
		return prijsInEuro;
	}

	private void setSoortCode(char soortCode) {
		if (soortCode != 'A' &&soortCode != 'B' &&soortCode != 'C') throw new IllegalArgumentException("%s is niet gelijk aan A, B of C.".formatted(soortCode));
		this.soortCode = soortCode;
	}

	private void setHoogteInCm(int hoogteInCm) {
		if (hoogteInCm<=MIN_HOOGTE||hoogteInCm>MAX_HOOGTE) throw new IllegalArgumentException("Hoogte ligt niet tussen [%d , %d].".formatted(MIN_HOOGTE,MAX_HOOGTE));
		this.hoogteInCm = hoogteInCm;
	}

	public void setAantalInVoorraad(int aantalInVoorraad) {
		if (aantalInVoorraad<0) throw new IllegalArgumentException("aantalInVoorraad moet positief zijn.");
		this.aantalInVoorraad = aantalInVoorraad;
	}

	public void setPrijsInEuro(double prijsInEuro) {
		this.prijsInEuro = prijsInEuro;
	}

	public double berekenVerkoopprijs(){
		return getPrijsInEuro() * (BTW_PRECENTAGE + 100)/100;
	}

	private void controleerNaam(String naam){
		if(naam == null || naam.isBlank()) throw new IllegalArgumentException("Naam mag niet blanco zijn.");
	}
	
}
