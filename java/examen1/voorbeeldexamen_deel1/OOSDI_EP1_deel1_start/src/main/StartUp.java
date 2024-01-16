package main;

import cui.TuincentrumApplicatie;
import domein.DomeinController;

public class StartUp {

	public static void main(String[] args) 
	{
		new TuincentrumApplicatie(new DomeinController()).start();
	}




}
