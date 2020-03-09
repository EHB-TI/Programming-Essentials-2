package oefening2;

/**
 * Klasse Student
 */
public class Student extends Persoon {
	private int studentennummer;

	private int specialisatie;

	protected int getSpecialisatie() {
		return specialisatie;
	}

	protected void setSpecialisatie(int specialisatie) {
		this.specialisatie = specialisatie;
	}

	public int getStudentennummer() {
		return studentennummer;
	}

	public void setStudentennummer(int studentennummer) {
		this.studentennummer = studentennummer;
	}

	public Student(String voornaam, String achternaam) {
		super(voornaam, achternaam);
		this.studentennummer = Persoon.getAantalPersonen();
	}

	public String toString() {
		return super.toString() + "\n\t\tstudentennummer: "
				+ getStudentennummer();
	}
}
