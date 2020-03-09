package oefening1;

/**
 * @author Ruben Dejonckheere
 *
 */
public abstract class Zoogdier extends GewerveldDier {

	public Zoogdier() {
		super();
	}

	private int lengtezwanger;

	/**
	 * @param naam
	 * @param lengte
	 * @param type
	 * @param lengtezwanger
	 */
	public Zoogdier(String naam, int lengte, String type, int lengtezwanger) {
		super(naam, lengte, type);
		this.lengtezwanger = lengtezwanger;
	}

	/**
	 * @return the lengtezwanger
	 */
	public int getLengtezwanger() {
		return lengtezwanger;
	}

	/**
	 * @param lengtezwanger the lengtezwanger to set
	 */
	public void setLengtezwanger(int lengtezwanger) {
		this.lengtezwanger = lengtezwanger;
	}

}
