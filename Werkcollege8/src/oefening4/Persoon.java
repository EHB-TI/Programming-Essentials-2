package oefening4;

public class Persoon {
	private String naam;
	private String paswoord;
	private String adres;
	
	public Persoon() {
		super();
		
	}
	public Persoon(String naam, String paswoord) {
		super();
		this.naam = naam;
		this.paswoord = paswoord;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getPaswoord() {
		return paswoord;
	}
	public void setPaswoord(String paswoord) {
		this.paswoord = paswoord;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
		result = prime * result
				+ ((paswoord == null) ? 0 : paswoord.hashCode());
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
		final Persoon other = (Persoon) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		if (paswoord == null) {
			if (other.paswoord != null)
				return false;
		} else if (!paswoord.equals(other.paswoord))
			return false;
		return true;
	}
}
