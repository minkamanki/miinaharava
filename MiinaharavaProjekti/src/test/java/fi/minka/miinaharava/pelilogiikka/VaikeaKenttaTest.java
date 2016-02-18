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
public class VaikeaKenttaTest {

    Kentta kentta;

    @Before
    public void setUp() {
        kentta = new Kentta(30, 16);
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

        assertEquals(99, miinoja);

    }
    
    @Test
    public void korkeus(){
        assertEquals(30, kentta.getKorkeus());
    }
    
        @Test
    public void leveys(){
        assertEquals(16, kentta.getLeveys());
    }
}
