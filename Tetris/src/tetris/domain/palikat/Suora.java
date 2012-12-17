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
public class Suora extends Palikka {

    public Suora(int x, int y) {
        super(x, y, Color.GREEN);
        boolean[][] uusiRuudukko = {
            {false, true, false, false},
            {false, true, false, false},
            {false, true, false, false},
            {false, true, false, false}
        };
        super.ruudukko = uusiRuudukko;
             
        
    }
}
