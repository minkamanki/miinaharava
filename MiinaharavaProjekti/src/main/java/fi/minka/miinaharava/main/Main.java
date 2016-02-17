/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.minka.miinaharava.main;

import fi.minka.miinaharava.kayttoliittyma.Kayttoliittyma;

/*()
 *
 * @author tminka
 */
/**
 *
 * @author tminka
 */
public class Main {

    /**
     * Main metodi, joka luo uuden Kayttoliityma luokan ilmentymän ja kutsuu sen
     * metodia run().
     *
     * @param args
     */
    public static void main(String[] args) {
        Kayttoliittyma kl = new Kayttoliittyma();
        kl.run();
    }

}
