
package tetris.logiikka;

import java.util.ArrayList;
/**
 * Ruudukko pitää kirjaa pelialueella olevista palikoista totuusarvoja sisältävässä
 * taulukossaan. Ruudukon avulla tarkistetaan palikoiden liikkeiden ja käännöksien
 * laillisuus, ja poistetaan täyttyneet rivit.
 */
public class Ruudukko {
    /**
     * Pelialuetta kuvaava ruudukko, johon päivitetään palikat totuusarvoina true,
     * ja tyhjät ruudut totuusarvoina false
     */
    private boolean[][] ruudukko;
    /**
     * pelialueen leveys ruuduissa.
     */
    private final int leveys;
    /**
     * Pelialueen korkeus ruuduissa
     */
    private final int korkeus;
    /**
     * Konstruktori luo annettujen parametrien kokoisen taulukon jossa kaikki
     * alkiot ovat tyhjiä (eli false).
     * 
     * @param leveys ruudukon leveys   
     * @param korkeus ruudukon korkeus
     */
    public Ruudukko(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        ruudukko = new boolean[korkeus][leveys];
    }
    /**
     * Metodi sijoittaa muuttujaan ruudukko uuden samankokoisen taulukon.
     */
    public void tyhjenna(){
        ruudukko = new boolean[korkeus][leveys];
    }
    /**
     * Metodi käy läpi ruudukon rivejä, kunnes löytää rivin, jolla kaikki 
     * alkiot ovat "true"
     * 
     * @return ensimmäinen metodin löytämä rivi, jolla kaikki alkiot ovat "true"
     */
    public int palautaTaysiRivi(){
        int palikoita;
        for (int i = 0; i < korkeus; i++) {
            palikoita = 0;
            for (int j = 0; j < leveys; j++) {
                if(ruudukko[i][j]){
                    palikoita++;
                }
            }
            if(palikoita == leveys){
                return i;
            }
        }
        return -1;
    }
    /**
     * Metodi päivittää ruudukkoon parametrina annetun palikan. Jos palikan 
     * ruudukossa on arvo "true", metodi muuttaa ruudukkoon samaan paikkaan arvon
     * true.
     * 
     * @param paivitettava palikka, joka päivitetään ruudukkoon. 
     */
    
    public void paivitaPalikka(Palikka paivitettava){
       boolean[][] palikanRuudukko = paivitettava.getRuudukko();
        
        for (int i = 0; i < palikanRuudukko.length; i++) {
            for (int j = 0; j < palikanRuudukko.length; j++) {
                if(palikanRuudukko[i][j] == true){
                    ruudukko[paivitettava.getY()+i][paivitettava.getX()+j] = true;
                }
                
            }
        }
    }
    /**
     * Metodi tarkistaa voiko parametrina annettu palikka siirtyä ruutuun (x,y)
     * 
     * @param siirrettava palikka, jota siirretään
     * @param x siirryttävän ruudun x-koordinaatti
     * @param y siirryttävän ruudun y-koordinaatti
     * @return true, jos siirto mahdollinen, muuten false
     */
    public boolean voikoSiirtya(Palikka siirrettava, int x, int y){
        
        return voikoSiirtya(siirrettava.getRuudukko(), x, y);
    }
    
    /**
     * Metodi tarkistaa sopiiko parametrina annettu ruudukko ruudukon paikkaan 
     * (x,y).
     * 
     * @param palikanRuudukko
     * @param x siirryttävän paikan x-koordinaatti
     * @param y siirryttävän paikan y-koordinaatti
     * @return true, jos ruudukko sopii, muuten false
     */
    public boolean voikoSiirtya(boolean[][] palikanRuudukko, int x, int y){
        if(!onkoRuudukonSisalla(palikanRuudukko, x, y)){
            return false;
        }
        for (int i = 0; i < palikanRuudukko.length; i++) {
            for (int j = 0; j < palikanRuudukko.length; j++) {
                if(palikanRuudukko[i][j]&&ruudukko[y+i][x+j]){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Metodi tarkistaa, onko parametrina annettu ruudukko tämän ruudukon sisällä.
     * ulkopuolella olevat "false" alkiot eivät vaikuta tulokseen, kunhan kaikki
     * "true" alkiot ovat ruudukon sisällä.
     * 
     * @param palikanRuudukko palikan ruudukko
     * @param x tarkastettavan ruudukon x-sijainti
     * @param y tarkastettavan ruudukon y-sijainti
     * @return true, jos ruudukon sisällä, false, jos ulkona.
     */

    private boolean onkoRuudukonSisalla(boolean[][] palikanRuudukko, int x, int y) {
        

        for (int i = 0; i < palikanRuudukko.length; i++) {
            for (int j = 0; j < palikanRuudukko.length; j++) {
                if(palikanRuudukko[i][j]){
                    if((x+j <0)||(x+j>=leveys)){
                        return false;
                    }
                    if((y+i<0)||(y+i>=korkeus)){
                        return false;
                    }
                }
            }
        }
        return true;
        
    }
    /** 
     * Metodi palauttaa ruudukon totuusarvoja sisältävän taulukon
     * @return  ruudukko
     */
    public boolean[][] getRuudukko() {
        return ruudukko;
    }
    
    /**
     * Metodi päivittää parametrina annetut palikat tähän ruudukkoon kutsumalla 
     * paivitaPalikka() -metodia yksitellen jokaiselle palikalle.
     * 
     * @param palikat ArrayList palikoista, jotka päivitetään ruudukkoon. 
     */

    public void paivitaPalikat(ArrayList<Palikka> palikat) {
        for (Palikka palikka : palikat) {
            paivitaPalikka(palikka);
        }
    }
    
    
}
