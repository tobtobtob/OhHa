
package tetris.logiikka.palikat;

import java.awt.Color;
import tetris.logiikka.Palikka;


public class PalikkaJ extends Palikka {
    /**
     * Konstruktori luo luokan nimen muotoisen palikan
     * @param palikan x-koordinaatti
     * @param palikan y-koordinaatti
     */
    public PalikkaJ(int x, int y) {
        super(x, y, Color.BLUE);
        boolean[][] uusiRuudukko = {
            { false, true, false },
            { false, true , false },
            { true, true, false }
        };
        super.ruudukko = uusiRuudukko;
    }
    
}
