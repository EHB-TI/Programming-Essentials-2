package oefening2.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import oefening2.db.BoekDAO;
import oefening2.db.DatabaseSingleton;
import oefening2.entity.BoekVO;

public class BiblioGUI {
	private JFrame frame;

	private JPanel panel;

	private JTextField isbn, titel, auteur;

	private JButton toevoegen, cancel;

	public JButton getToevoegen() {
		if (toevoegen == null) {
			toevoegen = new JButton("Toevoegen");
			toevoegen.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					boekToevoegen();
					clearTextFields();
				}

			});
		}
		return toevoegen;
	}

	private void boekToevoegen() {
		BoekDAO boekDAO = new BoekDAO();
		BoekVO boekVO = new BoekVO();
		boekVO.setAuteur(getAuteur().getText());
		boekVO.setTitel(getTitel().getText());
		boekVO.setIsbn(Long.parseLong(getIsbn().getText()));
		try {
			if (boekDAO.insert(boekVO) > 0)
				JOptionPane.showMessageDialog(getFrame(), "Boek toegevoegd!");
			else
				JOptionPane.showMessageDialog(getFrame(), "Boek NIET toegevoegd!");
		} catch (SQLException ex) {
			if(ex.getErrorCode() == 1062)
				JOptionPane.showMessageDialog(null, "ISBN al genomen", "Duplicate Key", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	private void clearTextFields() {
		isbn.setText("");
		titel.setText("");
		auteur.setText("");
	}

	public JButton getCancel() {
		if (cancel == null) {
			cancel = new JButton("Cancel");
			cancel.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					clearTextFields();
				}
			});
		}
		return cancel;
	}

	public BiblioGUI() {
		getFrame().setVisible(true);
	}

	public JFrame getFrame() {
		if (frame == null) {
			frame = new JFrame();
			frame.setTitle("Bibliotheek");
			frame.setContentPane(getPanel());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.addWindowListener(new java.awt.event.WindowAdapter() {
				public void windowClosing(java.awt.event.WindowEvent e) {
					try {
						DatabaseSingleton.getDatabaseSingleton().getConnection(
								true).close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			frame.pack();
		}
		return frame;
	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(4, 2));
			panel.add(new JLabel("ISBN"));
			panel.add(getIsbn());
			panel.add(new JLabel("Titel"));
			panel.add(getTitel());
			panel.add(new JLabel("Auteur"));
			panel.add(getAuteur());
			panel.add(getToevoegen());
			panel.add(getCancel());
		}
		return panel;
	}

	public JTextField getIsbn() {
		if (isbn == null) {
			isbn = new JTextField();
		}
		return isbn;
	}

	public JTextField getTitel() {
		if (titel == null) {
			titel = new JTextField();
		}
		return titel;
	}

	public JTextField getAuteur() {
		if (auteur == null) {
			auteur = new JTextField();
		}
		return auteur;
	}

	public static void main(String[] args) {
		BiblioGUI biblioGUI = new BiblioGUI();
	}

}
