
package tetris.gui;

/**
 * Päivitettävä -rajapinnan toteuttavat käyttöliittymän komponentit, joita
 * pelilogiikan ohjaimen tulee kutsua pelitilanteen muuttuessa.
 * 
 */
public interface Paivitettava {
    /**
     * paivittaa käyttöliittymän komponentin vastaamaan nykyistä pelitilannetta
     */
    public void paivita();
}
