/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.minka.miinaharava.kayttoliittyma;

import java.awt.Dimension;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tminka
 */
public class KayttoliittymaTest {

    Kayttoliittyma kl = new Kayttoliittyma();

    @Before
    public void setUp() {
        kl.run();

    }

    @Test
    public void testLuoKentta1() {
        kl.luoKentta(1);
        assertEquals(kl.getPeli().getKentta().getLeveys(), 9);
    }

    @Test
    public void testLuoKentta2() {
        kl.luoKentta(2);
        assertEquals(kl.getPeli().getKentta().getLeveys(), 16);
    }

    @Test
    public void testLuoKentta3() {
        kl.luoKentta(3);
        assertEquals(kl.getPeli().getKentta().getLeveys(), 30);
    }

    @Test
    public void testVasenKlikkaus() {
        kl.luoKentta(1);
        kl.vasenKlikkaus(1, 1);
        assertEquals(kl.getPeli().getKentta().laatta(1, 1).onkoAvattu(), true);

    }

    @Test
    public void testOikeaKilikkaus() {
        kl.luoKentta(1);
        kl.oikeaKilikkaus(1, 1);
        assertEquals(kl.getPeli().getKentta().laatta(1, 1).onkoLippu(), true);
    }

    @Test
    public void testOikeaKilikkausX2() {
        kl.luoKentta(1);
        kl.oikeaKilikkaus(1, 1);
        kl.oikeaKilikkaus(1, 1);
        assertEquals(kl.getPeli().getKentta().laatta(1, 1).onkoLippu(), false);
    }

    @Test
    public void uuttaPelia() {
        kl.luoKentta(1);
        kl.vasenKlikkaus(1, 1);
        kl.uusiPeli();
        kl.uudenPelinAloitus();
        kl.luoKentta(1);
        assertEquals(kl.getPeli().getKentta().laatta(1, 1).onkoAvattu(), false);
    }

    @Test
    public void title() {
        assertEquals(kl.getTitle(), "Menu");
    }

    @Test
    public void title2() {
        kl.luoKentta(1);
        assertEquals(kl.getTitle(), "Miinaharava");
    }

    @Test
    public void size() {
        assertEquals(kl.getSize(), new Dimension(600, 400));
    }

    @Test
    public void size1() {

        kl.luoKentta(1);
        assertEquals(kl.getSize(), new Dimension(222, 260));
    }

    @Test
    public void size2() {

        kl.luoKentta(2);
        assertEquals(kl.getSize(), new Dimension(362, 400));
    }

    @Test
    public void size3() {
        kl.luoKentta(3);
        assertEquals(kl.getSize(), new Dimension(642, 400));
    }

    @Test
    public void oikeaPlusVasenKlikkaus() {
        kl.luoKentta(1);
        kl.oikeaKilikkaus(1, 1);
        kl.vasenKlikkaus(1, 1);
        assertEquals(kl.getPeli().getKentta().laatta(1, 1).onkoAvattu(), false);
    }
}
