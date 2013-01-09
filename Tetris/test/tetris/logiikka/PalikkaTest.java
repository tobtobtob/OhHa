package tetris.logiikka;



import tetris.logiikka.Suunta;
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
import tetris.logiikka.palikat.PalikkaT;
import tetris.logiikka.palikat.PalikkaZ;


public class PalikkaTest {
    private Palikka palikka;
    private Ruudukko ruudukko;
    
    public PalikkaTest() {
    }
    
    @Before
    public void setUp() {
        palikka = new Nelio(0, 0);
        ruudukko = new Ruudukko(8, 10);
    }
    @Test
    public void luotuPalikkaOikeanMuotoinen(){
        palikka = new PalikkaJ(0,0);
        boolean[][] oletus = {
            { false, true, false },
            { false, true , false },
            { true, true, false }
        };
        assertArrayEquals(oletus, palikka.getRuudukko());
    }
    @Test 
    public void kaantaminenToimii(){
        boolean[][] kaannettyZ = {
            { false, true, false },
            { true, true , false },
            { true, false, false }
        };
        palikka = new PalikkaZ(0,0);
        assertArrayEquals(palikka.luoKaannos(), kaannettyZ);
    }
    
    @Test
    public void rivinPoistoToimiiPalikalle(){
        boolean[][] poistettu = {
            { false, false, false },
            { false, true , false },
            { false, false, false }
        };
        palikka = new PalikkaT(0,0);
        palikka.poistaRivi(1);
        assertArrayEquals(palikka.getRuudukko(), poistettu);
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
        assertArrayEquals(palikka.getRuudukko(), poistettu);
    }
    @Test
    public void palikanSiirtaminenToimii(){
        palikka.siirra(Suunta.OIKEA);
        assertEquals(1, palikka.getX());
        palikka.siirra(Suunta.ALAS);
        assertEquals(1, palikka.getY());
        
    
    }
    @Test
    public void onkoTyhjaMetodiToimii(){
       boolean[][] tyhja = {
            { false, false, false },
            { false, false , false },
            { false, false, false }
        };
       palikka.setRuudukko(tyhja);
       assertTrue(palikka.onkoTyhja());
    }
    @Test
    public void onkoTyhjaToimiiJosPalikkaEiTyhja(){
        assertFalse(palikka.onkoTyhja());
    }
    
}
