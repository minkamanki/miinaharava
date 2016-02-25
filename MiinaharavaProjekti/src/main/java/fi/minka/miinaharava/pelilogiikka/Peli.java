/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.minka.miinaharava.pelilogiikka;

/**
 * Luokka, jossa luodaan kenttä ja pidetään tietoa siitä onko hävitty.
 *
 * @author tminka
 */
public class Peli {

    private Kentta kentta;
    private boolean havitty;

    /**
     * Konstruktorissa asetetaan havitty -arvoksi false.
     */
    public Peli() {
        havitty = false;
    }

    /**
     * Metodi, joka luo Kentta luokan ilmentymän, halutun kokoisena. 
     * Kutsuu Kentta luokan metodia luoPelialue();
     *
     * @param taso Valittu vaikeusaste pelille.
     */
    public void luoKentta(int taso) {
        //kentta voi olla vain 9x9, 16x16 tai 16x30
        if (taso == 1) {
            kentta = new Kentta(9, 9);

        } else if (taso == 2) {
            kentta = new Kentta(16, 16);

        } else {
            kentta = new Kentta(30, 16);

        }

        kentta.luoPelialue();
    }

    /**
     * Metodi palauttaa Kentta olion.
     *
     * @return Kentta
     */
    public Kentta getKentta() {
        return kentta;
    }

    /**
     * Metodissa asetetaan havia arvo todeksi.
     */
    public void havia() {
        havitty = true;
    }

    /**
     *Metodissa palautetaan havitty arvo.
     * @return havitty
     */
    public boolean onkoHavitty() {
        return havitty;
    }

}
