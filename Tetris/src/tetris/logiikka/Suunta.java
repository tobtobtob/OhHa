
package tetris.logiikka;

/**
 * Suunta määrittää palikoiden siirtämiseen käytettävät suunnat oikea, vasen 
 * ja alas. Ylös -suuntaa ei ole, sillä pelissä palikat eivät liiku ylöspäin.
 * 
 */
public enum Suunta {
    
    OIKEA(1), VASEN(-1), ALAS(1);
    /**
     * siirto on suunnalla joko -1 tai 1, riippuen onko suunta koordinaatistossa
     * oikealle vai vasemmalle.
     */
    private int siirto;
    /**
     * Metodi luo suunnan parametrina annetulla siirrolla (1 tai -1)
     * @param siirto 
     */
    private Suunta(int siirto){
        this.siirto = siirto;
    }
    /**
     * @return siirto 
     */
    public int getSiirto(){
        return siirto;
    }
    
}
