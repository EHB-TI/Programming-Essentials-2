package threading;

import javax.swing.JSlider;

public class HorseGameThread implements Runnable{
	
	private JSlider horse;
	private Betting bet;
	
	public HorseGameThread(Betting bet, JSlider horse)
	{
		this.bet = bet;
		this.horse = horse;
	}
	
	@Override
	public void run() {
		while(horse.getValue()!=6437)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			bet.runHorse(horse);
		}
		//bet.setLeft(bet.getLeft()-1);
	}

}
