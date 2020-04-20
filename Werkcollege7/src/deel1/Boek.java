package deel1;

import java.io.Serializable;

public abstract class Boek implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4271639537035599925L;

	private static int teller = 0;

	private final int code;

	private String titel;

	public Boek() {
		Boek.teller++;
		code = Boek.teller;
	}

	public abstract void geefISBN();

	public static int geefAantalBoeken() {
		return Boek.teller;
	}

	public String toString() {
		return "Code: " + code + " Type:" + this.getClass().getSimpleName();
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public int getCode() {
		return code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((titel == null) ? 0 : titel.hashCode());
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
		final Boek other = (Boek) obj;
		if (code != other.code)
			return false;
		if (titel == null) {
			if (other.titel != null)
				return false;
		} else if (!titel.equals(other.titel))
			return false;
		return true;
	}

}
