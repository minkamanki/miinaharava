/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.minka.miinaharava.pelilogiikka;

/**
 * Luokka, jossa on yksittäisen laatan tiedot.
 *
 * @author tminka
 */
public class Laatta {

    private boolean avattu;
    private boolean miinallinen;
    private boolean liputettu;
    private int vihje;

    /**
     * Konstruktori.
     */
    public Laatta() {
        this.avattu = false;
        this.miinallinen = false;
        this.liputettu = false;
        this.vihje = 0;
    }

    /**
     * Metodi, joka asettaa Laatan "avattu" arvoksi true.
     */
    public void avaa() {
        this.avattu = true;
    }

    /**
     * Metodi, joka asettaa Laatan "liputettu" arvoksi true.
     */
    public void liputa() {
        this.liputettu = true;
    }

    /**
     * Metodi, joka asettaa Laatan "liputettu" arvoksi false.
     */
    public void poistaLiputus() {
        this.liputettu = false;
    }

    /**
     * Metodi, joka asettaa Laatan "miinallinen" arvoksi true.
     */
    public void miinoita() {
        this.miinallinen = true;
    }

    /**
     * Metodi, joka kasvattaa Laatan "vihje" arvoa yhdellä.
     */
    public void kasvataVihjettaYhdella() {
        vihje++;
    }

    /**
     * Metodi, joka asettaa annatun maaran, vihjeeksi.
     *
     * @param maara määrä
     */
    public void kosketukset(int maara) {
        this.vihje = maara;
    }

    /**
     * Metodi, joka palauttaa Laatan "avattu" arvon.
     *
     * @return Laatan "avattu" arvo, true tai false.
     */
    public boolean onkoAvattu() {
        return avattu;
    }

    /**
     * Metodi palauttaa Laatan "miinallinen" arvon.
     *
     * @return boolean miinallinen
     */
    public boolean onkoMiinallinen() {
        return miinallinen;
    }

    /**
     * Metodi palauttaa Laatan "lipuettu" arvon.
     *
     * @return boolean liputettu
     */
    public boolean onkoLippu() {
        return liputettu;
    }

    /**
     * Metodi palauttaa Laatan "vihje" arvon.
     *
     * @return vihje
     */
    public int getVihje() {
        return vihje;
    }

    /**
     * Metodi jolla nollataan vihje, koska testit tarvii.
     *
     */
    public void nollaaVihje() {
        vihje = 0;
    }
}
