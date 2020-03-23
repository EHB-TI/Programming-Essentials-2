package oefening4;

import java.util.Random;

public class Player {

	public Player() {
		System.out.println(this + " speelt mee.");

	}

	public void go() throws BallException {

		if (new Random().nextBoolean()) {
			Player player = new Player();
			try {
				player.go();
			} catch (HeavyBallException ex) {
				System.out.println("zware bal kan niet opgevangen door " + this
						+ " !");
				throw new HeavyBallException();
			} catch (BallException e) {
				System.out.println("bal opgevangen door " + this + " !");
			}

		} else {
			if (new Random().nextBoolean()) {
				System.out.println(this + " gooit bal !");
				throw new BallException();
			} else {
				System.out.println(this + " gooit zware bal !");
				throw new HeavyBallException();
			}
		}
	}
}
