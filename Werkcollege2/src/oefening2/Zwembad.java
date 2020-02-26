package oefening2;

import oefening1.Cirkel;
import java.util.Scanner;

public class Zwembad {
	private Cirkel binnenCirkel;

	private Cirkel buitenCirkel;

	private double eenheidsprijsWeg;

	private double eenheidsprijsOmheining;

	public Cirkel getBinnenCirkel() {
		return binnenCirkel;
	}

	public void setBinnenCirkel(Cirkel binnenCirkel) {
		this.binnenCirkel = binnenCirkel;
	}

	public Cirkel getBuitenCirkel() {
		return buitenCirkel;
	}

	public void setBuitenCirkel(Cirkel buitenCirkel) {
		this.buitenCirkel = buitenCirkel;
	}

	public double getEenheidsprijsOmheining() {
		return eenheidsprijsOmheining;
	}

	public void setEenheidsprijsOmheining(double eenheidsprijsOmheining) {
		this.eenheidsprijsOmheining = eenheidsprijsOmheining;
	}

	public double getEenheidsprijsWeg() {
		return eenheidsprijsWeg;
	}

	public void setEenheidsprijsWeg(double eenheidsprijsWeg) {
		this.eenheidsprijsWeg = eenheidsprijsWeg;
	}

	public Zwembad() {
		this.eenheidsprijsOmheining = 5;
		this.eenheidsprijsWeg = 4;
	}

	public double geefKostenWeg() {
		return (buitenCirkel.geefOppervlakte() - binnenCirkel.geefOppervlakte())* getEenheidsprijsWeg();
	}

	public double geefKostenOmheining() {
		return (buitenCirkel.geefOmtrek() * getEenheidsprijsOmheining());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Zwembad mijnZwembad = new Zwembad();

		Scanner sc = new Scanner(System.in);
		System.out.println("Geef waarde buitencirkel: ");
		double invoer = sc.nextDouble();
		Cirkel buitenCirkel = new Cirkel(invoer);
		Cirkel binnenCirkel = new Cirkel(3);
		mijnZwembad.setBinnenCirkel(binnenCirkel);
		mijnZwembad.setBuitenCirkel(buitenCirkel);

		System.out.println("Prijs voor de aanleg van de weg: "
				+ mijnZwembad.geefKostenWeg());
		System.out.println("Prijs voor de omheining: "
				+ mijnZwembad.geefKostenOmheining());
		System.out.println("Totaalprijs: "
				+ (mijnZwembad.geefKostenWeg() + mijnZwembad
						.geefKostenOmheining()));

	}

}
