package voorbeeld;

/**
 * @author Ruben Dejonckheere
 * Klasse voor een kat met naam, vachtkleur, gewicht en leeftijd.
 */
public class Kat {

	/**
	 * Mogelijke kleuren van vacht
	 */

	public enum Kleur {
		ZWART, WIT, GRIJS, ROS
	};

	/**
	 * Naam van de kat
	 */
	private String naam;

	/**
	 * Leeftijd in jaren
	 */
	private int leeftijd;

	/**
	 * Kleur van kat z'n vacht
	 */
	private Kleur kleur;

	/**
	 * Gewicht van kat in kg
	 */
	private int gewicht;

	public Kat() {
		this.naam = "Tijger";
		this.leeftijd = 5;
		this.kleur = Kleur.GRIJS;
		this.gewicht = 4;
	}

	/**
	 * @param naam Naam van kat
	 */
	public Kat(String naam) {
		this();
		this.naam = naam;

	}

	/**
	 * @param naam Naam van kat
	 * @param leeftijd Leeftijd in jaren
	 */
	public Kat(String naam, int leeftijd) {
		this(naam);
		this.leeftijd = leeftijd;
	}

	/**
	 * @param naam Naam van kat
	 * @param leeftijd Leeftijd in jaren
	 * @param kleur Vachtkleur
	 * @param gewicht Gewicht van kat in kg
	 */
	public Kat(String naam, int leeftijd, Kleur kleur, int gewicht) {
		this(naam, leeftijd);
		this.kleur = kleur;
		this.gewicht = gewicht;
	}

	/**
	 * @return Vachtkleur
	 */
	public Kleur getKleur() {
		return kleur;
	}

	/**
	 * @param kleur Nieuwe vachtkleur
	 */
	public void setKleur(Kleur kleur) {
		this.kleur = kleur;
	}

	/**
	 * @return Leeftijd in jaren
	 */
	public int getLeeftijd() {
		return leeftijd;
	}

	/**
	 * @param leeftijd Nieuwe leeftijd in jaren
	 */
	public void setLeeftijd(int leeftijd) {
		this.leeftijd = leeftijd;
	}

	/**
	 * @return Naam van kat
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * @param naam Nieuwe naam van kat
	 */
	public void setNaam(String naam) {
		this.naam = naam;
	}

	/**
	 * @return Gewicht van kat in kg
	 */
	public int getGewicht() {
		return gewicht;
	}

	/**
	 * @param gewicht Nieuw gewicht van kat in kg
	 */
	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}

	/**
	 * Toont informatie van kat
	 */
	public String toString() {
		String info = getNaam() + " is " + getKleur().toString().toLowerCase()
				+ ".\n";
		info += naam + " is " + leeftijd + " jaar oud.\n";

		if (getGewicht() > 6)
			info += naam + " weegt te veel.";
		else
			info += naam + " weegt " + getGewicht() + " kilo.";

		return info + "\n";
	}
}
