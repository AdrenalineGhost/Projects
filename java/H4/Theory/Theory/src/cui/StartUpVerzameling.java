package cui;

import domein.*;

public class StartUpVerzameling {
	public static final int ITTERATIONS	= 1000000;

	public static void main(String[] args) {
		new StartUpVerzameling().start();
	}

	private void start() {
		
		int som = 0;
		for (int i=1; i < ITTERATIONS; i++)
		{
			Verzameling verzameling = new Verzameling();
			som += verzameling.simuleerVerzamelingCompleet();
		}
		int gem = som / ITTERATIONS;
		System.out.printf("Je dient %d kauwgommen te kopen vooraleer je verzameling compleet is%n", gem);
	}

}
