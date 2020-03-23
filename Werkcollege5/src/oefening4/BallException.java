package oefening4;

public class BallException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5155538709397935940L;

	public BallException(String message) {
		super(message);
	}

	public BallException() {
		super("Bal!");
	}

}
