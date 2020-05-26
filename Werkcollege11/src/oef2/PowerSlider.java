package oef2;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.plaf.SliderUI;


public class PowerSlider extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -36390255642461665L;
	private Thread thread;
	private int teller = 1;
	private JSlider slider;
	private volatile JTextField t;
	private volatile boolean check = true;
	
	public PowerSlider()
	{
		t = new JTextField("tekst");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		slider = new JSlider(1, 100,1);
		this.add(slider , BorderLayout.NORTH);
		this.add(t, BorderLayout.CENTER);
		JButton start = new JButton("start");
		
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				thread = new Thread(new Runnable(){

					@Override
					public void run() {
						check = true;
						while(check == true)
						{
							teller = teller + slider.getValue();
							t.setText(String.valueOf(teller));
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}	
					}
					
				});
				thread.start();	
			}
		});
		this.add(start, BorderLayout.WEST);
		
		JButton stop = new JButton("stop");
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				check = false;
				}
		});
		this.add(stop, BorderLayout.EAST);
		
		this.pack();
	}
	
	public static void main(String[] args) {
		new PowerSlider().setVisible(true);
	}
}
