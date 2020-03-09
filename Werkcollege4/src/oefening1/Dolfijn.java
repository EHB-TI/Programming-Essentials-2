package oefening1;

public class Dolfijn extends Zoogdier implements OnderWaterLevend {

	public Dolfijn(String naam, int lengte, String type) {
		super(naam, lengte, type, 4);
	}

	@Override
	public String maakGeluid() {
		return "kwek";
	}

	public int geefTijdOnderWater() {
		// TODO Auto-generated method stub
		return 0;
	}

}
