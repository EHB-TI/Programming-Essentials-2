package oefening1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class myActionListener implements ActionListener {

	private RekenenMetMenu rm;

	public myActionListener(RekenenMetMenu rm)
	{
		this.rm = rm;
	}
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();

		switch(actionCommand)
		{
			case "Som":
				calculate('+');
				break;
			case "Verschil":
				calculate('-');
				break;
			case "Maal":
				calculate('*');
				break;
			case "Deel":
				calculate('/');
				break;
			case "Sluit":
				rm.getFrame().dispose();
				break;
		}
	}
	
	private void calculate(char operator) {
		String g1 = rm.getGetal1().getText().trim();
		String g2 = rm.getGetal2().getText().trim();

		if(g1.isBlank() || g2.isBlank())
		{
			JOptionPane.showMessageDialog(rm.getFrame(), "Gelieve beide tekstvelden in te vullen.");
		}
		else {

			int num1 = (Integer.parseInt(g1));
			int num2 = (Integer.parseInt(g2));
			int result = 0;

			switch (operator) {
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
			}

			rm.getResultaat().setText(String.valueOf(result));
		}
	}

}
