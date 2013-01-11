
package tetris.logiikka.palikat;

import java.awt.Color;
import tetris.logiikka.Palikka;

/**
 * s-kirjaimen muotoinen palikka
 */
public class PalikkaS extends Palikka {
    /**
     * Konstruktori luo luokan nimen muotoisen palikan
     * @param x palikan x-koordinaatti
     * @param y palikan y-koordinaatti
     */
    public PalikkaS(int x, int y) {
        super(x, y, Color.CYAN);
        boolean[][] uusiRuudukko = {
            { false, false, false },
            { false, true , true },
            { true, true, false }
        };
        super.ruudukko = uusiRuudukko;
    }
}

                
        
    
    

