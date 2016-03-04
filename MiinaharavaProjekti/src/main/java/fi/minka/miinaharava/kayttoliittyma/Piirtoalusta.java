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
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Piirtoalusta luokka vastaa kaikesta graaffisesta osuudesta pelissä.
 *
 * @author tminka
 */
public class Piirtoalusta extends JPanel {

    private final Peli peli;
    private final ImageIcon lippu;
    private final ImageIcon miina;
    private final ImageIcon laatta;

    /**
     * Konstruktori, jossa asetataan parametrina saatu Peli luokan ilmentyma peli olioksi.
     *
     * @param peli Peli-luokan ilmentyma
     */
    public Piirtoalusta(Peli peli) {
        this.peli = peli;
        lippu = new ImageIcon("/home/tminka/miinaharava/MiinaharavaProjekti/flag.png");
        miina = new ImageIcon("/home/tminka/miinaharava/MiinaharavaProjekti/mine.png");
        laatta = new ImageIcon("/home/tminka/miinaharava/MiinaharavaProjekti/laattta.png");
    }

    /**
     * Metodi kutsuu metodia piirraLaatta, kaikille Kentta luoka Laatoille.
     *
     * @param g Graphics
     */
    public void piirraKentta(Graphics g) {
        tarkistaVoitto(g);
        for (int i = 0; i < peli.getKentta().getLeveys(); i++) {
            for (int j = 0; j < peli.getKentta().getKorkeus(); j++) {
                piirraLaatta(i, j, g);
            }
        }
    }

    /**
     * Metodi piirtää annetun "laatan" graaffisena.
     *
     * @param x Siainti leveys suunnassa
     * @param y Sijainti korkeus suunnassa
     * @param g Graphics
     */
    public void piirraLaatta(int x, int y, Graphics g) {

        if (!peli.getKentta().laatta(x, y).onkoAvattu()) {
            laatta.paintIcon(this, g, 21 + (x * 20), 21 + (y * 20));
            if (peli.getKentta().laatta(x, y).onkoLippu()) {
                lippu.paintIcon(this, g, 21 + (x * 20), 21 + (y * 20));
            }

        } else {
            g.setColor(Color.gray);
            g.drawRect(20 + (x * 20), 20 + (y * 20), 20, 20);

            if (peli.getKentta().laatta(x, y).onkoMiinallinen()) {
                miina.paintIcon(this, g, 21 + (x * 20), 21 + (y * 20));
            } else {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(21 + (x * 20), 21 + (y * 20), 19, 19);
                int vihje = peli.getKentta().laatta(x, y).getVihje();

                if (vihje == 1) {
                    g.setColor(Color.BLUE);

                } else if (vihje == 2) {
                    g.setColor(new Color(14, 168, 14));

                } else if (vihje == 3) {
                    g.setColor(Color.RED);

                } else if (vihje == 4) {
                    g.setColor(new Color(1, 9, 122));

                } else if (vihje == 5) {
                    g.setColor(new Color(102, 0, 0));

                } else if (vihje == 6) {
                    g.setColor(new Color(0, 102, 102));

                } else if (vihje == 7) {
                    g.setColor(new Color(114, 47, 86));

                } else if (vihje != 0) {
                    g.setColor(Color.black);
                }

                g.setFont(new Font("default", Font.BOLD, 16));
                g.drawString("" + vihje, 25 + (x * 20), 37 + (y * 20));
            }
        }
    }

    /**
     * Metodi overridaa paintComponent meodin, asettaa taustaksi vaalean harmaan ja kutsuu meodia piirraKentta.
     *
     * @param g Graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.setBackground(Color.lightGray);
        piirraKentta(g);
    }

    private void tarkistaVoitto(Graphics g) {
        if (peli.getKentta().voittiko()) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("default", Font.BOLD, 18));
            g.drawString("Voitit!", 25, (peli.getKentta().getKorkeus() * 20) + 50);
        } else if (peli.onkoHavitty()) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("default", Font.BOLD, 18));
            g.drawString("Hävisit!", 25, (peli.getKentta().getKorkeus() * 20) + 50);

        }
    }
}
