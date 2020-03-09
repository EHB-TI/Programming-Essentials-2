package oefening3;

import oefening2.Administrateur;
import oefening2.Docent;
import oefening2.Persoon;
import oefening2.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminProg {
	public static void main(String[] args) {
		ArrayList<Persoon> personen = new ArrayList<Persoon>();
		String invoer = null;
		try(Scanner s = new Scanner(System.in)) {
			do {

				Persoon persoon = null;
				System.out.println("Wil je een student, docent of administrateur invoeren? (S/D/A)");
				invoer = s.nextLine();

				// kan ook invoer.toUpperCase().equals("S")
				if (invoer.equalsIgnoreCase("S") || invoer.equalsIgnoreCase("D") || invoer.equalsIgnoreCase("A")) {
					System.out.println("Naam?");
					String naam = s.nextLine();
					System.out.println("Voornaam?");
					String voornaam = s.nextLine();
					System.out.println(invoer);
					if (invoer.equalsIgnoreCase("S"))
						persoon = new Student(voornaam, naam);

					if (invoer.equalsIgnoreCase("D"))
						persoon = new Docent(voornaam, naam);

					if (invoer.equalsIgnoreCase("A"))
						persoon = new Administrateur(voornaam, naam);

					personen.add(persoon);
				}

			} while (!invoer.equalsIgnoreCase(""));
		}
		System.out.println(Persoon.getAantalPersonen());
		for (int i = 0; i < personen.size(); i++) {
			System.out.println(personen.get(i));

		}

	}
}
