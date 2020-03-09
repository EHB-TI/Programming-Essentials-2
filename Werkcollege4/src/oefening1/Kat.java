package oefening1;

/**
 * @author Ruben Dejonckheere
 */
public class Kat extends Zoogdier {

	public Kat() {
		super("", 0, "BEHAARD", 3);
	}

	/**
	 * @param naam
	 * @param lengte
	 * @param type
	 
	 */
	public Kat(String naam, int lengte, String type) {
		super(naam, lengte, type, 3);
	}

	@Override
	public String maakGeluid() {

		return "miauw";
	}

}
