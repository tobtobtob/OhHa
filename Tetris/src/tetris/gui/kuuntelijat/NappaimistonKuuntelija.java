
package tetris.gui.kuuntelijat;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetris.Ohjain;
import tetris.logiikka.Suunta;

/**
 * NäppäimistönKuuntelija huolehti nuolinäppäimien kuuntelemisesta, ja tiedon
 * välittämisestä ohjaimelle kun nuolinäppäimiä painetaan. 
 * 
 */
public class NappaimistonKuuntelija implements KeyListener {
    /**
     * Pelilogiikan ohjain
     */
    private Ohjain ohjain;
    /**
     * Luo näppäimistönKuuntelijan jolla on viite parametrina annettuun ohjaimeen.
     * @param ohjain 
     */
    public NappaimistonKuuntelija(Ohjain ohjain) {
        this.ohjain = ohjain;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    /**
     * Kutsuu ohjainta, kun nuolinäppäimiä paintetaan.
     * @param KeyEvent e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            ohjain.siirraPalikkaa(Suunta.VASEN);
           
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            ohjain.siirraPalikkaa(Suunta.OIKEA);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            ohjain.siirraPalikkaa(Suunta.ALAS);
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            ohjain.kaannaPalikka();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
