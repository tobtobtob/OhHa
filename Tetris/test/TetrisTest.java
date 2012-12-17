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
        
        assertTrue(ruudukko.voikoSiirtya(palikka.getRuudukko(), 5, 5));
    }
    @Test 
    public void eiVoiSiirtyaRuudukonUlkopuolelle(){
        assertFalse(ruudukko.voikoSiirtya(palikka.getRuudukko(), 5, 9));
    }
    @Test
    public void voiSiirtyaRuudukonReunaan(){
        assertTrue(ruudukko.voikoSiirtya(palikka.getRuudukko(), 6, 5));
    }
    @Test
    public void voiSiirtyaRuudukonPohjalle(){
        palikka = new Suora(0,0);
        palikka.setRuudukko(palikka.luoKaannos());
        assertTrue(ruudukko.voikoSiirtya(palikka.getRuudukko(), 4, 8));
    }
    @Test
    public void eiVoiSiirtyaToisenPalikanPaalle(){
        Palikka palikka1 = new Suora(4, 6);
        ruudukko.paivitaPalikka(palikka1.getRuudukko(), palikka1.getX(), palikka1.getY());
        assertFalse(ruudukko.voikoSiirtya(palikka.getRuudukko(), 4, 8));
    }
    @Test
    public void voiSiirtyaToisenPalikanViereen(){
        Palikka palikka1 = new Suora(4, 6);
        ruudukko.paivitaPalikka(palikka1.getRuudukko(), palikka1.getX(), palikka1.getY());
        assertTrue(ruudukko.voikoSiirtya(palikka.getRuudukko(), 3, 8));
    }
   
   
}
