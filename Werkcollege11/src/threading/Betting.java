package threading;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;

public class Betting extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7714493877247931139L;
	
	private boolean check = false;
	private JSlider horse1;
	private JSlider horse2;
	private JSlider horse3;
	private int left = 3;
	private int teller = 0;

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public Betting()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getMainPanel());
		this.pack();
	}

	public JPanel getMainPanel()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10 ));
		GridLayout layout = new GridLayout(2, 1);
		mainPanel.setLayout(layout);
		mainPanel.add(getHorsePanel());
		horse1.setEnabled(false);
		horse1.setName("Horse 1");
		horse2.setEnabled(false);
		horse2.setName("Horse 2");
		horse3.setEnabled(false);
		horse3.setName("Horse 3");
		JButton butn = new JButton("start");
		butn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(check == false)
				{
					check = true;
					left = 3;
					horse1.setValue(0);
					horse2.setValue(0);
					horse3.setValue(0);
					
					Thread t = new Thread(new Runnable() {
						
						@Override
						public void run() {
							HorseGameThread h1 = new HorseGameThread(Betting.this, horse1);
							HorseGameThread h2 = new HorseGameThread(Betting.this, horse2);
							HorseGameThread h3 = new HorseGameThread(Betting.this ,horse3);
							Thread t1 = new Thread(h1);
							Thread t2 = new Thread(h2);
							Thread t3 = new Thread(h3);
							t1.start();
							t2.start();
							t3.start();
							
							try {
								t1.join();
								t2.join();
								t3.join();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							Betting.this.check = false;
						}
					});				
					t.start();
				}

			}
		});
		mainPanel.add(butn);
		return mainPanel;
	}

	public JPanel getHorsePanel()
	{
		JPanel horsePanel = new JPanel();
		horsePanel.setBackground(Color.WHITE);
		GridLayout layout = new GridLayout(3, 2);
		horsePanel.setLayout(layout);
		horse1 = new JSlider(JSlider.HORIZONTAL, 0, 6437, 0);
		horse1.setUI(new CustomSliderUI(horse1));
		horse1.setBackground(Color.WHITE);
		horsePanel.add(new JLabel("Horse 1: "));
		horsePanel.add(horse1);
		horse2 = new JSlider(JSlider.HORIZONTAL, 0, 6437, 0);
		horse2.setBackground(Color.WHITE);
		horse2.setUI(new CustomSliderUI(horse2));
		horsePanel.add(new JLabel("Horse 2: "));
		horsePanel.add(horse2);
		horse3 = new JSlider(JSlider.HORIZONTAL, 0, 6437, 0);
		horse3.setBackground(Color.WHITE);
		horsePanel.add(new JLabel("Horse 3: "));
		horse3.setUI(new CustomSliderUI(horse3));
		horsePanel.add(horse3);
		return horsePanel;
	}

	public synchronized void runHorse(final JSlider slider)
	{
		//System.out.println("stop2");
		try {
			int rand = new Random().nextInt(500)+1;
			if (slider.getValue() + rand >=6437)
			{
				slider.setValue(6437);

				left--;
				teller--;
				if (left == 2 )
					new Thread()
						{
							@Override
								public void run() {
									JOptionPane.showMessageDialog(Betting.this, slider.getName()+ " Has won the race!" );
								}

						}.start();
			}
			else
				slider.setValue(slider.getValue()+ rand);

			teller++;
			if (teller !=left)
			{
				//System.out.println("Slider: " + teller);
				wait();
			}
			else
			{
				//System.out.println("Slider: " + teller);
				teller = 0;
				notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Betting().setVisible(true);

	}
}
