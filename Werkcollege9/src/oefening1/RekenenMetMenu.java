package oefening1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class RekenenMetMenu {

	private JFrame frame;

	private JTextField getal1, getal2, resultaat;

	private JButton somButton, verschilButton, vermenigButton, deelButton;

	private JMenuItem somMenuItem, verschilMenuItem, vermenigMenuItem,
			deelMenuItem, sluitMenuItem;

	private JMenuBar menuBar;

	private JMenu bewerkingsMenu, sluitMenu;

	private JPanel panel1, panel2;

	private ActionListener myActionListener;

	public JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getBewerkingsMenu());
			menuBar.add(getSluitMenu());

		}
		return menuBar;
	}

	public JTextField getGetal1() {
		return getal1;
	}

	public JTextField getGetal2() {
		return getal2;
	}

	public JTextField getResultaat() {
		return resultaat;
	}

	public JMenu getBewerkingsMenu() {
		if (bewerkingsMenu == null) {
			bewerkingsMenu = new JMenu("Bewerking");
			bewerkingsMenu.setMnemonic('B');

			bewerkingsMenu.add(getSomMenuItem());
			bewerkingsMenu.add(getVerschilMenuItem());
			bewerkingsMenu.add(getVermenigMenuItem());
			bewerkingsMenu.add(getDeelMenuItem());
		}
		return bewerkingsMenu;
	}

	public JMenu getSluitMenu() {
		if (sluitMenu == null) {

			sluitMenu = new JMenu("Afsluiten");
			sluitMenu.add(getSluitMenuItem());
			sluitMenu.setMnemonic('A');
		}
		return sluitMenu;
	}

	public JPanel getPanel1() {
		if (panel1 == null) {
			panel1 = new JPanel();
			panel1.setLayout(new FlowLayout());
			panel1.add(new JLabel("Getal 1"));
			panel1.add(getal1 = new JTextField(3));
			panel1.add(new JLabel("Getal 2"));
			panel1.add(getal2 = new JTextField(3));
			panel1.add(new JLabel("Resultaat"));
			panel1.add(resultaat = new JTextField(4));
			resultaat.setEditable(false);
		}
		return panel1;
	}

	public JPanel getPanel2() {
		if (panel2 == null) {
			panel2 = new JPanel();
			panel2.setLayout(new FlowLayout());
			panel2.add(getSomButton());
			panel2.add(getVerschilButton());
			panel2.add(getVermenigButton());
			panel2.add(getDeelButton());
		}
		return panel2;
	}

	public JButton getSomButton() {
		if (somButton == null) {
			somButton = new JButton("Som");
			somButton.addActionListener(myActionListener);
		}
		return somButton;
	}

	public JButton getVerschilButton() {
		if (verschilButton == null) {
			verschilButton = new JButton("Verschil");
			verschilButton.addActionListener(myActionListener);
		}
		return verschilButton;
	}

	public JButton getVermenigButton() {
		if (vermenigButton == null) {
			vermenigButton = new JButton("Maal");
			vermenigButton.addActionListener(myActionListener);
		}
		return vermenigButton;
	}

	public JButton getDeelButton() {
		if (deelButton == null) {
			deelButton = new JButton("Deel");
			deelButton.addActionListener(myActionListener);
		}
		return deelButton;
	}

	public RekenenMetMenu() {
		myActionListener = new myActionListener(this);
		getFrame().setVisible(true);
	}

	public static void main(String[] args) {
		RekenenMetMenu application = new RekenenMetMenu();

	}

	

	public JFrame getFrame() {
		if (frame == null) {
			frame = new JFrame();
			frame.setTitle("Rekenen met menu");
			frame.setJMenuBar(getMenuBar());
			// Mac OS X only
			// System.setProperty("apple.laf.useScreenMenuBar", "true");
			frame.getContentPane().setLayout(new BorderLayout());
			frame.getContentPane().add(getPanel1(), BorderLayout.CENTER);
			frame.getContentPane().add(getPanel2(), BorderLayout.SOUTH);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
		}

		return frame;
	}

	public JMenuItem getSomMenuItem() {
		if (somMenuItem == null) {
			somMenuItem = new JMenuItem("Som", 'S');
			somMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					ActionEvent.CTRL_MASK));

			somMenuItem.addActionListener(myActionListener);

		}
		return somMenuItem;
	}

	public JMenuItem getVerschilMenuItem() {
		if (verschilMenuItem == null) {
			verschilMenuItem = new JMenuItem("Verschil", 'V');
			verschilMenuItem.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_L, ActionEvent.CTRL_MASK));
			verschilMenuItem.addActionListener(myActionListener);
		}
		return verschilMenuItem;
	}

	public JMenuItem getVermenigMenuItem() {
		if (vermenigButton == null) {
			vermenigMenuItem = new JMenuItem("Maal", 'M');
			vermenigMenuItem.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_M, ActionEvent.CTRL_MASK));
			vermenigMenuItem.addActionListener(myActionListener);
		}
		return vermenigMenuItem;
	}

	public JMenuItem getSluitMenuItem() {
		if (sluitMenuItem == null) {
			sluitMenuItem = new JMenuItem("Sluit", 'S');
			sluitMenuItem.addActionListener(myActionListener);
		}
		return sluitMenuItem;
	}

	public JMenuItem getDeelMenuItem() {
		if (deelMenuItem == null) {
			deelMenuItem = new JMenuItem("Deel", 'D');
			deelMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
					ActionEvent.CTRL_MASK));
			deelMenuItem.addActionListener(myActionListener);
		}

		return deelMenuItem;
	}
}