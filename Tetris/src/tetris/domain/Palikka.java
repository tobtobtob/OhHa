
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
    
    public void poistaRivi(int rivi){
        if (rivi<y){
            return;
        }
        else if (rivi>y+ruudukko.length-1){
            y += 1;
        }
        else{
           pudotaRivi(rivi); 
        }
        
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

    private void pudotaRivi(int rivi) {
        int ruudukonRivi = rivi-y;
        
        for (int i = ruudukonRivi-1; i >=0; i--) {
            for (int j = 0; j < ruudukko.length; j++) {
                ruudukko[i+1][j] = ruudukko[i][j];
            }
 
        }
        for (int i = 0; i < ruudukko.length; i++) {
            ruudukko[0][i] = false;
        }
//        ruudukko[1][1] = true;
    }
   
}
