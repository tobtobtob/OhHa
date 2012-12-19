
package tetris.domain.palikat;

import java.awt.Color;
import tetris.domain.Palikka;


public class PalikkaS extends Palikka {

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

                
        
    
    

