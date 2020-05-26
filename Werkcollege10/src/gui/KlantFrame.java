package gui;

import entity.Film;
import entity.Game;
import entity.Klant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class KlantFrame extends JFrame {

    private JComboBox<Klant> cmb_klant;
    private JTextArea ta_lijst;
    private ArrayList<Klant> klanten;

    public KlantFrame()
    {
        addKlanten();
        this.add(getCmb_klant(), BorderLayout.NORTH);
        ScrollPane sp = new ScrollPane();
        sp.add(getTa_lijst());
        this.add(sp);
        this.pack();
    }

    public JComboBox<Klant> getCmb_klant() {
        if(cmb_klant == null)
        {
            cmb_klant = new JComboBox<>();
            fillbox();
            cmb_klant.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Klant k = (Klant) cmb_klant.getSelectedItem();
                    if(k!=null)
                    getTa_lijst().setText(k.sorteerOpTitel());
                }
            });
            cmb_klant.setSelectedIndex(-1);
        }
        return cmb_klant;
    }

    private void fillbox() {
        for(Klant k : klanten)
            cmb_klant.addItem(k);
    }

    public JTextArea getTa_lijst() {
        if(ta_lijst == null)
        {
            ta_lijst = new JTextArea(10,10);
            ta_lijst.setEditable(false);
        }
        return ta_lijst;
    }

    public void addKlanten()
    {
        klanten = new ArrayList<>();

        Klant jos = new Klant("Jos");
        jos.huur(new Film("The Shawshank Redemption", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", 9.3, "Frank Darabont", Film.Disktype.DVD));
        jos.huur(new Film("The Godfather ", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", 9.2, "Francis Ford Coppola", Film.Disktype.BD));
        jos.huur(new Game("Half-Life", "Half-Life is a series of first-person shooter games developed and published by Valve. The games combine shooting combat, puzzles, and storytelling.", 9.6, "Valve"));
        klanten.add(jos);

        Klant jef = new Klant("Jef");
        jef.huur(new Game("Overwatch" , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", 6.7, "Blizzard"));
        jef.huur(new Game("Minecraft", "Lorem ipsum dolor sit amet, consectetur adipiscing...", 7.5, "Majong Studios"));
        klanten.add(jef);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                KlantFrame kf = new KlantFrame();
                kf.setVisible(true);
            }
        });
    }
}
