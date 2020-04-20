package oefening1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Boodschappenmand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6646398467440790234L;

	private ArrayList<Product> producten = new ArrayList<Product>();

	public ArrayList<Product> geefProductenGesorteerdOpNaam() {
		Collections.sort(producten, new SorterenOpNaam());
		return producten;
	}

	public TreeSet<Product> geefGesorteerdeUniekeProducten() {
		return new TreeSet<Product>(producten);
	}

	public ArrayList<Product> geefProductenGesorteerdOpNummer() {
		//kan ook met een kopie
		Collections.sort(producten);
		return producten;
	}

	public void bewaar() {
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("bestandje.bin"))) {
			objectOutputStream.writeObject(this);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
