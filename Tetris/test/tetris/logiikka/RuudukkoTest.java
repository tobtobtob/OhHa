package tetris.logiikka;


import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.logiikka.Palikka;
import tetris.logiikka.Ruudukko;
import tetris.logiikka.palikat.Nelio;
import tetris.logiikka.palikat.PalikkaJ;
import tetris.logiikka.palikat.Suora;


public class RuudukkoTest {
    
    private Ruudukko ruudukko;
    private Palikka palikka;
    private ArrayList<Palikka> palikat;
    
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
        palikat = new ArrayList<Palikka>();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void luotuRuudukkoTyhja(){
        assertEquals(-1, ruudukko.palautaTaysiRivi());
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
    public void palautusOikeaKunEiTaysiaRiveja(){
        assertEquals(ruudukko.palautaTaysiRivi(), -1);
    }
    
    @Test
    public void loytaaTaydenRivin(){
        
        
        palikat.add(new Nelio(0, 5));
        palikat.add(new PalikkaJ(2, 4));
        palikat.add(new Nelio(4, 6));
        palikat.add(new Nelio(6, 5));
        ruudukko.paivitaPalikat(palikat);
        assertEquals(ruudukko.palautaTaysiRivi(), 6);
    }
    @Test
    public void loytaaUseammanTaydenRivin(){
        
        palikat.add(new Nelio(0,4));
        palikat.add(new Nelio(2,4));
        palikat.add(new Nelio(4, 4));
        palikat.add(new Nelio(6, 4));
        ruudukko.paivitaPalikat(palikat);
    
    }
    @Test
    public void tyhjennysToimii(){
        palikat.add(new Nelio(0,4));
        palikat.add(new Nelio(2,4));
        palikat.add(new Nelio(4, 4));
        palikat.add(new Nelio(6, 4));
        ruudukko.paivitaPalikat(palikat);
        ruudukko.tyhjenna();
        assertEquals(-1, ruudukko.palautaTaysiRivi());
    }
}
