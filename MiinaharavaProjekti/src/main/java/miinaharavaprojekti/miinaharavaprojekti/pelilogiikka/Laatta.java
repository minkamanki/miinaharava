/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package miinaharavaprojekti.miinaharavaprojekti.pelilogiikka;

/**
 *
 * @author tminka
 */
public class Laatta {
    private boolean avattu;
    private boolean miinallinen;
    private boolean liputettu;
    private int vihje;
    
    public Laatta(){
        this.avattu = false;
        this.miinallinen = false;
        this.liputettu = false;
        this.vihje = 0; 
    }
    
    
    public void avaa(){
        this.avattu = true;
    }
    
    public void liputa(){
        this.liputettu = true;    
    }
    
    public void poistaLiputus(){
        this.liputettu = false;
    }
    
    public void miinoita(){
        this.miinallinen = true;
    }
    
    public void kosketukset(int maara){
        this.vihje = maara;
    }

    public boolean onkoAvattu(){
        return avattu;
    }
    
    public boolean onkoMiinallinen(){
        return miinallinen;
    }
    
    public boolean onkoLippu(){
        return liputettu;
    }
    
    public int getVihje(){
        return vihje;
    }
}
