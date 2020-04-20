package vluchten;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.TreeMap;

import passagiers.Passagier;


public class Vlucht {
	private final double identificatienummer;

	private TreeMap<Passagier, String> passagiers;

	public Vlucht(double identificatienummer) {
		super();
		this.identificatienummer = identificatienummer;
		passagiers = new TreeMap<Passagier, String>();
	}

	public double getIdentificatienummer() {
		return identificatienummer;
	}

	public void boarding(Passagier p, String plaats)
			throws PassagierReedsAanwezig {
		if (passagiers.put(p, plaats) != null)
			throw new PassagierReedsAanwezig();
	}

	public boolean save() {

		boolean succes = false;
		try(PrintWriter printWriter = new PrintWriter(identificatienummer + ".csv")) {
			Iterator<Passagier> iter = passagiers.keySet().iterator();
			while (iter.hasNext()) {
				Passagier p = iter.next();
				printWriter.println(p + passagiers.get(p));
			}
			succes = true;
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return succes;
	}
	
	public Passagier zoek(Passagier p) throws OnbekendePassagier
	{
		if (passagiers.containsKey(p))
			return p;
		else
			throw new OnbekendePassagier();
	}

}
