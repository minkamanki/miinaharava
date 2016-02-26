/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.minka.miinaharava.pelilogiikka;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author tminka
 */
public class HelppoKenttaTest {

    Kentta kentta;

    @Before
    public void setUp() {
        kentta = new Kentta(9, 9);

        kentta.luoPelialue();
    }

    @Test
    public void oikeaMaaraMiinoja() {
        int miinoja = 0;

        for (int i = 0; i < kentta.getLeveys(); i++) {
            for (int j = 0; j < kentta.getKorkeus(); j++) {
                if (kentta.laatta(i, j).onkoMiinallinen()) {
                    miinoja++;
                }
            }
        }

        assertEquals(10, miinoja);
    }

    @Test
    public void korkeus() {
        assertEquals(9, kentta.getKorkeus());
    }

    @Test
    public void leveys() {
        assertEquals(9, kentta.getLeveys());
    }

    @Test
    public void nsVoitto() {
        int avaamatta = 81;

        for (int i = 0; i < kentta.getKorkeus(); i++) {
            for (int j = 0; j < kentta.getLeveys(); j++) {
                if (avaamatta > 10) {
                    kentta.laatta(i, j).avaa();
                    avaamatta--;
                }
            }
        }

        assertEquals(true, kentta.voittiko());
    }

}
