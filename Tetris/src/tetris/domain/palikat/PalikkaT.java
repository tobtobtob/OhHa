
package tetris.domain.palikat;

import java.awt.Color;
import tetris.domain.Palikka;


public class PalikkaT extends Palikka {
    /**
     * Konstruktori luo luokan nimen mukaisen palikan
     * @param palikan x-koordinaatti
     * @param palikan y-koordinaatti
     */
    public PalikkaT(int x, int y) {
        super(x, y, Color.LIGHT_GRAY);
        boolean[][] uusiRuudukko = {
            { false, false, false },
            { false, true , false },
            { true, true, true }
        };
        super.ruudukko = uusiRuudukko;
    }
    
}
