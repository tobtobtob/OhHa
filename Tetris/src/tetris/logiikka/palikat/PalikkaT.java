
package tetris.logiikka.palikat;

import java.awt.Color;
import tetris.logiikka.Palikka;

/**
 * t-kirjaimen muotoinen palikka
 */
public class PalikkaT extends Palikka {
    /**
     * Konstruktori luo luokan nimen muotoisen palikan
     * @param x palikan x-koordinaatti
     * @param y palikan y-koordinaatti
     */
    public PalikkaT(int x, int y) {
        super(x, y, Color.LIGHT_GRAY);
        boolean[][] uusiRuudukko = {
            { false, true, false },
            { true, true , true },
            { false, false, false }
        };
        super.ruudukko = uusiRuudukko;
    }
    
}
