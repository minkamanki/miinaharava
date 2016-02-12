/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.minka.miinaharava.pelilogiikka;

/**
 *
 * @author tminka
 */
public class Peli {
    
    private int leveys;
    private int korkeus;
    private Kentta kentta;

    public void luoKentta(int taso) {
         //kentta voi olla vain 9x9, 16x16 tai 16x30
        if (taso == 1) {
            kentta = new Kentta(9, 9);
            leveys = 9;
            korkeus = 9;
        } else if (taso == 2) {
            kentta = new Kentta(16, 16);
            leveys = 16;
            korkeus = 16;
        } else {
            kentta = new Kentta(16, 30);
            leveys = 30;
            korkeus = 16;

        }
    }
   
    public Kentta getKentta(){
        return kentta;
    }
    
    public int getLeveys(){
        return leveys;
    }
    
    public int getKorkeus(){
        return korkeus;
    }
}
