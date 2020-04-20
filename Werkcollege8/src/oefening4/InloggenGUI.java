package oefening4;

import java.awt.BorderLayout;

import java.awt.Container;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InloggenGUI {
	private JFrame frame;

	private JPanel panel1, panel2, smallPanel1, smallPanel2;

	private JButton okButton, cancelButton;

	private JTextField textField;

	private JPasswordField passwordField;

	private Gebruikers gebruikers;

	public JFrame getFrame() {
		if (frame == null) {
			frame = new JFrame("Inloggen");
			Container c = frame.getContentPane();
			c.setLayout(new BorderLayout());
			c.add(getPanel1(), BorderLayout.NORTH);
			c.add(getPanel2(), BorderLayout.SOUTH);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setResizable(false);
		}
		return frame;
	}

	public JPanel getPanel1() {
		if (panel1 == null) {
			panel1 = new JPanel();
			panel1.setLayout(new GridLayout(2, 1));
			panel1.add(getSmallPanel1());
			panel1.add(getSmallPanel2());
		}
		return panel1;
	}

	public JPanel getPanel2() {
		if (panel2 == null) {
			panel2 = new JPanel();
			panel2.setLayout(new GridLayout(1, 2));
			panel2.add(getOkButton());
			panel2.add(getCancelButton());
		}
		return panel2;
	}

	public JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton("Ok");
			okButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					if (gebruikers.controle(new Persoon(getTextField()
							.getText(), new String(getPasswordField()
							.getPassword())))) {

						JOptionPane.showMessageDialog(frame,
								"Je bent ingelogd!", "Resultaat",
								JOptionPane.INFORMATION_MESSAGE);

						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(frame,
								"Foutieve informatie!", "Resultaat",
								JOptionPane.INFORMATION_MESSAGE);
						getPasswordField().setText("");
						getPasswordField().requestFocus();
					}

				}
			});
		}
		return okButton;
	}

	public JButton getCancelButton() {
		if (cancelButton == null) {
			cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					frame.dispose();

				}
			});

		}
		return cancelButton;
	}

	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();

		}
		return textField;
	}

	public JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
		}
		return passwordField;
	}

	public InloggenGUI() {
		gebruikers = new Gebruikers();
		gebruikers.toevoegen(new Persoon("Jan", "1234"));
		gebruikers.toevoegen(new Persoon("Ines", "1234"));
		getFrame();

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(
				new Runnable() {
					@Override
					public void run() {
						InloggenGUI inloggenGUI = new InloggenGUI();
						inloggenGUI.getFrame().setVisible(true);
					}
				}
		);
	}

	public JPanel getSmallPanel1() {
		if (smallPanel1 == null) {
			smallPanel1 = new JPanel();
			smallPanel1.setLayout(new GridLayout(1, 2, 10, 10));
			smallPanel1.add(new JLabel("Gebruikersnaam:"));
			smallPanel1.add(getTextField());
		}

		return smallPanel1;
	}

	public JPanel getSmallPanel2() {
		if (smallPanel2 == null) {
			smallPanel2 = new JPanel();
			smallPanel2.setLayout(new GridLayout(1, 2, 10, 10));
			smallPanel2.add(new JLabel("Paswoord:"));
			smallPanel2.add(getPasswordField());
		}
		return smallPanel2;
	}

}
