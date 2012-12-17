
package tetris.gui;

import java.awt.Graphics;
import javax.swing.JPanel;
import tetris.Ohjain;

public class Pelialusta extends JPanel {
    private int ruudunKoko;
    private Ohjain ohjain;

    public Pelialusta(int ruudunKoko, Ohjain ohjain) {
        this.ruudunKoko = ruudunKoko;
        this.ohjain = ohjain;
    }
    
    @Override
    public void paintComponent(Graphics g){
        
    }
}
