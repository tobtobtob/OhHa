/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.domain.palikat;

import java.awt.Color;
import tetris.domain.Palikka;

/**
 *
 * @author topi
 */
public class PalikkaS extends Palikka {

    public PalikkaS(int x, int y) {
        super(x, y, Color.WHITE);
        boolean[][] uusiRuudukko = {
            { false, false, false },
            { false, true , true },
            { true, true, false }
        };
        super.ruudukko = uusiRuudukko;
    }
}

                
        
    
    
