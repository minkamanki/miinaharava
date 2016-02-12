/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fi.minka.miinaharava.pelilogiikka;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import fi.minka.miinaharava.pelilogiikka.Kentta;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author tminka
 */
public class HelppoKenttaTest {
    
    ByteArrayOutputStream tulosvirta;
    Kentta kentta;
    
    @Before
    public void setUp() {
        tulosvirta = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tulosvirta));
        kentta = new Kentta(9,9);
    }
    
    @Test
    public void oikeaMaaraMiinoja(){
        int miinoja = 0;
        kentta.tulostaKentta();
        
        String tuloste = tulosvirta.toString();
        
        
        for (int i = 0; i < tuloste.length(); i++) {
            if(tuloste.charAt(i) == 'x'){
                miinoja++;
            }
        }
        
        assertEquals(10, miinoja);
        
    }

}
