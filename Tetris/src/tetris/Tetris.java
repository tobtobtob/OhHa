
package tetris;

import javax.swing.SwingUtilities;
import tetris.gui.Kayttoliittyma;
/**
 * Luokka luo käyttöliittymän ja ohjaimen ja käynnistää pelin.
 */
public class Tetris {
 
    /**
     * Ohjelman aloitusmetodi luo käyttöliittymän ja ohjaimen ja käynnistää pelin.
     * @param args 
     */
    public static void main(String[] args) {
        
        Ohjain ohjain = new Ohjain(14, 20);
        Kayttoliittyma k = new Kayttoliittyma(14, 20, 20, ohjain);
        ohjain.luoUusiPeli();
        SwingUtilities.invokeLater(k);

        
    }

   
}
