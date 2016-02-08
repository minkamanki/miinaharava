/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharavaprojekti.miinaharavaprojekti.kayttoliityma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import miinaharavaprojekti.miinaharavaprojekti.pelilogiikka.Peli;

/**
 *
 * @author tminka
 */
public class Kayttoliittyma implements Runnable {

    private Peli peli;
    private Mouselistener hiiri;
    private JFrame frame;

    public Kayttoliittyma() {
        peli = new Peli();
        hiiri = new Mouselistener();
    }

    public void run() {
        frame = new JFrame("Miinaharava");
        frame.setPreferredSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoValikko(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
     
    }

    private void luoValikko(Container container) {
        container.add(new Valikko(peli));

    }

}
