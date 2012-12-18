
package tetris.domain.palikat;

import java.awt.Color;
import tetris.domain.Palikka;


public class PalikkaT extends Palikka {

    public PalikkaT(int x, int y) {
        super(x, y, Color.BLACK);
        boolean[][] uusiRuudukko = {
            { false, false, false },
            { false, true , false },
            { true, true, true }
        };
        super.ruudukko = uusiRuudukko;
    }
    
}
