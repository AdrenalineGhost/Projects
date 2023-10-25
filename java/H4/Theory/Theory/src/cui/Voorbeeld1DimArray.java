package cui;

public class Voorbeeld1DimArray {

	public static void main(String[] args) {
		new Voorbeeld1DimArray().start();
	}

	private void start() {
		// declaratie
		int[] a;

		// creatie
		a = new int[5]; 

		// declaratie en creatie
		int[] b = new int[10]; 

		//Elk element van de array wordt 
		//automatisch geïnitialiseerd bij de creatie van de array.
		weergeven(a);
		weergeven(b);
		
		System.out.printf("lengte van array a is %d%n", a.length);
		System.out.printf("lengte van array b is %d%n", b.length);

		// Het eerste element van a opvullen met 5
		
		
		// Het laatste element van a opvullen met 20
		
		
		//weergeven(a);

		// Initialisatie van de array-elementen
		/*int[] array = { 32, 27, 64, 18, 95, 14, 90, 70, 60, 37 };
		weergeven(array);
		*/
		
		//Enhanced for
		//vb elementen van array doorlopen, som bepalen
		
		/*int som = 0;
		for(       ){
			som += getal;
		}
		System.out.println(som);
		*/
		
		//Enhanced for kan geen elementen van een array opvullen
		//Enhanced for kan enkel de array doorlopen (niet wijzigen)
		//WERKT NIET:
		
		/*
		System.out.println( );
		for (int element: a)
		{
			element = 2;
		}
		
		System.out.println( Arrays.toString(a));
		*/
		
		//Nodig voor de oefeningen: strings concateneren d.m.v.
		//String.format werkt zoals een printf
		
		double[] decGetallen = {2.4, 5.689, 8.45, 9.7};
		String zin = "";
		for (double element: decGetallen)
			zin += String.format("%.2f ", element);
		
		//System.out.println(zin);
		
	}
	

	private void weergeven(int[] array) {
		System.out.printf("%s%8s%n", "Index", "Value");

		for (int index = 0; index < array.length; index++) {
			System.out.printf("%5d%8d%n", index, array[index]);
		}
		System.out.println();
	}
	
}
