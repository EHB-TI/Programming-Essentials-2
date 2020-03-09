package oefening1;

/**
 * @author Ruben Dejonckheere
 */
public abstract class Holtedier extends OngewerveldDier implements
		OnderWaterLevend {

	private int diameter;

	/**
	 * @param naam
	 * @param kleur
	 */
	public Holtedier(String naam, Kleur kleur, int diam) {
		super(naam, kleur);
		this.diameter = diam;
	}

	/**
	 * @return the diameter
	 */
	public int getDiameter() {
		return diameter;
	}

	/**
	 * @param diameter the diameter to set
	 */
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	@Override
	public String maakGeluid() {
		// alle holtedieren maken een gelijkaardig geluid
		return "blubber";
	}

}
