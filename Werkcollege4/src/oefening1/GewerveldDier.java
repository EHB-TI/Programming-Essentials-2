package oefening1;

public abstract class GewerveldDier extends Dier {

	private int lengte;

	private String huidtype;

	public GewerveldDier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param naam
	 */
	public GewerveldDier(String naam, int lengte, String type) {
		super(naam);
		this.lengte = lengte;
		this.huidtype = type;
	}

	/**
	 * @return the huidtype
	 */
	public String getHuidtype() {
		return huidtype;
	}

	/**
	 * @param huidtype the huidtype to set
	 */
	public void setHuidtype(String huidtype) {
		this.huidtype = huidtype;
	}

	/**
	 * @return the lengte
	 */
	public int getLengte() {
		return lengte;
	}

	/**
	 * @param lengte the lengte to set
	 */
	public void setLengte(int lengte) {
		this.lengte = lengte;
	}
}
