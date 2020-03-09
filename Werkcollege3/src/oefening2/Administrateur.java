package oefening2;

public class Administrateur extends Personeel {

	public Administrateur(String voornaam, String naam) {
		super(voornaam, naam);
	}
	
	// voorbeeld instanceof
	protected boolean wijzigBureau(Persoon persoon, Kantoor kantoor) {
		if (persoon instanceof Personeel) {
			((Personeel) persoon).setKantoor(kantoor);
			return true;
		} else
			return false;
	}

	protected void wijzigBureau(Personeel personeel, Kantoor kantoor) {
		personeel.setKantoor(kantoor);
	}
}
