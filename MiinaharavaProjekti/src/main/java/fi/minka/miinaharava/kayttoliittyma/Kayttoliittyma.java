/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.minka.miinaharava.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import fi.minka.miinaharava.pelilogiikka.Peli;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author tminka
 */
public class Kayttoliittyma extends JFrame {

    private final Peli peli;
    private HiirikuuntelijaKentta hiiri;
    private Valikko valikko;

    public Kayttoliittyma() {
        peli = new Peli();

    }

    public void run() {
        setTitle("Menu");
        setPreferredSize(new Dimension(600, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        valikko = new Valikko(this);
        getContentPane().add(valikko);
        valikko.luoValikko(getContentPane());
        

        pack();
        setVisible(true);

    }

    public void luoKentta(int taso) {
        peli.luoKentta(taso);
        setVisible(false);
        getContentPane().remove(valikko);
        aloitaPeli();
    }

    public void aloitaPeli() {
        getContentPane().add(new Piirtoalusta(peli));
        getContentPane().addMouseListener(hiiri);

        pack();
        setTitle("Miinaharava");

        setSize(peli.getLeveys() * 20 + 50, peli.getKorkeus() * 20 + 50);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void vasenKlikkaus(int x, int y) {
        peli.getKentta().avaa(x, y);
        repaint();
        if (peli.getKentta().onkoMiinaa(x, y)) {
            System.out.println("HÄVSIT");
        } else {
            //tarkista voitto
        }
    }

    public void oikeaKilikkaus(int x, int y) {
        if (!peli.getKentta().onkoAvattu(x, y)) {
            peli.getKentta().liputus(x, y);

        }
        repaint();
    }

}
