package oefening1;

import java.math.BigDecimal;

public class Cirkel {
	private double straal = 0;
	private String kleur = "wit";

	public double getStraal() {
		return straal;
	}

	public void setStraal(double straal) {
		if(straal>=0)
			this.straal = straal;
	}

	public Cirkel(double straal) {
		this.straal = straal;
	}

	public Cirkel(String kleur) {
		this.kleur = kleur;
	}

	public Cirkel(float straal, String kleur) {
		this.straal = straal;
		this.kleur = kleur;
	}

	public Cirkel(Cirkel cirkel) {
		this.straal = cirkel.getStraal();
		this.kleur = cirkel.getKleur();
	}

	public String toString() {
		return "Kleur: " + getKleur() + ", Straal: " + getStraal();
	}

	public double geefOmtrek() {
		return (2 * Math.PI * getStraal());
	}

	public double geefOppervlakte() {
		return (Math.PI * getStraal() * getStraal());
	}

	public String getKleur() {
		return kleur;
	}

	public void setKleur(String kleur) {
		kleur = kleur.toLowerCase();
		if(kleur.equals("wit") || kleur.equals("geel")|| kleur.equals("zwart") || kleur.equals("groen")  )
		this.kleur = kleur;
	}

	public static void main(String[] strgs) {
		Cirkel cirkel = new Cirkel(4);
		System.out.println(cirkel);

		System.out.println("omtrek: " + cirkel.geefOmtrek());

		System.out.println("oppervlakte: " + cirkel.geefOppervlakte());
		System.out.println("afgeronde oppervlakte: " + String.format("%.2f", cirkel.geefOppervlakte()));
	}
}
