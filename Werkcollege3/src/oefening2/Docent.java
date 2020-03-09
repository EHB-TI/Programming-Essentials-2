package oefening2;

import java.util.ArrayList;

public class Docent extends Personeel {

	private int specialisatie;

	private ArrayList<Student> studenten = new ArrayList<Student>();

	public void teaches(Student student) {
		studenten.add(student);
	}

	public ArrayList<Student> getStudenten() {
		return studenten;
	}

	public void setStudenten(ArrayList<Student> studenten) {
		this.studenten = studenten;
	}

	public Docent(String voornaam, String achternaam) {
		super(voornaam, achternaam);
	}

	public int getSpecialisatie() {
		return specialisatie;
	}

	public void setSpecialisatie(int specialisatie) {
		this.specialisatie = specialisatie;
	}

}
