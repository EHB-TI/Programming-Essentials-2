package oefening3;

public class Volmachthouder extends Persoon implements	Comparable<Volmachthouder> {

	public int compareTo(Volmachthouder o) {
		return this.getAchternaam().compareTo(o.getAchternaam());
	}

}
