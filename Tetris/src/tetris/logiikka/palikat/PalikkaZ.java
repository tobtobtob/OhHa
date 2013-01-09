
package tetris.logiikka.palikat;

import java.awt.Color;
import tetris.logiikka.Palikka;

/**
 * z-kirjaimen muotoinen palikka
 */
public class PalikkaZ extends Palikka {
    /**
     * Konstruktori luo luokan nimen mukaisen palikan
     * @param palikan x-koordinaatti
     * @param palikan y-koordinaatti
     */
    public PalikkaZ(int x, int y) {
        super(x, y, Color.GREEN);
        boolean[][] uusiRuudukko = {
            { false, false, false },
            { true, true , false },
            { false, true, true }
        };
        super.ruudukko = uusiRuudukko;
    }
    
}
