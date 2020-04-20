package deel2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeSet;

import deel1.Boek;


public class Klant implements Comparable<Klant>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7411351407665609281L;

	private String naam;

	private HashMap<Boek, Date> boodschappenmand = new HashMap<Boek, Date>();

	public static TreeSet<Klant> klantenlijst = new TreeSet<Klant>();

	public Klant(String naam) {
		super();
		this.naam = naam;
		klantenlijst.add(this);
	}

	public int compareTo(Klant o) {
		return this.naam.compareTo(o.naam);
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public static TreeSet<Klant> getKlantenlijst() {
		return klantenlijst;
	}

	public void verwijderenUitMandje(Boek boek) throws BoekNietInMandje {
		if (boodschappenmand.containsKey(boek))
			boodschappenmand.remove(boek);
		else
			throw new BoekNietInMandje();
	}

	public void bewaar() {
		try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(naam + ".obj")) ) {
			outputStream.writeObject(this);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.hashCode());
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
		final Klant other = (Klant) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		return true;
	}

}
