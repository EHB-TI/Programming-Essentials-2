package oefening1;

/**
 * @author Ruben Dejonckheere
 */
public class Kikker extends Amfibie {

	/**
	 * @param naam
	 * @param lengte
	 * @param type
	 */
	public Kikker(String naam, int lengte, String type) {
		super(naam, lengte, type);

	}

	@Override
	public String maakGeluid() {

		return "kwak";
	}

	public int geefTijdOnderWater() {
		// TODO Auto-generated method stub
		return 0;
	}

}
