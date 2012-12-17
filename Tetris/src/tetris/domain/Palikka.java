
package tetris.domain;


import java.awt.Color;
import java.util.*;

public abstract class Palikka {
    
    protected boolean ruudukko[][];
    private Color vari;
    private int x, y;

    public Palikka(int x, int y, Color vari) {
        
        this. x = x;
        this.y = y;
        this.vari = vari;
    }
    
    public boolean[][] luoKaannos(){
        
        boolean[][] uusiRuudukko = new boolean[ruudukko.length][ruudukko.length];
        
        for (int i = ruudukko.length-1, a=0; i >= 0; i--, a++) {
            for (int j = 0, b=0; j <ruudukko.length ; j++, b++) {
                uusiRuudukko[a][b] = ruudukko[j][i];
            }
        }
        return uusiRuudukko;
        
    
    }

    public void setRuudukko(boolean[][] ruudukko) {
        this.ruudukko = ruudukko;
    }

    public boolean[][] getRuudukko() {
        return ruudukko;
    }
    
    
    public void siirra(Suunta suunta){
        
    }
    
    public Color getVari(){
        return vari;
    }
   
}
