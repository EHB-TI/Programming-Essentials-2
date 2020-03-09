package oefening2;

/**
 * Klasse Persoon met attributen <b>voornaam, achternaam, telefoon, adres</b>.
 * 
 * @author Ruben Dejonckheere
 * @version 0.3
 * 
 */
public class Persoon {

	private String voornaam;

	private String achternaam;

	private String telefoon;

	private Adres adres;

	private static int aantalPersonen = 0;

	/**
	 * @since 0.2
	 * @return aantal instanties van Persoon
	 */
	public static int getAantalPersonen() {
		return aantalPersonen;
	}

	protected static void setAantalPersonen(int aantalPersonen) {
		Persoon.aantalPersonen = aantalPersonen;
	}

	public Persoon() {
		aantalPersonen += 1;

	}

	public Persoon(String voornaam, String achternaam) {
		this();
		this.voornaam = voornaam;
		this.achternaam = achternaam;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public String getTelefoon() {
		return telefoon;
	}

	public void setTelefoon(String telefoon) {
		this.telefoon = telefoon;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String toString() {
		return getClass().getSimpleName()+ ": " + getVoornaam() + " " + getAchternaam();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((achternaam == null) ? 0 : achternaam.hashCode());
		result = prime * result
				+ ((voornaam == null) ? 0 : voornaam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persoon other = (Persoon) obj;
		if (achternaam == null) {
			if (other.achternaam != null)
				return false;
		} else if (!achternaam.equals(other.achternaam))
			return false;
		if (voornaam == null) {
			if (other.voornaam != null)
				return false;
		} else if (!voornaam.equals(other.voornaam))
			return false;
		return true;
	}

	

}
