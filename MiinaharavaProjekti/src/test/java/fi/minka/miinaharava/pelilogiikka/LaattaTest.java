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
public class LaattaTest {

    Laatta laatta;

    @Before
    public void setUp() {
        laatta = new Laatta();
    }

    @Test
    public void vihjeOnNolla() {
        assertEquals(0, laatta.getVihje());
    }

    @Test
    public void eiOleAvattu() {
        assertEquals(false, laatta.onkoAvattu());
    }

    @Test
    public void eiMiinaa() {
        assertEquals(false, laatta.onkoMiinallinen());
    }

    @Test
    public void eiLippua() {
        assertEquals(false, laatta.onkoLippu());
    }

    @Test
    public void miinanLisays() {
        laatta.miinoita();
        assertEquals(true, laatta.onkoMiinallinen());

    }

    @Test
    public void lipunLisays() {
        laatta.liputa();
        assertEquals(true, laatta.onkoLippu());

    }

    @Test
    public void avataan() {
        laatta.avaa();
        assertEquals(true, laatta.onkoAvattu());

    }
    
    @Test
    public void lipunPoisto(){
        laatta.liputa();
        laatta.poistaLiputus();
        assertEquals(false, laatta.onkoLippu());
    }
    
    @Test
    public void vihjenLisays(){
        laatta.kosketukset(5);
        assertEquals(5, laatta.getVihje());
    }
    
    @Test
    public void vihjeidenLisaysYksitellen(){
        laatta.kasvataVihjettaYhdella();
        assertEquals(1, laatta.getVihje());
    }
    
        @Test
    public void vihjeidenLisaysYksitellen2(){
        laatta.kasvataVihjettaYhdella();
        laatta.kasvataVihjettaYhdella();
        laatta.kasvataVihjettaYhdella();
        laatta.kasvataVihjettaYhdella();
        assertEquals(4, laatta.getVihje());
    }

}
