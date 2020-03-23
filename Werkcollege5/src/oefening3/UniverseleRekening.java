package oefening3;

import java.util.ArrayList;
import java.util.Collections;

public class UniverseleRekening {
	private ArrayList<Volmachthouder> volmachthouders;

	public UniverseleRekening() {
		volmachthouders = new ArrayList<Volmachthouder>();
	}

	public boolean toevoegenVolmacht(Volmachthouder volmachthouder) {

		return volmachthouders.add(volmachthouder);
	}

	public boolean verwijderenVolmacht(Volmachthouder volmachthouder)
			throws PersoonHeeftGeenVolmacht {
		if (volmachthouders.contains(volmachthouder))
			return volmachthouders.remove(volmachthouder);
		else
			throw new PersoonHeeftGeenVolmacht();
	}

	public boolean controleerVolmacht(Volmachthouder volmachthouder)
			throws PersoonHeeftGeenVolmacht {
		if (volmachthouders.contains(volmachthouder))
			return true;
		else
			throw new PersoonHeeftGeenVolmacht();
	}

	public ArrayList<Volmachthouder> geefVolmachthouders() {
		Collections.sort(volmachthouders);
		return volmachthouders;
	}

}
