/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.minka.miinaharava.pelilogiikka;

import java.util.Random;

/**
 *
 * @author tminka
 */
public class Kentta {
    //pelialueen koko tulee aina olemaan 9x9, 16x16 tai 30x16.

    private final Laatta[][] pelialue;
    private final int korkeus;
    private final int leveys;

    /**
     * Konstruktori, jossa kutsutaan private metodia luoPelialue.
     *
     * @param korkeus
     * @param leveys
     */
    public Kentta(int korkeus, int leveys) {
        pelialue = new Laatta[korkeus][leveys];
        this.korkeus = korkeus;
        this.leveys = leveys;
        luoPelialue();
    }

    private void luoPelialue() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                this.pelialue[i][j] = new Laatta();
            }
        }

        asetaMiinat();

    }

    private void asetaMiinat() {
        Random r = new Random();
        int miinoja = 0;

        if (leveys == 9) {
            miinoja = 10;
        } else if (leveys == 16) {
            miinoja = 40;
        } else if (leveys == 30) {
            miinoja = 99;
        }

        for (int i = 0; i < miinoja; i++) {
            int x = r.nextInt(korkeus);
            int y = r.nextInt(leveys);
            while (pelialue[x][y].onkoMiinallinen()) {
                x = r.nextInt(korkeus);
                y = r.nextInt(leveys);
            }

            pelialue[x][y].miinoita();
            asetaVihjeet(x, y);

        }

    }

    private void asetaVihjeet(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (!(i < 0) && i < korkeus && !(j < 0) && j < leveys) {
                    pelialue[i][j].kasvataVihjettaYhdella();
                }
            }
        }
    }

    /**
     * Metodi (testauksia varten), joka tulostaa kentän syötteenä.
     */
    public void tulostaKentta() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                if (pelialue[i][j].onkoMiinallinen()) {
                    System.out.print("x");
                } else {
                    System.out.print(pelialue[i][j].getVihje());
                }
            }
            System.out.println("");
        }
    }

    /**
     * Metodi, joka liputtaa liputtamattoman laatan tai poistaa lipun
     * liputetusta laatasta.
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
     * Metodi, joka palauttaa halutun laatan vihje-arvon.
     *
     * @param x
     * @param y
     * @return vihje, eli kuinka moneen miinaan koskee
     */
    public int annaVihje(int x, int y) {
        return pelialue[x][y].getVihje();
    }

    /**
     * Metodi palauttaa halutun Laatan "avattu" arvon.
     *
     * @param x
     * @param y
     * @return boolean avattu
     */
    public boolean onkoAvattu(int x, int y) {
        return pelialue[x][y].onkoAvattu();
    }

    /**
     * Metodi palauttaa halutun Laatan "miinallinen" arvon.
     *
     * @param x
     * @param y
     * @return boolean miinallinen
     */
    public boolean onkoMiinaa(int x, int y) {
        return pelialue[x][y].onkoMiinallinen();
    }

    public void avaaKehittyneesti(int x, int y) {
        avaa(x, y);

        if (pelialue[x][y].getVihje() == 0) {
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (!(i < 0) && i < korkeus && !(j < 0) && j < leveys) {
                        if (!pelialue[i][j].onkoAvattu()) {
                            avaaKehittyneesti(i, j);
                        }

                    }
                }
            }

        }

    }

    /**
     * Metodi kutsuu halutussa sijainnissa olevan Laatta luokan ilmentymän
     * metodia avaa().
     *
     * @param x
     * @param y
     */
    public void avaa(int x, int y) {
        pelialue[x][y].avaa();
    }

    /**
     * Metodi palauttaa halutun Laatan "liputettu" arvon
     *
     * @param x
     * @param y
     * @return boolean liputettu
     */
    public boolean onkoLippu(int x, int y) {
        return pelialue[x][y].onkoLippu();
    }

    /**
     * Metodi (testailua varten), joka palauttaa Kentan peliauleelta tietyn
     * Laatan.
     *
     * @param x
     * @param y
     * @return Laatta
     */
    public Laatta laatta(int x, int y) {
        return pelialue[x][y];
    }

}
