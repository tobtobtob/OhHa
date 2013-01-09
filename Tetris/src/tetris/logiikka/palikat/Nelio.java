
package tetris.logiikka.palikat;

import java.awt.Color;
import tetris.logiikka.Palikka;

public class Nelio extends Palikka {
    /**
     * Konstruktori luo luokan nimen muotoisen palikan
     * @param palikan x-koordinaatti
     * @param palikan y-koordinaatti
     */
    public Nelio(int x, int y){
        super(x, y, Color.ORANGE);
        boolean[][] uusiRuudukko = {
            {true, true},
            {true, true}
        };
        
        super.ruudukko = uusiRuudukko;
      }
}

   
    

