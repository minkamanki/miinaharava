/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.minka.miinaharava.pelilogiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tminka
 */
public class NormaaliKenttaTest {

    Kentta kentta;

    @Before
    public void setUp() {
        kentta = new Kentta(16, 16);
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
        assertEquals(40, miinoja);
    }

    @Test
    public void eiAuki() {
        assertEquals(false, kentta.laatta(1, 1).onkoAvattu());
    }

    @Test
    public void vihje1() {
        int x = kentta.laatta(1, 1).getVihje();
        kentta.laatta(1, 1).kasvataVihjettaYhdella();
        assertEquals(x + 1, kentta.laatta(1, 1).getVihje());
    }

    @Test
    public void vihje2() {
        int x = kentta.laatta(1, 1).getVihje();
        kentta.laatta(1, 1).kasvataVihjettaYhdella();
        kentta.laatta(1, 1).kasvataVihjettaYhdella();
        kentta.laatta(1, 1).kasvataVihjettaYhdella();
        assertEquals(x + 3, kentta.laatta(1, 1).getVihje());
    }

    @Test
    public void korkeus() {
        assertEquals(16, kentta.getKorkeus());
    }

    @Test
    public void leveys() {
        assertEquals(16, kentta.getLeveys());
    }

    @Test
    public void lippu() {
        kentta.liputus(1, 1);
        assertEquals(true, kentta.laatta(1, 1).onkoLippu());

    }

    @Test
    public void lippu2() {
        kentta.liputus(1, 1);
        kentta.liputus(1, 1);
        assertEquals(false, kentta.laatta(1, 1).onkoLippu());

    }

    @Test
    public void avaaKehittyneesti() {
        kentta.avaaKehittyneesti(1, 1);
        assertEquals(true, kentta.laatta(1, 1).onkoAvattu());

    }

    @Test
    public void eiVoittoa() {
        assertEquals(false, kentta.voittiko());
    }

    @Test
    public void asetaVihje() {
        kentta.laatta(1, 1).nollaaVihje();
        kentta.asetaVihjeet(1, 2);
        kentta.asetaVihjeet(2, 2);
        kentta.asetaVihjeet(2, 1);
        assertEquals(3, kentta.laatta(1, 1).getVihje());
    }

    @Test
    public void asetaVihje2() {
        kentta.laatta(3, 3).nollaaVihje();
        kentta.asetaVihjeet(2, 2);
        kentta.asetaVihjeet(2, 4);
        kentta.asetaVihjeet(2, 3);
        kentta.asetaVihjeet(3, 2);
        kentta.asetaVihjeet(3, 4);
        kentta.asetaVihjeet(4, 4);
        kentta.asetaVihjeet(4, 3);
        kentta.asetaVihjeet(4, 2);
        assertEquals(8, kentta.laatta(3, 3).getVihje());
    }

    @Test
    public void kehittynytAvausNs() {
        kentta.laatta(1, 1).nollaaVihje();
        kentta.avaaKehittyneesti(1, 1);
        assertEquals(true, kentta.laatta(1, 2).onkoAvattu());
        assertEquals(true, kentta.laatta(2, 2).onkoAvattu());
        assertEquals(true, kentta.laatta(2, 1).onkoAvattu());
    }


}
