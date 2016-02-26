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
public class PeliTest {

    private Peli peli;

    @Before
    public void setUp() {
        peli = new Peli();

    }

    @Test
    public void kentta1Leveys() {
        peli.luoKentta(1);
        assertEquals(peli.getKentta().getLeveys(), 9);
    }

    @Test
    public void kentta1Korkeus() {
        peli.luoKentta(1);
        assertEquals(peli.getKentta().getKorkeus(), 9);
    }

    @Test
    public void kentta2Leveys() {
        peli.luoKentta(2);
        assertEquals(peli.getKentta().getLeveys(), 16);
    }

    @Test
    public void kentta2Korkeus() {
        peli.luoKentta(2);
        assertEquals(peli.getKentta().getKorkeus(), 16);
    }

    @Test
    public void kentta3Leveys() {
        peli.luoKentta(3);
        assertEquals(peli.getKentta().getLeveys(), 30);
    }

    @Test
    public void kentta3Korkeus() {
        peli.luoKentta(3);
        assertEquals(peli.getKentta().getKorkeus(), 16);
    }
    
    @Test
    public void kentta1(){
        peli.luoKentta(1);
        assertEquals(peli.getKentta().laatta(1, 1).onkoAvattu(), false);
    }
    
    @Test
    public void eiHavitty(){
        assertEquals(peli.onkoHavitty(), false);
    }
    
        @Test
    public void onHavitty(){
        peli.havia();
        assertEquals(peli.onkoHavitty(), true);
    }

}
