package oefening4;


import java.util.HashSet;


public class Gebruikers {
	private HashSet<Persoon> lijst = new HashSet<Persoon>();
	
	public boolean controle(Persoon p){
		if (lijst.contains(p))
			return true;
		else
			return false;
	}
	
	public boolean toevoegen(Persoon p)
	{
		return lijst.add(p);
	}
	
}
