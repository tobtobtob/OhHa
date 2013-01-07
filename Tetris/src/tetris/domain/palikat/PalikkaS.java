
package tetris.domain.palikat;

import java.awt.Color;
import tetris.domain.Palikka;


public class PalikkaS extends Palikka {
    /**
     * Konstruktori luo luokan nimen mukaisen palikan
     * @param palikan x-koordinaatti
     * @param palikan y-koordinaatti
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

                
        
    
    

