/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.minka.miinaharava.kayttoliittyma;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Luokassa luodan valikko uudelle ikkunalle, jossa voidaan valita, joko uusi peli tai pelin lopetus.
 *
 * @author tminka
 */
public class UusiPeli implements MouseListener {

    private final Kayttoliittyma kl;
    private JButton uusiPeli;
    private JButton lopeta;
    private JFrame frame2;

    /**
     *Konstruktori.
     * @param kl Kayttoliityma luokan ilmentymä.
     */
    public UusiPeli(Kayttoliittyma kl) {
        this.kl = kl;
    }

    /**
     * Metodi luo uuden ikkunan, jossa on kaksi nappia.
     */
    public void luoNapit() {
        frame2 = new JFrame();
        JPanel paneeli = new JPanel();

        paneeli.setLayout(new GridLayout(2, 1));
        uusiPeli = new JButton("Uusi peli?");
        lopeta = new JButton("Lopeta");

        paneeli.add(uusiPeli);
        paneeli.add(lopeta);

        uusiPeli.addMouseListener(this);
        lopeta.addMouseListener(this);

        frame2.add(paneeli);
        frame2.setSize(200, 200);
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
    }

    /**
     * Aa.
     *
     * @param me
     */
    @Override
    public void mousePressed(MouseEvent me) {
    }

    /**
     * Metodi välittää kayttoliittymalle, jos käyttäjä painaa nappia "uusiPeli", ja sammuttaa ohjeman, jos painetaan nappia "lopeta".
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == uusiPeli) {
            kl.uudenPelinAloitus();
            frame2.setVisible(false);
        } else if (me.getSource() == lopeta) {
            System.exit(0);
        }

    }

    /**
     * Aa.
     *
     * @param me
     */
    @Override
    public void mouseReleased(MouseEvent me
    ) {
    }

    /**
     * Aa.
     *
     * @param me
     */
    @Override
    public void mouseEntered(MouseEvent me
    ) {
    }

    /**
     * Aa.
     *
     * @param me
     */
    @Override
    public void mouseExited(MouseEvent me
    ) {
    }

}
