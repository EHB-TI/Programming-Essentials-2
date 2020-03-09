package oefening1;

/**
 * @author Ruben Dejonckheere
 *
 */
public abstract class Spons extends OngewerveldDier implements OnderWaterLevend {

	/**
	 * @param naam
	 * @param kleur
	 */
	public Spons(String naam, Kleur kleur) {
		super(naam, kleur);
	}

	@Override
	public String maakGeluid() {
		// alle sponzen maken een vergelijkbaar geluid
		return "...";
	}

	public int geefTijdOnderWater() {
		// alle sponzen kunnen even lang onder water blijven
		return 0;
	}
}
