package oefening1;

/**
 * @author Ruben Dejonckheere
 *
 */
public abstract class OngewerveldDier extends Dier {

	public enum Kleur {
		ZWART, GEEL, ROOD
	};

	private Kleur kleur;

	public OngewerveldDier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param naam
	 */
	public OngewerveldDier(String naam, Kleur kleur) {
		super(naam);
		this.kleur = kleur;
	}

	public Kleur getKleur() {
		return kleur;
	}

	public void setKleur(Kleur kleur) {
		this.kleur = kleur;
	}

}
