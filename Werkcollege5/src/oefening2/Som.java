package oefening2;

import java.util.Scanner;

public class Som {
	private int getal1;
	private int getal2;
	
	private final int BOVENLOOP = 100;
	private final int ONDERLOOP = 0;
	
	public Som(int getal1, int getal2)
	{
		setGetal1(getal1);
		setGetal2(getal2);
	}
	public Som() {
		setGetal1(0);
		setGetal2(0);
	}
	public int geefSom() throws Bovenloop, Onderloop
	{ 
		if (getGetal1()+getGetal2() > BOVENLOOP)
			throw new Bovenloop();
		if (getGetal2()+getGetal2() < ONDERLOOP)
			throw new Onderloop();
		return getGetal1()+getGetal2();
	}
	public int getGetal1() {
		return getal1;
	}
	public void setGetal1(int getal1) {
		this.getal1 = getal1;
	}
	public int getGetal2() {
		return getal2;
	}
	public void setGetal2(int getal2) {
		this.getal2 = getal2;
	}
	
	public static void main(String[] args) 
	{
		Som som = new Som();
		Scanner s = new Scanner(System.in);
		System.out.println("Getal1: ");
		som.setGetal1(s.nextInt());
		System.out.println("Getal2: ");
		som.setGetal2(s.nextInt());
		try {
			System.out.println(som.geefSom());
		} catch (Bovenloop e) {
			System.out.println("Bovenloop!");
		} catch (Onderloop e) {
			System.out.println("Onderloop!");
		}
	}
}
