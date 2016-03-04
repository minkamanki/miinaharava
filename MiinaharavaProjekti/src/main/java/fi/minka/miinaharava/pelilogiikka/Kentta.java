/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.minka.miinaharava.pelilogiikka;

import java.util.Random;

/**
 * Luokka, jossa on taulukko laatoista, ja jossa niille asetetaan oikeat arvot, eli miinat ja liput ja vihjeet.
 *
 * @author tminka
 */
public class Kentta {
    //pelialueen koko tulee aina olemaan 9x9, 16x16 tai 30x16.

    private final Laatta[][] pelialue;
    private final int leveys;
    private final int korkeus;
    int miinoja;

    /**
     * Konstruktori, jossa kutsutaan private metodia luoPelialue.
     *
     * @param leveys sijainti
     * @param korkeus sijainti
     */
    public Kentta(int leveys, int korkeus) {
        pelialue = new Laatta[leveys][korkeus];
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.miinoja = 0;

    }

    /**
     * Metodi, joka luo Laatta luokan ilmentymiä pelialue taulukkoon, ja joka kutsuu metodia asetaMiinat().
     */
    public void luoPelialue() {
        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {
                this.pelialue[i][j] = new Laatta();
            }
        }

        asetaMiinat();

    }

    private void asetaMiinat() {
        Random random = new Random();

        if (korkeus == 9) {
            miinoja = 10;
        } else if (leveys == 16) {
            miinoja = 40;
        } else if (leveys == 30) {
            miinoja = 99;
        }

        for (int i = 0; i < miinoja; i++) {
            int x = random.nextInt(leveys);
            int y = random.nextInt(korkeus);
            while (pelialue[x][y].onkoMiinallinen()) {
                x = random.nextInt(leveys);
                y = random.nextInt(korkeus);
            }

            pelialue[x][y].miinoita();
            asetaVihjeet(x, y);

        }

    }

    /**
     * Metodi, asettaa miinoitetun Laatan ympärillä oleviin tiedon tästä, kasvattamalla niiden vihjeitä yhdellä.
     *
     * @param x miinoitetun sijainti
     * @param y miinoitetun sijainti
     */
    public void asetaVihjeet(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (!(i < 0) && i < leveys && !(j < 0) && j < korkeus) {
                    pelialue[i][j].kasvataVihjettaYhdella();
                }
            }
        }
    }

    /**
     * Metodi, joka liputtaa liputtamattoman laatan tai poistaa lipun liputetusta laatasta.
     *
     * @param x sijainti
     * @param y sijainti
     */
    public void liputus(int x, int y) {
        if (pelialue[x][y].onkoLippu()) {
            pelialue[x][y].poistaLiputus();
        } else {
            pelialue[x][y].liputa();
        }
    }

    /**
     * Metodi palauttaa halutun Laatan "miinallinen" arvon.
     *
     * @param x sijainti
     * @param y sijainti
     */
    public void avaaKehittyneesti(int x, int y) {
        pelialue[x][y].avaa();

        if (pelialue[x][y].getVihje() == 0) {
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (!(i < 0) && i < leveys && !(j < 0) && j < korkeus) {
                        if (!pelialue[i][j].onkoAvattu() && !pelialue[i][j].onkoLippu()) {
                            avaaKehittyneesti(i, j);
                        }

                    }
                }
            }

        }

    }

    /**
     * Metodi, joka palauttaa Kentan peliauleelta tietyn Laatan.
     *
     * @param x siajinti
     * @param y sijainti
     * @return Laatta
     */
    public Laatta laatta(int x, int y) {
        return pelialue[x][y];
    }

    /**
     * Metodi plauttaa levey olioon tallennetun arvon.
     *
     * @return Kentan korkeuden
     */
    public int getKorkeus() {
        return korkeus;
    }

    /**
     * Metodi plauttaa kokeus olioon tallennetun arvon.
     *
     * @return Kentan leveyden
     */
    public int getLeveys() {
        return leveys;
    }

    /**
     * Metodi, joka laskee onko kakki miinat löydetty.
     *
     * @return onko pelaaja voittanut
     */
    public boolean voittiko() {
        int avaamatta = 0;
        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {
                if (!pelialue[i][j].onkoAvattu()) {
                    avaamatta++;
                }
            }
        }
        return avaamatta == miinoja;
    }

}
