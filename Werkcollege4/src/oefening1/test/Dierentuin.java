package oefening1.test;

/**
 * @author Ruben Dejonckheere
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import oefening1.Dier;
import oefening1.Dolfijn;
import oefening1.Gans;
import oefening1.GewerveldDier;
import oefening1.Kikker;
import oefening1.Kwal;
import oefening1.OnderWaterLevend;
import oefening1.OngewerveldDier;

import oefening1.Vis;
import oefening1.Vleermuis;
import oefening1.Vliegend;
import oefening1.Zalm;

public class Dierentuin {

	private ArrayList<OnderWaterLevend> aquarium = new ArrayList<OnderWaterLevend>();

	private ArrayList<Vliegend> kooi = new ArrayList<Vliegend>();
	
	public void plaatsInDierentuin(Dier d)
	{
		if(d instanceof Vliegend)
			kooi.add((Vliegend)d);
		else if(d instanceof OnderWaterLevend)
			aquarium.add((OnderWaterLevend)d);
	}
	public void plaatsInKooi(Vliegend v) {
		kooi.add(v);
	}

	public void gooiInAquarium(OnderWaterLevend o) {
		aquarium.add(o);
	}

	public Iterator<OnderWaterLevend> toonAquarium() {
		return aquarium.iterator();

	}

	public Iterator<Vliegend> toonKooi() {
		return kooi.iterator();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Dierentuin dierentuin = new Dierentuin();

		Dolfijn flipper = new Dolfijn("flipper", 10,
				"ONBEHAARD");
		Vis visje = new Zalm();
		Kikker kermit = new Kikker("Kermit", 2,
				"ONBEHAARD");
		Kwal kwal = new Kwal("Blubber", OngewerveldDier.Kleur.GEEL, 5);
		dierentuin.gooiInAquarium(visje);
		dierentuin.gooiInAquarium(flipper);
		dierentuin.gooiInAquarium(kermit);
		dierentuin.gooiInAquarium(kwal);

		Gans gans = new Gans();
		Vleermuis vleermuis = new Vleermuis();

		dierentuin.plaatsInKooi(gans);
		dierentuin.plaatsInKooi(vleermuis);

		System.out.println("Kooi:");
		Iterator<Vliegend> iter = dierentuin.toonKooi();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		System.out.println("Aquarium:");
		Iterator<OnderWaterLevend> iter2 = dierentuin.toonAquarium();
		while (iter2.hasNext()) {
			System.out.println(iter2.next());
		}

		ArrayList<Dier> dieren = new ArrayList<Dier>();
		dieren.add(gans);
		dieren.add(visje);
		dieren.add(flipper);
		dieren.add(kermit);
		dieren.add(vleermuis);
		System.out.println("niet gesorteerd");
		
		for(Dier dier : dieren)
			System.out.println(dier);

		Collections.sort(dieren);
		System.out.println("gesorteerd");
		for (int i = 0; i < dieren.size(); i++)
			System.out.println(dieren.get(i));

	}

}
