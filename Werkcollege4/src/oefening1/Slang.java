package oefening1;

/**
 * @author Ruben Dejonckheere
 *
 */
public class Slang extends Reptiel {

	/**
	 * @param naam
	 * @param lengte
	 * @param type
	 */
	public Slang(String naam, int lengte, String type) {
		super(naam, lengte, type);
	}

	@Override
	public String maakGeluid() {
		return "ssss";
	}

}
