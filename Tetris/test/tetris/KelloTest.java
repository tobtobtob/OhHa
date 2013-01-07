/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KelloTest {
    private Kello kello;
    private Ohjain ohjain;
    
    public KelloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ohjain = new Ohjain(10,10);
        kello = new Kello(ohjain);
        
    }
    @Test
    public void kellossaOikeaViive(){
        kello.paivita();
        assertEquals(1000, kello.getDelay());
        
    }
   
}
