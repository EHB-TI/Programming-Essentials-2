package oefening5;

import java.util.Scanner;

public class Bankrekening
{
	private double bedrag;

	public Bankrekening()
	{
		setBedrag(0);
	}

	public Bankrekening(double bedrag)
	{
		this();
		if (bedrag > 0)
			setBedrag(bedrag);
	}

	public double getBedrag()
	{
		return bedrag;
	}

	private void setBedrag(double bedrag)
	{
		this.bedrag = bedrag;
	}
	
	public void storten(double bedrag)
	{
		setBedrag(getBedrag()+bedrag);
	}
	
	public boolean afhalen(double bedrag)
	{
		if (getBedrag()-bedrag>=-1000)
		{
			setBedrag(getBedrag()-bedrag);
			return true;
		}
		else
			return false;
	}
	
	public static void main(String[] strgs)
	{
		Bankrekening rekening = new Bankrekening(100);
		double bedrag = 0;
		do
		{
			System.out.println("Bedrag afhalen: ");
			Scanner sc = new Scanner(System.in);
			bedrag = sc.nextDouble();
			System.out.println(rekening.afhalen(bedrag));
			
		}
		while (bedrag != 0);
		System.out.println("Einde bankverrichtingen");
	}
}
