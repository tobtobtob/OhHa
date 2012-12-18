
package tetris.domain.palikat;

import java.awt.Color;
import tetris.domain.Palikka;


public class PalikkaZ extends Palikka {

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
