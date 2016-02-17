/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.minka.miinaharava.kayttoliittyma;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author tminka
 */
public class HiirikuuntelijaKentta implements MouseListener {

    private final Kayttoliittyma kl;

    /**
     * Konstruktori
     *
     * @param kl Kayttoliittyma luokan ilmentymä
     */
    public HiirikuuntelijaKentta(Kayttoliittyma kl) {
        this.kl = kl;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    /**
     * Metodi antaa Kayttoliitymaan tiedon, painettiinko hiirtä vasemmalla vai
     * oikealla napilla, ja lisäksi missä kohti.
     *
     * @param me Hiiren painaus
     */
    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getX() < 20 || me.getY() < 20) {
            return;
        }
        if (me.getButton() == MouseEvent.BUTTON1) {
            kl.vasenKlikkaus((me.getX() - 20) / 20, (me.getY() - 20) / 20);
        }
        if (me.getButton() == MouseEvent.BUTTON3) {
            kl.oikeaKilikkaus((me.getX() - 20) / 20, (me.getY() - 20) / 20);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
