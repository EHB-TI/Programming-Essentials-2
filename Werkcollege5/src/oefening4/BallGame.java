package oefening4;

public class BallGame {
	public void play() {
		Player p1 = new Player();
		Player p2 = new Player();

		try {
			p1.go();
			p2.go();
		} catch (HeavyBallException e) {
			System.out.println("Heavy Ball on ground!");
		} catch (BallException e) {
			System.out.println("Ball on ground!");
		}

	}

	public static void main(String[] args) {
		BallGame game = new BallGame();
		game.play();

	}
}
