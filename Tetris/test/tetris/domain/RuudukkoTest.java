package tetris.domain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.Palikka;
import tetris.domain.Ruudukko;
import tetris.domain.palikat.Suora;

/**
 *
 * @author topi
 */
public class RuudukkoTest {
    
    private Ruudukko ruudukko;
    private Palikka palikka;
    
    public RuudukkoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ruudukko = new Ruudukko(8,10);
    }
    
    @After
    public void tearDown() {
    }
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
    public void ruudukkoLoytaaTaydetRivit(){
        
    }
}
