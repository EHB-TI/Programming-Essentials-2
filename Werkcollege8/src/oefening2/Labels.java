package oefening2;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Labels {
	private JFrame jFrame;

	private JLabel label1;

	private JLabel label2;

	public Labels() {
		getJFrame().setVisible(true);
	}

	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			jFrame.setSize(300, 200);

			Container c = jFrame.getContentPane();
			c.setLayout(new FlowLayout());

			c.add(getLabel1());
			c.add(getLabel2());

			jFrame.setTitle("Application");
		}

		return jFrame;
	}

	private JLabel getLabel1() {
		if (label1 == null) {
			label1 = new JLabel();

			label1.setText("label1");
		}
		return label1;
	}

	private JLabel getLabel2() {
		if (label2 == null) {
			label2 = new JLabel();
			label2.setText("label2");
			label2.setBackground(Color.RED);
			label2.setOpaque(true);
		}
		return label2;
	}

	public static void main(String[] args) {
		new Labels();
	}
}
