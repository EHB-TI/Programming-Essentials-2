package oefening1;

import java.io.Serializable;

public class Product implements Comparable<Product>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4304813112030522704L;

	private String naam;

	private int nummer;

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public int compareTo(Product o) {
		return Integer.compare(this.nummer, o.nummer);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nummer;
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
		final Product other = (Product) obj;
		if (nummer != other.nummer)
			return false;
		return true;
	}

}
