package vluchten;

public class PassagierReedsAanwezig extends Exception {

	private static final long serialVersionUID = -1279115024420036427L;

	public PassagierReedsAanwezig() {
		super("Passagier is reeds aanwezig op deze vlucht!");
	
	}

}
