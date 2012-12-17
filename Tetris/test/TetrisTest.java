/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import tetris.domain.palikat.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.*;
import tetris.domain.*;

/**
 *
 * @author topi
 */
public class TetrisTest {
    private Palikka palikka;
    private Ruudukko ruudukko;
    
    public TetrisTest() {
    }
       
    
    @Before
    public void setUp() {
        palikka = new Nelio(0, 0);
        ruudukko = new Ruudukko(8, 10);
    }
    @Test
    public void voiSiirtyaTyhjaanRuutuun(){
        
        assertTrue(ruudukko.voikoSiirtya(palikka, 5, 5));
    }
    @Test 
    public void eiVoiSiirtyaRuudukonUlkopuolelle(){
        assertFalse(ruudukko.voikoSiirtya(palikka, 5, 9));
    }
    @Test
    public void voiSiirtyaRuudukonReunaan(){
        assertTrue(ruudukko.voikoSiirtya(palikka, 6, 5));
    }
   
   
}
