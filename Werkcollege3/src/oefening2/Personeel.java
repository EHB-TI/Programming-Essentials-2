package oefening2;

public class Personeel extends Persoon {
	private Kantoor kantoor;

	public Kantoor getKantoor() {
		return kantoor;
	}

	public void setKantoor(Kantoor kantoor) {
		this.kantoor = kantoor;
	}

	public Personeel(String voornaam, String achternaam) {
		super(voornaam, achternaam);
	}

	public Personeel() {
		super();
	}
}
