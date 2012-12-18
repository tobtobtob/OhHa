
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
        
        for (int i = 0, a=0; i <ruudukko.length; i++, a++) {
            for (int j = 0, b=0; j <ruudukko.length ; j++, b++) {
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
    
    
    public void siirra(Suunta suunta){
        
    }
    
    public Color getVari(){
        return vari;
    }

    public void siirrä(Suunta suunta) {
        switch(suunta){
            case ALAS: y += 1;
        }
    }
   
}
