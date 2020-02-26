package oefening2;

/**
 * 
 * @author Ruben Dejonckheere
 *
 */
public class Adres {
	private String straatnaam;

	private short huisnummer;

	private String bus;

	private int postcode;

	private String woonplaats;

	public String getBus() {

		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	public short getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(short huisnummer) {
		this.huisnummer = huisnummer;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		if(postcode>=1000 && postcode<=9999 )
		this.postcode = postcode;
	}

	public String getStraatnaam() {
		return straatnaam;
	}

	public void setStraatnaam(String straatnaam) {
		this.straatnaam = straatnaam;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public Adres(String straatnaam, short huisnummer, String bus, int postcode,
			String woonplaats) {
		this.straatnaam = straatnaam;
		this.huisnummer = huisnummer;
		this.bus = bus;

		if (postcode > 999 && postcode < 10000)
			this.postcode = postcode;
		else
			this.postcode = 1000;
		this.woonplaats = woonplaats;

	}

}
