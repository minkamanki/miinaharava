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
    }

    @Test
    public void oikeaMaaraMiinoja() {
        int miinoja = 0;

        for (int i = 0; i < kentta.getKorkeus(); i++) {
            for (int j = 0; j < kentta.getLeveys(); j++) {
                if (kentta.laatta(i, j).onkoMiinallinen()) {
                    miinoja++;
                }
            }

        }
        assertEquals(40, miinoja);
    }

    @Test
    public void avaus() {
        kentta.avaa(1, 1);
        assertEquals(true, kentta.onkoAvattu(1, 1));
    }

    @Test
    public void eiAuki() {
        assertEquals(false, kentta.onkoAvattu(1, 1));
    }

    @Test
    public void liputus() {
        kentta.liputus(1, 1);
        assertEquals(true, kentta.onkoLippu(1, 1));
    }

    @Test
    public void eiLippua() {
        assertEquals(false, kentta.onkoLippu(1, 1));
    }

    @Test
    public void eiLippua2() {
        kentta.liputus(1, 1);
        kentta.liputus(1, 1);
        assertEquals(false, kentta.onkoLippu(1, 1));
    }

    @Test
    public void miina() {
        kentta.laatta(1, 1).miinoita();
        assertEquals(kentta.onkoMiinaa(1, 1), true);
    }

    @Test
    public void vihje1() {
        int x = kentta.annaVihje(1, 1);
        kentta.laatta(1, 1).kasvataVihjettaYhdella();
        assertEquals(x + 1, kentta.annaVihje(1, 1));
    }

    @Test
    public void vihje2() {
        int x = kentta.annaVihje(1, 1);
        kentta.laatta(1, 1).kasvataVihjettaYhdella();
        kentta.laatta(1, 1).kasvataVihjettaYhdella();
        kentta.laatta(1, 1).kasvataVihjettaYhdella();
        assertEquals(x + 3, kentta.annaVihje(1, 1));
    }
    
        
    @Test
    public void korkeus(){
        assertEquals(16, kentta.getKorkeus());
    }
    
        @Test
    public void leveys(){
        assertEquals(16, kentta.getLeveys());
    }
}
