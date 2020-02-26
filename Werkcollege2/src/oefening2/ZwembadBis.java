package oefening2;

import oefening1.Cirkel;

public class ZwembadBis {
	private Cirkel binnenCirkel;

	private Cirkel buitenCirkel;

	private double eenheidsprijsWeg;

	private double eenheidsprijsOmheining;

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

	public ZwembadBis() {
		this.eenheidsprijsOmheining = 5;
		this.eenheidsprijsWeg = 4;
	}

	public ZwembadBis(double straalZwembad, double breedtePad) {
		this();
		binnenCirkel = new Cirkel(straalZwembad);
		buitenCirkel = new Cirkel(straalZwembad + breedtePad);
	}

	public double geefKostenWeg() {
		return (buitenCirkel.geefOppervlakte() - binnenCirkel.geefOppervlakte())
				* getEenheidsprijsWeg();
	}

	public double geefKostenOmheining() {
		return (buitenCirkel.geefOmtrek() * getEenheidsprijsOmheining());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZwembadBis mijnZwembad = new ZwembadBis(5, 2);

		System.out.println("Prijs voor de aanleg van de weg: "
				+ mijnZwembad.geefKostenWeg());
		System.out.println("Prijs voor de omheining: "
				+ mijnZwembad.geefKostenOmheining());
		System.out.println("Totaalprijs: "
				+ (mijnZwembad.geefKostenWeg() + mijnZwembad
						.geefKostenOmheining()));

	}

}
