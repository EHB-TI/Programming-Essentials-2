package oefening1;

/**
 * @author Ruben Dejonckheere
 *
 */
public abstract class Vis extends GewerveldDier implements OnderWaterLevend {

	private int aantalvinnen;

	public Vis() {
	}

	/**
	 * @param naam
	 * @param lengte
	 * @param type
	 */
	public Vis(String naam, int lengte, String type, int aantalvinnen) {
		super(naam, lengte, type);
		this.aantalvinnen = aantalvinnen;
	}

	/**
	 * @return the aantalvinnen
	 */
	public int getAantalvinnen() {
		return aantalvinnen;
	}

	/**
	 * @param aantalvinnen the aantalvinnen to set
	 */
	public void setAantalvinnen(int aantalvinnen) {
		this.aantalvinnen = aantalvinnen;
	}

	@Override
	public String maakGeluid() {
		// alle vissen maken hetzelfde geluid
		return "blub";
	}

	public int geefTijdOnderWater() {
		// alle vissen kunnen even lang onder water blijven
		return 0;
	}

}
