
package tetris.domain;


import java.awt.Color;

public abstract class Palikka {
    
    protected boolean ruudukko[][];
    private Color vari;
    private int x, y;

    public Palikka(int x, int y, Color vari) {
        
        this.x = x;
        this.y = y;
        this.vari = vari;
    }
    
    public boolean[][] luoKaannos(){
        
        boolean[][] uusiRuudukko = new boolean[ruudukko.length][ruudukko.length];
        
        for (int i = 0, a=0; a <ruudukko.length; i++, a++) {
            for (int j = ruudukko.length-1, b=0; b <ruudukko.length ; j--, b++) {
                uusiRuudukko[a][b] = ruudukko[j][i];
            }
        }
        return uusiRuudukko;
        
    
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setRuudukko(boolean[][] ruudukko) {
        this.ruudukko = ruudukko;
    }

    public boolean[][] getRuudukko() {
        return ruudukko;
    }
    
    
   
    
    public Color getVari(){
        return vari;
    }

    public void siirra(Suunta suunta) {
        if(suunta == Suunta.OIKEA){
            x += 1;
        }
        if (suunta == Suunta.ALAS){
            y+= 1;
        }
        if(suunta == Suunta.VASEN){
            x -=1;         
                    
        }
        
    }
   
}
