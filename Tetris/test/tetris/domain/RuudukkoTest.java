package tetris.domain;


import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.Palikka;
import tetris.domain.Ruudukko;
import tetris.domain.palikat.Nelio;
import tetris.domain.palikat.PalikkaJ;
import tetris.domain.palikat.Suora;


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
        palikka = new Nelio(0,0);
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
    public void palautusOikeaKunEiTaysiaRiveja(){
        assertEquals(ruudukko.palautaTaysiRivi(), -1);
    }
    
    @Test
    public void loytaaTaydenRivin(){
        
        ArrayList<Palikka> palikat = new ArrayList<Palikka>();
        palikat.add(new Nelio(0, 5));
        palikat.add(new PalikkaJ(2, 4));
        palikat.add(new Nelio(4, 6));
        palikat.add(new Nelio(6, 5));
        ruudukko.paivitaPalikat(palikat);
        assertEquals(ruudukko.palautaTaysiRivi(), 6);
    }
}
