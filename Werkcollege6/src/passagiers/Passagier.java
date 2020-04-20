package passagiers;

import java.time.LocalDate;

public abstract class Passagier implements Comparable<Passagier>{
	private String naam;

	private LocalDate opstartdatum;

	public Passagier() {
		opstartdatum = LocalDate.now();
	}

	public Passagier(String naam) {
		this();
		this.naam = naam;
	}

	public String toString() {
		return naam + " " + this.getClass().getSimpleName();
	}

	public abstract void geefSpecifiekeInfo();

	public LocalDate getOpstartdatum() {
		return opstartdatum;
	}

	public int compareTo(Passagier o) {
		return this.naam.compareTo(o.naam);
	}
	

}
