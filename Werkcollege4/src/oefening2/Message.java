package oefening2;

import java.util.Date;
import java.util.Calendar;

/**
 * Werkcollege 4, oefening 2 Een Message is de basisklasse van een bericht aan
 * de valven postdatum en uiterste datum worden voorzien, plus een manier om
 * berichten te kunnen lezen
 * @author Ruben Dejonckheere
 */
public abstract class Message {
	/**
	 * postdatum is final omdat deze slechts 1 maal mag worden vastgelegd
	 * namelijk bij de creatie
	 */
	private final Date postdatum;

	private Persoon persoon;

	protected Date uiterste;

	protected Message() {
		postdatum = Calendar.getInstance().getTime();
	}

	protected Message(Date arguiterste, Persoon issuer) {
		this();
		setPersoon(issuer);
		uiterste = arguiterste;
	}

	public Persoon getPersoon() {
		return persoon;
	}

	public void setPersoon(Persoon persoon) {
		this.persoon = persoon;
	}

	/**
	 * Deze methode mag niet de echte pointer naar het Date object van postdatum
	 * teruggeven, vandaar de clone
	 * 
	 * @return een kopie van de postdatum
	 */
	public Date getPostdatum() {
		return (Date) postdatum.clone();
	}

	/**
	 * We maken hier een Object return type van, omdat nu nog absoluut niet
	 * duidelijk is wat het return type van een message zou kunnen zijn.
	 * 
	 * @return de inhoud van het bericht, als java.lang.Object
	 */
	public abstract Object read();
}
