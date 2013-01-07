
package tetris;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PistelaskuriTest {
    Pistelaskuri laskuri;
    
    public PistelaskuriTest() {
    }
    
    
    @Before
    public void setUp() {
        laskuri = new Pistelaskuri();
        
    }
    @Test
    public void pisteidenLisaysToimii(){
        laskuri.kasvataPisteita(4);
        assertEquals(800, laskuri.getPisteet());
        
    }
    @Test
    public void tasokasvaaKunRiittavastiPisteita(){
        laskuri.kasvataPisteita(4);
        laskuri.kasvataPisteita(4);
        laskuri.kasvataPisteita(4);
        assertEquals(3, laskuri.getTaso());
    }
    @Test
    public void luotaessaPisteetJaTaso0(){
        assertEquals(0, laskuri.getPisteet());
        assertEquals(1, laskuri.getTaso());
    }
    
    
}
