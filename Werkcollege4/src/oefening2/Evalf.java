package oefening2;

import java.util.ArrayList;

/**
 * Werkcollege 4, Oefening 2
 * @author Ruben Dejonckheere
 */
public abstract class Evalf {
	protected static Evalf instance = null;

	private ArrayList<Message> inhoud;

	protected Evalf() {
		inhoud = new ArrayList<Message>();
	}

	protected abstract Evalf getInstance();

	public boolean post(Message m) {
		if (m.getPersoon() instanceof Docent)
			return inhoud.add(m);
		else
			return false;
	}

	public boolean annulation(Message m) {
		return inhoud.remove(m);

	}

}