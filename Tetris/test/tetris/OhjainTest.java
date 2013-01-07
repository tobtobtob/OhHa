
package tetris;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.Palikka;
import tetris.domain.palikat.PalikkaZ;
import tetris.domain.palikat.Suora;


public class OhjainTest {
    private Ohjain ohjain;
    private Palikka palikka, palikka2;
   
    
    
    public OhjainTest() {
    }
    
    @Before
    public void setUp() {
        ohjain = new Ohjain(10, 15);
        palikka = new PalikkaZ(0,0);
    }
    
    @Test
    public void tyhjienPalikoidenPoistoToimii(){
        
        boolean[][] tyhjaRuudukko = {
            { false, false, false },
            { false, false , false },
            { false, false, false }
        };
        palikka.setRuudukko(tyhjaRuudukko);
        ohjain.lisaaPalikka(palikka);
        assertEquals(1, ohjain.getPalikat().size());
        ohjain.poistaTyhjatPalikat();
        assertEquals(0, ohjain.getPalikat().size());
    }
    @Test
    public void eiPoistaPalikoitaJoissaPaloja(){
            boolean[][] tyhjaRuudukko = {
            { false, false, false },
            { false, false , false },
            { false, false, true }
        };
        palikka.setRuudukko(tyhjaRuudukko);
        ohjain.lisaaPalikka(palikka);
        assertEquals(1, ohjain.getPalikat().size());
        ohjain.poistaTyhjatPalikat();
        assertEquals(1, ohjain.getPalikat().size());
    }
    
    public void lisaaPalikat(Palikka... palikat){
        for (Palikka lisattava : palikat) {
            ohjain.lisaaPalikka(lisattava);
        }
    }
}
