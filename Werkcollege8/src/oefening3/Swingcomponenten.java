package oefening3;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Swingcomponenten {
	private JFrame frame;

	private JButton button;

	private JTextField textField;

	private JLabel label;

	private ButtonGroup buttonGroup;

	private JCheckBox checkBox;

	private JComboBox<String> comboBox;

	private JPanel panel;

	private JPanel smallPanel1, smallPanel2, smallPanel3, smallPanel4,
			verySmallPanel;

	private JRadioButton radioButton1 = new JRadioButton("optie1", true);

	private JRadioButton radioButton2 = new JRadioButton("optie2");

	private JRadioButton radioButton3 = new JRadioButton("optie3");

	private boolean crossPlatform = true;

	private JRadioButton getRadioButton1() {
		return radioButton1;
	}

	private JRadioButton getRadioButton2() {
		return radioButton2;
	}

	private JRadioButton getRadioButton3() {
		return radioButton3;
	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton();
			button.setText("Klik mij");

		}
		return button;
	}

	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
			buttonGroup.add(getRadioButton1());
			buttonGroup.add(getRadioButton2());
			buttonGroup.add(getRadioButton3());
		}
		return buttonGroup;
	}

	private JCheckBox getCheckBox() {
		if (checkBox == null) {
			checkBox = new JCheckBox("vinken");
		}
		return checkBox;
	}

	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			String[] content = { "een", "twee", "drie" };
			comboBox = new JComboBox<String>(content);
		}
		return comboBox;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Vaste tekst");
		}
		return label;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField(20);
		}
		return textField;
	}

	private JFrame getFrame() {
		if (frame == null) {
			frame = new JFrame();
			frame.setSize(300, 200);
			frame.setContentPane(getContentPane());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		// demonstratie van het gebruik van de UIManager
		// gebruik van CrossPlatformLookandFeel
		try {
			if (crossPlatform)
				UIManager.setLookAndFeel(UIManager
						.getCrossPlatformLookAndFeelClassName());
			else
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(frame);

		return frame;
	}

	private JPanel getContentPane() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(4, 1));
			panel.add(getSmallPanel1());
			panel.add(getSmallPanel2());
			panel.add(getSmallPanel3());
			panel.add(getSmallPanel4());

		}
		return panel;
	}

	public static void main(String[] args) {
		Swingcomponenten swingcomponenten = new Swingcomponenten();
		swingcomponenten.getFrame().setVisible(true);
	}

	private JPanel getSmallPanel1() {
		if (smallPanel1 == null) {
			smallPanel1 = new JPanel();
			// smallPanel1.setLayout(new FlowLayout());
			// FlowLayout is de default layoutmanager van een JPanel.
			smallPanel1.add(getVerySmallPanel());
		}
		return smallPanel1;
	}

	public JPanel getSmallPanel2() {
		if (smallPanel2 == null) {
			smallPanel2 = new JPanel();
			smallPanel2.add(getTextField());
		}
		return smallPanel2;
	}

	public JPanel getSmallPanel3() {
		if (smallPanel3 == null) {
			smallPanel3 = new JPanel();
			smallPanel3.add(getLabel());
			getButtonGroup();
			smallPanel3.add(radioButton1);
			smallPanel3.add(radioButton2);
			smallPanel3.add(radioButton3);
		}
		return smallPanel3;
	}

	public JPanel getSmallPanel4() {
		if (smallPanel4 == null) {
			smallPanel4 = new JPanel();
			smallPanel4.add(getCheckBox());
			smallPanel4.add(getComboBox());
		}
		return smallPanel4;
	}

	public JPanel getVerySmallPanel() {
		if (verySmallPanel == null) {
			verySmallPanel = new JPanel();
			verySmallPanel.setBackground(Color.blue);
			verySmallPanel.add(getButton());
		}
		return verySmallPanel;
	}

}
