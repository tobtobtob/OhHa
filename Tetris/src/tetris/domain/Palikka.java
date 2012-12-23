
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
    
    /**
     * Metodi tarkistaa, onko palikan ruudukko parametrina annetulla rivillä. 
     * Jos rivi on palikan alapuolella, palikka putoaa yhden ruudun alaspäin.
     * Jos rivi on palikan yläpuolella, metodi ei tee mitään.
     * Jos rivi on palikan kohdalla, metodi poistaa kyseisen rivin kutsumalla
     * pudotaRivi() metodia.
     *
     * @param ruudukon rivi, jolta poistetaan kaikki palikoiden osat. 
     */
    public void poistaRivi(int rivi){
        if (rivi<y){
            return;
        }
        else if (rivi>y+ruudukko.length-1){
            y += 1;
        }
        else{
           pudotaRivi(rivi-y); 
        }
        
    }
    /**
     * Metodi palauttaa taulukon, joka on yhden käännöksen verran oikealle 
     * käännetty versio palikan ruudukosta.
     * 
     * @return käännetty ruudukko 
     */
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
    
    /**
     * Metodi siirtää palikkaa yhden ruudun verran parametrina annettuun 
     * suuntaan.
     * 
     * @param suunta, johon palikkaa siirretään 
     */
    public void siirra(Suunta suunta) {
        if(suunta == Suunta.OIKEA){
            x += 1;
        }
        else if (suunta == Suunta.ALAS){
            y+= 1;
        }
        else if(suunta == Suunta.VASEN){
            x -=1;         
                    
        }
        
    }
    /**
     * Metodi pudottaa  palikan ruudukosta parametrina annetun rivin. Kyseinen 
     * rivi poistetaan, ja jokaista sen yläpuolella olevaa riviä siirretään yksi
     * rivi alaspäin.
     * 
     * @param rivi, jolta poistetaan palikan osat.  
     */

    private void pudotaRivi(int ruudukonRivi) {
        
        for (int i = ruudukonRivi-1; i >=0; i--) {
            for (int j = 0; j < ruudukko.length; j++) {
                ruudukko[i+1][j] = ruudukko[i][j];
            }
 
        }
        for (int i = 0; i < ruudukko.length; i++) {
            ruudukko[0][i] = false;
        }

    }
   
}
