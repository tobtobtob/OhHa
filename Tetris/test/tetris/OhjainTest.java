
package tetris;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.Palikka;
import tetris.domain.Suunta;
import tetris.domain.palikat.Nelio;
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
    @Test
    public void palikanSiirtaminenToimii(){
        ohjain.luoAktiivinenPalikka();
        palikka = ohjain.getAktiivinen();
        int x = palikka.getX();
        int y = palikka.getY();
        ohjain.siirraPalikkaa(Suunta.OIKEA);
        ohjain.siirraPalikkaa(Suunta.ALAS);
        assertEquals(x+1, palikka.getX());
        assertEquals(y+1, palikka.getY());
        
    }
    
    @Test
    public void uusiAktiivinenPalikkaOnOikeassaPaikassa(){
        int koko = 20;
        ohjain = new Ohjain(koko, 20);
        ohjain.luoAktiivinenPalikka();
        palikka = ohjain.getAktiivinen();
        assertEquals(koko/2-2, palikka.getX());
        assertEquals(0, palikka.getY());
    }
    
//    @Test
//    public void eiVoiSiirtaaRuudukonUlkopuolelle(){
//        ohjain.luoAktiivinenPalikka();
//        palikka = ohjain.getAktiivinen();
//        for (int i = 0; i < 10; i++) {
//            ohjain.siirraPalikkaa(Suunta.VASEN);
//            
//        }
//        assertEquals(0, palikka.getX());
//        assertEquals(0, palikka.getY());
    
    public void lisaaPalikat(Palikka... palikat){
        for (Palikka lisattava : palikat) {
            ohjain.lisaaPalikka(lisattava);
        }
    }
    
}
