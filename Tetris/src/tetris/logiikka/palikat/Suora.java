
package tetris.logiikka.palikat;

import java.awt.Color;
import tetris.logiikka.Palikka;

/**
 * suorakulmion muotoinen palikka
 */
public class Suora extends Palikka {
    /**
     * Konstruktori luo luokan nimen muotoisen palikan
     * @param x palikan x-koordinaatti
     * @param y palikan y-koordinaatti
     */
    public Suora(int x, int y) {
        super(x, y, Color.MAGENTA);
        boolean[][] uusiRuudukko = {
            {false, true, false, false},
            {false, true, false, false},
            {false, true, false, false},
            {false, true, false, false}
        };
        super.ruudukko = uusiRuudukko; 
             
        
    }
}