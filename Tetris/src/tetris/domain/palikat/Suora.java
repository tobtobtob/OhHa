
package tetris.domain.palikat;

import java.awt.Color;
import tetris.domain.Palikka;


public class Suora extends Palikka {
    /**
     * Konstruktori luo luokan nimen mukaisen palikan
     * @param palikan x-koordinaatti
     * @param palikan y-koordinaatti
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