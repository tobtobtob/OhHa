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
    @Test
    public void voiSiirtyaRuudukonPohjalle(){
        palikka = new Suora(0,0);
        palikka.setRuudukko(palikka.luoKaannos());
        assertTrue(ruudukko.voikoSiirtya(palikka, 4, 8));
    }
    @Test
    public void eiVoiSiirtyaToisenPalikanPaalle(){
        Palikka palikka1 = new Suora(4, 6);
        ruudukko.paivitaPalikka(palikka1);
        assertFalse(ruudukko.voikoSiirtya(palikka, 4, 8));
    }
    @Test
    public void voiSiirtyaToisenPalikanViereen(){
        Palikka palikka1 = new Suora(4, 6);
        ruudukko.paivitaPalikka(palikka1);
        assertTrue(ruudukko.voikoSiirtya(palikka, 3, 8));
    }
    @Test 
    public void kaantaminenToimii(){
        boolean[][] kaannettyZ = {
            { false, true, false },
            { true, true , false },
            { true, false, false }
        };
        palikka = new PalikkaZ(0,0);
        assertEquals(palikka.luoKaannos(), kaannettyZ);
    }
    @Test
    public void rivinPoistoToimiiPalikalle(){
        boolean[][] poistettu = {
            { false, false, false },
            { false, false , false },
            { true, true, true }
        };
        palikka = new PalikkaT(0,0);
        palikka.poistaRivi(1);
        assertEquals(palikka.getRuudukko(), poistettu);
    }
    @Test
    public void rivinPoistoToimiiPalikalleRuudukossa(){
        boolean[][] poistettu = {
            { false, false, false },
            { false, true , false },
            { false, true, false }
        };
        palikka = new PalikkaJ(5, 5);
        palikka.poistaRivi(7);
        assertEquals(palikka.getRuudukko(), poistettu);
    }
    @Test
    public void ruudukkoLoytaaTaydetRivit(){
        
    }
   
   
}
