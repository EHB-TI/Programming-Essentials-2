package oefening1;

public abstract class Dier implements Comparable<Dier> {
	private String naam;

	private static int aantal = 0;

	private final int code;

	private int leeftijd;

	public Dier(String naam) {
		this();
		this.naam = naam;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dier other = (Dier) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}

	public int compareTo(Dier d) 
	{
		if (d == null)
			return 1;

		if (naam == null) 
		{
			if (d.naam != null)
				return -1;
			else
				return 0;
		} else
			return naam.compareTo(d.getNaam());
	}

	public Dier() {
		code = Dier.aantal;
		Dier.aantal++;
		naam = "Jef";

	}

	/**
	 * @return de naam
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * @param naam
	 *            de naam om te setten
	 */
	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String toString() {
		String out = maakGeluid() + ", ik ben een "
				+ this.getClass().getSimpleName();
		if (this.naam != null)
			out += " en mijn naam is " + getNaam();
		return out;
	}

	public int getLeeftijd() {
		return leeftijd;
	}

	public void setLeeftijd(int leeftijd) {
		this.leeftijd = leeftijd;
	}

	public static int getAantal() {
		return aantal;
	}

	public int getCode() {
		return code;
	}

	public abstract String maakGeluid();
}
