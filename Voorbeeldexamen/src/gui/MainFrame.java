package gui;

import db.BordspelDAO;
import entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    private JPanel p1;
    private ScrollPane sp;
    private JTextArea jta_tafelinfo;
    private JComboBox<Tafel> cb_tafels;
    private JComboBox<Bordspel> cb_spelen;
    private JButton btn_toevoegen;

    private ArrayList<Tafel> tafels = new ArrayList<>(List.of(new Tafel("Tafel 1"), new Tafel("Tafel 2"), new Tafel("Tafel 3")));

    public MainFrame()
    {
        this.setTitle("Earthen Board");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(getP1(), BorderLayout.NORTH);
        this.add(getSp(), BorderLayout.CENTER);
        this.pack();
    }

    public JPanel getP1() {
        if(p1==null)
        {
            p1 = new JPanel();
            p1.add(new JLabel("Tafels: "));
            p1.add(getCb_tafels());
            p1.add(new JLabel("Bordspel: "));
            p1.add(getCb_spelen());
            p1.add(getBtn_toevoegen());
        }
        return p1;
    }

    public ScrollPane getSp() {
        if(sp == null)
        {
            sp = new ScrollPane();
            sp.add(getJta_tafelinfo());
        }
        return sp;
    }

    public JTextArea getJta_tafelinfo() {
        if(jta_tafelinfo == null)
            jta_tafelinfo = new JTextArea(20, 20);
        return jta_tafelinfo;
    }

    public JComboBox getCb_tafels() {
        if(cb_tafels == null)
        {
            cb_tafels = new JComboBox();
            for(Tafel t : tafels)
            {
                cb_tafels.addItem(t);
            }
            cb_tafels.setSelectedIndex(-1);
            cb_tafels.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getJta_tafelinfo().setText(((Tafel)cb_tafels.getSelectedItem()).bestellingToString());
                }
            });
        }
        return cb_tafels;
    }

    public JComboBox getCb_spelen() {
        if(cb_spelen == null) {
            cb_spelen = new JComboBox();
            BordspelDAO bdao = new BordspelDAO();
            for(Bordspel b : bdao.geefAlleBordspellen())
            {
                cb_spelen.addItem(b);
            }
        }
        return cb_spelen;
    }

    public JButton getBtn_toevoegen() {
        if(btn_toevoegen == null)
        {
            btn_toevoegen = new JButton("Toevoegen");
            btn_toevoegen.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ((Tafel)cb_tafels.getSelectedItem()).voegProductToe((Product)cb_spelen.getSelectedItem());
                        getJta_tafelinfo().setText(((Tafel)cb_tafels.getSelectedItem()).bestellingToString());
                    } catch (VervallenException vervallenException) {
                        vervallenException.printStackTrace();
                    }
                }
            });
        }
        return btn_toevoegen;
    }
}
