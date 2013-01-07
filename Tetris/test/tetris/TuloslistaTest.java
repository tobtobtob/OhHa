/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import tetris.tuloslista.Tuloslista;
import java.util.ArrayList;
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
public class TuloslistaTest {
    
    private Tuloslista lista;
    
    public TuloslistaTest() {
       
    }
    
    
    @Before
    public void setUp() {
        lista = new Tuloslista();
        lista.tyhjenna();
    }
    
    @Test
    public void listaLukeeJaAntaaOikeanTuloksen(){
        
        lista.kirjoitaTulos("nakki", 3);
        String tulos = lista.getTulokset(1).get(0);
        assertEquals("nakki, 3 pistettä", tulos);
        
    }
    @Test
    public void kahdenTuloksenKirjoittaminenJaLukuToimii(){
        
        lista.kirjoitaTulos("herp", 3);
        lista.kirjoitaTulos("derp", 99);
        ArrayList<String> tulokset = lista.getTulokset(10);
        assertEquals("derp, 99 pistettä", tulokset.get(0));
        assertEquals("herp, 3 pistettä", tulokset.get(1));
    }
    
    
}
