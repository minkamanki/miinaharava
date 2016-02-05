/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharavaprojekti.miinaharavaprojekti.pelilogiikka;

/**
 *
 * @author tminka
 */
public class Peli {

    public void pelaa(int taso) {
        Kentta kentta; //kentta voi olla vain 9x9, 16x16 tai 16x30
        if (taso == 1) {
            kentta = new Kentta(9, 9);
        } else if (taso == 2) {
            kentta = new Kentta(16, 16);
        } else {
            kentta = new Kentta(16, 30);

        }

        kentta.tulostaKentta();

    }

}
