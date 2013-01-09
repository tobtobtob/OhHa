/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.tuloslista;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author topi
 */
public class TulosTest {
    private Tulos tulos;
    
    public TulosTest() {
    }
    
    @Before
    public void setUp() {
        tulos = new Tulos(9001, "krokotiili");
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void luodessaOikeatPisteetJaNimimerkki(){
        assertEquals("krokotiili", tulos.getNimi());
        assertEquals(9001, tulos.getPisteet());
    }
    @Test
    public void toStringAntaaOikeanEsitysmuodon(){
        assertEquals("krokotiili, 9001 pistettä", tulos.toString());
    }
    
}
