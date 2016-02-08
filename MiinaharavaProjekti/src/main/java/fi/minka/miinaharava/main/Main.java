/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharavaprojekti.miinaharavaprojekti.main;

import javax.swing.SwingUtilities;
import miinaharavaprojekti.miinaharavaprojekti.kayttoliityma.Kayttoliittyma;

/*()
 *
 * @author tminka
 */
public class Main {
    
    public static void main(String[] args){
        Kayttoliittyma kl = new Kayttoliittyma();
        SwingUtilities.invokeLater(kl);
    }
    
}
