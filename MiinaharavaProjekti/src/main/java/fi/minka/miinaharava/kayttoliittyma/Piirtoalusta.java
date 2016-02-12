/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.minka.miinaharava.kayttoliittyma;

import fi.minka.miinaharava.pelilogiikka.Peli;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author tminka
 */
public class Piirtoalusta extends JPanel {

    private final Peli peli;

    public Piirtoalusta(Peli peli) {
        this.peli = peli;
    }

    public void piirraKentta(Graphics g) {
        for (int i = 0; i < peli.getLeveys(); i++) {
            for (int j = 0; j < peli.getKorkeus(); j++) {
                piirraLaatta(i, j, g);
            }
        }
    }

    public void piirraLaatta(int x, int y, Graphics g) {
//        ImageIcon lippu = new ImageIcon(getClass().getResource("flag.png"));
//        ImageIcon miina = new ImageIcon("mine.png");

        g.setColor(Color.BLACK);
        g.drawRect(20 + (x * 20), 20 + (y * 20), 20, 20);

        if (!peli.getKentta().onkoAvattu(x, y)) {
            g.setColor(Color.GRAY);
            g.fillRect(21 + (x * 20), 21 + (y * 20), 19, 19);
            if (peli.getKentta().onkoLippu(x, y)) {
//                lippu.paintIcon(this, g, 20, 20);

            }

        } else {
            if (peli.getKentta().onkoMiinaa(x, y)) {
//                miina.paintIcon(this, g, 19, 19);
            } else {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(21 + (x * 20), 21 + (y * 20), 19, 19);
                if (peli.getKentta().annaVihje(x, y) == 1) {

                } else if (peli.getKentta().annaVihje(x, y) == 1) {
                    g.setColor(Color.BLUE);

                } else if (peli.getKentta().annaVihje(x, y) == 2) {
                    g.setColor(Color.GREEN);

                } else if (peli.getKentta().annaVihje(x, y) == 3) {
                    g.setColor(Color.RED);

                } else if (peli.getKentta().annaVihje(x, y) == 4) {
                    g.setColor(new Color(30, 19, 76));

                } else if (peli.getKentta().annaVihje(x, y) == 5) {
                    g.setColor(new Color(76, 20, 27));

                } else if (peli.getKentta().annaVihje(x, y) == 6) {
                    g.setColor(Color.CYAN);

                } else if (peli.getKentta().annaVihje(x, y) == 7) {
                    g.setColor(new Color(114, 47, 86));

                } else {
                    g.setColor(Color.black);

                }
                g.drawString(""+ peli.getKentta().annaVihje(x, y), 20 + (x * 20), 20 + (y * 20));
              }
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Color.lightGray);
        piirraKentta(g);
    }
}
