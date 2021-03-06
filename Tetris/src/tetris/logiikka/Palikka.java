
package tetris.logiikka;

import java.awt.Color;
/**
 * Yhtä palikkaa kuvaava luokka. Palikka tarjoaa kaikki palikkaan liittyvät
 * toiminnallisuudet kuten kääntäminen ja siirtäminen
 * 
 */
public abstract class Palikka {
    
    /**
     * Palikan muodon pelikentällä määrittävä totuusarvoja sisältävä taulukko
     */
    protected boolean ruudukko[][];
    /**
     * Palikan väri
     */
    private final Color vari;
    /**
     * Palikan taulukon (ruudun 0,0) sijainti pelialueella
     */
    private int x, y;
    
    /**
     * Palikan konstruktorissa määritetään sen koordinaatit ja väri. 
     * 
     * @param x palikan x-sijainti
     * @param y palikan y-sijainti
     * @param vari palikan väri
     */
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
     * @param rivi ruudukon rivi, jolta poistetaan kaikki palikoiden osat. 
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
    /**
     * Palauttaa palikan x-sijainnin.
     * 
     * @return x
     */
    public int getX() {
        return x;
    }
    /**
     * Palauttaa palikan y-sijainnin.
     * 
     * @return y
     */
    public int getY() {
        return y;
    }
    /**
     * Asettaa palikan ruudukon parametrina annetuksi ruudukoksi.
     * 
     * @param ruudukko 
     */
    public void setRuudukko(boolean[][] ruudukko) {
        this.ruudukko = ruudukko;
    }
    /**
     * Palauttaa palikan ruudukon.
     * 
     * @return ruudukko
     */
    public boolean[][] getRuudukko() {
        return ruudukko;
    }
    /**
     * Metodi käy läpi palikan ruudukon, ja palauttaa false, jos palikassa on 
     * paloja (true-arvoisia alkioita) jäljellä. Jos palikka on tyhjä metodi 
     * palauttaa true.
     * 
     * @return true, jos palikassa on paloja, false, jos palikka on tyhjä
     */
    public boolean onkoTyhja(){
        for (int rivi = 0; rivi < ruudukko.length; rivi++) {
            for (int sarake = 0; sarake < ruudukko.length; sarake++) {
                if(ruudukko[rivi][sarake]){
                        return false;
                }
            }
        }
        return true;
    }
   
    /**
     * Palauttaa palikan värin (Color).
     * 
     * @return palikan väri
     */
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
     * @param ruudukonRivi rivi, jolta poistetaan palikan osat.  
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
