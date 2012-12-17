
package tetris.domain.palikat;

import java.awt.Color;
import tetris.domain.Palikka;

public class Nelio extends Palikka {
    
    public Nelio(int x, int y){
        super(x, y, Color.ORANGE);
        boolean[][] uusiRuudukko = {
            {true, true},
            {true, true}
        };
        
        super.ruudukko = uusiRuudukko;
      }
}

   
    

