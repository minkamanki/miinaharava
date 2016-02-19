/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.minka.miinaharava.kayttoliittyma;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import fi.minka.miinaharava.pelilogiikka.Peli;

/**
 *
 * @author tminka
 */
public class Kayttoliittyma extends JFrame {

    private final Peli peli;
    private final HiirikuuntelijaKentta hiiri;
    private Valikko valikko;

    /**
     * Konstruktori, jossa luodaan uusi Peli- luokan ilmentymä
     */
    public Kayttoliittyma() {
        peli = new Peli();
        valikko = new Valikko(this);
        hiiri = new HiirikuuntelijaKentta(this);

    }

    /**
     * Metodi, jossa luodaan Valikko-luokan ilmentmä JFrameen ja laitetaan se
     * näkyväksi
     */
    public void run() {
        setTitle("Menu");
        setPreferredSize(new Dimension(600, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContentPane().add(valikko);
        valikko.luoValikko(getContentPane());

        pack();
        setVisible(true);

    }

    /**
     * Metodi, jossa viedään Peli luokan ilmentymän kautta haluttu taso kentän
     * luontia varten. Valikko otetaan pois näkyvistä ja poistetaan. Kutsutaan
     * metodia aloitaPeli().
     *
     * @param taso Käyttäjän valitsema pelin vaikeus taso
     */
    public void luoKentta(int taso) {
        peli.luoKentta(taso);
        getContentPane().remove(valikko);
        aloitaPeli();
    }

    /**
     * Metodi, jossa JFrameen lisätään ilmentymät Piirtoalsutasta ja
     * HiirikuntelijaKentasta.
     *
     */
    public void aloitaPeli() {
        getContentPane().add(new Piirtoalusta(peli));
        getContentPane().addMouseListener(hiiri);

        pack();
        setTitle("Miinaharava");

        setSize(peli.getKentta().getLeveys() * 20 + 50, peli.getKentta().getKorkeus() * 20 + 50);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Metodi, jossa viedään tieto klikkauksesta eteenpäin, ja josssa
     * tarksitetaan kyseisen klikkauksen aiheuttama voitto tai häviö.
     *
     * @param x Siainti leveys suunnassa
     * @param y Sijainti korkeus suunnassa
     */
    public void vasenKlikkaus(int x, int y) {
        if (!peli.getKentta().laatta(x, y).onkoLippu()) {
            peli.getKentta().avaaKehittyneesti(x, y);
            repaint();
            if (peli.getKentta().laatta(x, y).onkoMiinallinen()) {
                System.out.println("HÄVSIT");
            } else {
                //tarkista voitto
            }
        }
    }

    /**
     * Metodi, jossa viedään tieto oikean puolisesta klikkauksesta eteenpäin,
     * liputuksen aikaan saamiseksi.
     *
     * @param x Siainti leveys suunnassa
     * @param y Sijainti korkeus suunnassa
     */
    public void oikeaKilikkaus(int x, int y) {
        if (!peli.getKentta().laatta(x, y).onkoAvattu()) {
            peli.getKentta().liputus(x, y);

        }
        repaint();
    }

}
