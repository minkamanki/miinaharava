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
 * Luokka, jossa on useanlaisa metodeita, jotka vastaavat pelin toiminnasta ja etenemisestä.
 *
 * @author tminka
 */
public class Kayttoliittyma extends JFrame {

    private Peli peli;
    private HiirikuuntelijaKentta hiiri;
    private Valikko valikko;
    private UusiPeli uusi;
    private Piirtoalusta alusta;

    /**
     * Metodi, jossa luodaan Valikko-luokan ilmentmä JFrameen ja laitetaan se näkyväksi.
     */
    public void run() {
        peli = new Peli();
        valikko = new Valikko(this);
        setTitle("Menu");
        setPreferredSize(new Dimension(600, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().add(valikko);
        valikko.luoValikko();

        pack();
        setVisible(true);

    }

    /**
     * Metodi, jossa viedään Peli luokan ilmentymän kautta haluttu taso kentän luontia varten. Valikko otetaan pois näkyvistä ja poistetaan.
     * Kutsutaan metodia aloitaPeli().
     *
     * @param taso Käyttäjän valitsema pelin vaikeus taso
     */
    public void luoKentta(int taso) {
        peli.luoKentta(taso);
        getContentPane().remove(valikko);
        aloitaPeli();
    }

    /**
     * Metodi, jossa JFrameen lisätään ilmentymät Piirtoalsutasta ja HiirikuntelijaKentasta.
     *
     */
    public void aloitaPeli() {
        hiiri = new HiirikuuntelijaKentta(this);
        alusta = new Piirtoalusta(peli);
        getContentPane().add(alusta);
        getContentPane().addMouseListener(hiiri);

        pack();
        setTitle("Miinaharava");

        setSize((peli.getKentta().getLeveys() * 20) + 42, (peli.getKentta().getKorkeus() * 20) + 80);
        setVisible(true);
    }

    /**
     * Metodi, jossa viedään tieto klikkauksesta eteenpäin, ja josssa tarksitetaan kyseisen klikkauksen aiheuttama voitto tai häviö, missä tapauksissa kutsuttaiiin metodia uusiPeli().
     *
     * @param x Siainti leveys suunnassa
     * @param y Sijainti korkeus suunnassa
     */
    public void vasenKlikkaus(int x, int y) {
        if (!peli.getKentta().laatta(x, y).onkoLippu()) {
            peli.getKentta().avaaKehittyneesti(x, y);
            if (peli.getKentta().laatta(x, y).onkoMiinallinen()) {
                peli.havia();
                uusiPeli();
            } else if (peli.getKentta().voittiko()) {
                uusiPeli();
            }
            repaint();
        }
    }

    /**
     * Metodi, jossa viedään tieto oikean puolisesta klikkauksesta eteenpäin, liputuksen aikaan saamiseksi.
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

    /**
     *Metodi, joka poistaa hiirikuuntelijan käytöstä ja luo uuden ilmentymän UusiPeli luokasta, ja kutsuu sen metodia.
     */
    public void uusiPeli() {
        getContentPane().removeMouseListener(hiiri);
        uusi = new UusiPeli(this);
        uusi.luoNapit();
    }

    /**
     * Metodi poistaa luodun piirtoalustan paneelista, ja kutsuu metodia run(), uuden pelin aloittamiseksi.
     */
    public void uudenPelinAloitus() {
        getContentPane().remove(alusta);
        run();
    }
    
    /**
     *Metodi testausta varten.
     * @return peli
     */
    public Peli getPeli() {
        return peli;
    }
}
