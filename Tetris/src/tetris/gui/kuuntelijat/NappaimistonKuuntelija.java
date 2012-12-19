
package tetris.gui.kuuntelijat;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetris.Ohjain;
import tetris.domain.Suunta;


public class NappaimistonKuuntelija implements KeyListener {
    private Ohjain ohjain;

    public NappaimistonKuuntelija(Ohjain ohjain) {
        this.ohjain = ohjain;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

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
