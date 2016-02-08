/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharavaprojekti.miinaharavaprojekti.pelilogiikka;

import java.util.Random;

/**
 *
 * @author tminka
 */
public class Kentta {
    //pelialueen koko tulee aina olemaan 9x9, 16x16 tai 30x16.

    private final Laatta[][] pelialue;
    private final int korkeus;
    private final int leveys;

    public Kentta(int korkeus, int leveys) {
        pelialue = new Laatta[korkeus][leveys];
        this.korkeus = korkeus;
        this.leveys = leveys;
        luoPelialue();
    }

    private void luoPelialue() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                this.pelialue[i][j] = new Laatta();
            }
        }
        
        asetaMiinat();

    }

    public void asetaMiinat() {
        Random r = new Random();
        int miinoja = 0;

        if (leveys == 9) {
            miinoja = 10;
        } else if (leveys == 16) {
            miinoja = 40;
        } else if (leveys == 30) {
            miinoja = 99;
        }

        for (int i = 0; i < miinoja; i++) {
            int x = r.nextInt(korkeus);
            int y = r.nextInt(leveys);
            while (pelialue[x][y].onkoMiinallinen()) {
                x = r.nextInt(korkeus);
                y = r.nextInt(leveys);
            }

            pelialue[x][y].miinoita();
            asetaVihjeet(x, y);

        }

    }

    public void tulostaKentta() {
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                if (pelialue[i][j].onkoMiinallinen()) {
                    System.out.print("x");
                } else {
                    System.out.print(pelialue[i][j].getVihje());
                }
            }
            System.out.println("");
        }
    }

    public void liputus(int x, int y) {
        if (pelialue[x][y].onkoLippu()) {
            pelialue[x][y].poistaLiputus();
        } else {
            pelialue[x][y].liputa();
        }
    }

    public void asetaVihjeet(int x, int y) {
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (!(i < 0) && i<korkeus && !(j<0) && j<leveys){
                    pelialue[i][j].kasvataVihjettaYhdella();
                }
            }
        }
    }


    public int annaVihje(int x, int y) {
        return pelialue[x][y].getVihje();
    }
    
    public boolean onkoAvattu(int x, int y){
        return  pelialue[x][y].onkoAvattu();
    }
    
    public boolean onkoMiinaa(int x, int y){
        return pelialue[x][y].onkoMiinallinen();
    }
    
    public void avaa(int x, int y){
        pelialue[x][y].avaa();
    }

}
