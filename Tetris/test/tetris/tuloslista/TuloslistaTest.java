
package tetris.tuloslista;

import tetris.tuloslista.Tuloslista;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TuloslistaTest {
    
    private Tuloslista lista;
    
    public TuloslistaTest() {
       
    }
    
    
    @Before
    public void setUp() {
        lista = new Tuloslista();
        lista.tyhjenna();
    }
    @After
    public void tyhjennys(){
        lista.tyhjenna();
    }
    @Test
    public void listaLukeeJaAntaaOikeanTuloksen(){
        
        lista.kirjoitaTulos("nakki", 3);
        String tulos = lista.getTulokset(1);
        assertEquals("nakki, 3 pistettä\n", tulos);
        
    }
    @Test
    public void kahdenTuloksenKirjoittaminenJaLukuToimii(){
        
        lista.kirjoitaTulos("herp", 3);
        lista.kirjoitaTulos("derp", 99);
        String[] tulokset = lista.getTulokset(10).split("\n");
        assertEquals("derp, 99 pistettä", tulokset[0]);
        assertEquals("herp, 3 pistettä", tulokset[1]);
    }
    @Test
    public void palautusOikeaJosTuloslistaTyhja(){
        assertEquals("<ei tuloksia>", lista.getTulokset(1));
    }
    
}
