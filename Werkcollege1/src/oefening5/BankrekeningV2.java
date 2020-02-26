package oefening5;

import java.math.BigDecimal;
import java.util.Scanner;

public class BankrekeningV2 
{
	private BigDecimal bedrag;

	public BankrekeningV2()
	{
		setBedrag(BigDecimal.valueOf(0));
	}

	public BankrekeningV2(BigDecimal bedrag)
	{
		this();
		if (bedrag.compareTo(BigDecimal.valueOf(0))>0)
			setBedrag(bedrag);
	}

	public BigDecimal getBedrag()
	{
		return bedrag;
	}

	private void setBedrag(BigDecimal bedrag)
	{
		this.bedrag = bedrag;
	}
	
	public void storten(BigDecimal bedrag)
	{
		if(bedrag.compareTo(BigDecimal.ZERO)>0)
			setBedrag(getBedrag().add(bedrag));
	}
	
	public boolean afhalen(BigDecimal bedrag)
	{
		if(bedrag.compareTo(BigDecimal.ZERO)<0)
			return false;
		if (getBedrag().subtract(bedrag).compareTo(BigDecimal.valueOf(-1000))>0)
		{
			setBedrag(getBedrag().min(bedrag));
			return true;
		}
		else
			return false;
	}
	
	public static void main(String[] strgs)
	{
		BankrekeningV2 rekening = new BankrekeningV2(BigDecimal.valueOf(100));
		double bedrag = 0;
		do
		{
			System.out.println("Bedrag afhalen: ");
			Scanner sc = new Scanner(System.in);
			bedrag = sc.nextDouble();
			System.out.println(rekening.afhalen(BigDecimal.valueOf(bedrag)));
		}
		while (bedrag != 0);
		System.out.println("Einde bankverrichtingen");
	}
}
