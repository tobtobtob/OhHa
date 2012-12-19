package tetris.domain;



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
import tetris.domain.palikat.PalikkaT;
import tetris.domain.palikat.PalikkaZ;


public class PalikkaTest {
    private Palikka palikka;
    private Ruudukko ruudukko;
    
    public PalikkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        palikka = new Nelio(0, 0);
        ruudukko = new Ruudukko(8, 10);
    }
    
    @After
    public void tearDown() {
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
            { false, false , false },
            { true, true, true }
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
    }
}
