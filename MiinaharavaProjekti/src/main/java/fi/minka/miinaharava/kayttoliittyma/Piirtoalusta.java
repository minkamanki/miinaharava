/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.minka.miinaharava.kayttoliittyma;

import fi.minka.miinaharava.pelilogiikka.Peli;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author tminka
 */
public class Piirtoalusta extends JPanel {

    private final Peli peli;

    /**
     * Konstruktori, jossa asetataan parametrina saatu Peli luokan ilmentyma
     * peli olioksi.
     *
     * @param peli Peli-luokan ilmentyma
     */
    public Piirtoalusta(Peli peli) {
        this.peli = peli;
    }

    /**
     * Metodi kutsuu metodia piirraLaatta, kaikille Kentta luoka Laatoille.
     *
     * @param g
     */
    public void piirraKentta(Graphics g) {
        for (int i = 0; i < peli.getKentta().getKorkeus(); i++) {
            for (int j = 0; j < peli.getKentta().getLeveys(); j++) {
                piirraLaatta(i, j, g);
            }
        }
    }

    /**
     * Metodi piirtää annetun "laatan" graaffisena.
     *
     * @param x Siainti leveys suunnassa
     * @param y Sijainti korkeus suunnassa
     * @param g
     */
    public void piirraLaatta(int x, int y, Graphics g) {
        ImageIcon lippu = new ImageIcon("flag.png");
        ImageIcon miina = new ImageIcon("mine.png");
        ImageIcon laatta = new ImageIcon("laattta.png");

        if (!peli.getKentta().onkoAvattu(x, y)) {
            laatta.paintIcon(this, g, 21 + (x * 20), 21 + (y * 20));
            if (peli.getKentta().onkoLippu(x, y)) {
                lippu.paintIcon(this, g, 21 + (x * 20), 21 + (y * 20));
            }

        } else {
            g.setColor(Color.gray);
            g.drawRect(20 + (x * 20), 20 + (y * 20), 20, 20);

            if (peli.getKentta().onkoMiinaa(x, y)) {
                miina.paintIcon(this, g, 21 + (x * 20), 21 + (y * 20));
            } else {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(21 + (x * 20), 21 + (y * 20), 19, 19);
                if (peli.getKentta().annaVihje(x, y) == 1) {
                    g.setColor(Color.BLUE);
                } else if (peli.getKentta().annaVihje(x, y) == 2) {
                    g.setColor(new Color(14, 168, 14));

                } else if (peli.getKentta().annaVihje(x, y) == 3) {
                    g.setColor(Color.RED);

                } else if (peli.getKentta().annaVihje(x, y) == 4) {
                    g.setColor(new Color(1, 9, 122));

                } else if (peli.getKentta().annaVihje(x, y) == 5) {
                    g.setColor(new Color(102, 0, 0));

                } else if (peli.getKentta().annaVihje(x, y) == 6) {
                    g.setColor(new Color(0, 102, 102));

                } else if (peli.getKentta().annaVihje(x, y) == 7) {
                    g.setColor(new Color(114, 47, 86));

                } else if (peli.getKentta().annaVihje(x, y) != 0) {
                    g.setColor(Color.black);
                }

                g.setFont(new Font("default", Font.BOLD, 16));
                g.drawString("" + peli.getKentta().annaVihje(x, y), 25 + (x * 20), 37 + (y * 20));
            }
        }
    }

    /**
     * Metodi overridaa paintComponent meodin, asettaa taustaksi vaalean harmaan
     * ja kutsuu meodia piirraKentta.
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.setBackground(Color.lightGray);
        piirraKentta(g);
    }
}
