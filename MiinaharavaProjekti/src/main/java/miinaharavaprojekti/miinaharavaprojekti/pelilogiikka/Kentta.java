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

    private Laatta[][] pelialue;

    public Kentta() {
        pelialue = new Laatta[10][10];
        luoPelialue();
    }

    private void luoPelialue() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.pelialue[i][j] = new Laatta();
            }
        }

    }

    private void asetaMiinat() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int x = r.nextInt(10);
            int y = r.nextInt(10);
            while (pelialue[x][y].onkoMiinallinen()) {
                x = r.nextInt(10);
                y = r.nextInt(10);
            }
            
            pelialue[x][y].miinoita();
            
        }

    }

}
