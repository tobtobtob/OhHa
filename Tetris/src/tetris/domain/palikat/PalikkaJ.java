
package tetris.domain.palikat;

import java.awt.Color;
import tetris.domain.Palikka;


public class PalikkaJ extends Palikka {

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
