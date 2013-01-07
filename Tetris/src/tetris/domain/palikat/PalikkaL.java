
package tetris.domain.palikat;

import java.awt.Color;
import tetris.domain.Palikka;


public class PalikkaL extends Palikka {
    /**
     * Konstruktori luo luokan nimen mukaisen palikan
     * @param palikan x-koordinaatti
     * @param palikan y-koordinaatti
     */
    public PalikkaL(int x, int y) {
        super(x, y, Color.RED);
        boolean[][] uusiRuudukko = {
            { false, true, false },
            { false, true , false },
            { false, true, true }
        };
        super.ruudukko = uusiRuudukko;
    }
    
}
