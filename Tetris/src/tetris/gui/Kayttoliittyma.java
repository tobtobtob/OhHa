/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import tetris.Ohjain;

/**
 *
 * @author topi
 */
public class Kayttoliittyma implements Runnable {
    
    private JFrame frame;
    private int leveys;
    private int korkeus;
    private int ruudunKoko;
    private Ohjain ohjain;
    private Pelialusta pelialusta;

    public Kayttoliittyma(int leveys, int korkeus, int ruudunKoko, Ohjain ohjain) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudunKoko = ruudunKoko;
        this.ohjain = ohjain;
    }
    
    
    
    @Override
    public void run() {
        frame = new JFrame("Tetris");
        
         
        frame.setPreferredSize(new Dimension(leveys*ruudunKoko, korkeus*ruudunKoko));
 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
        luoKomponentit(frame.getContentPane());
 
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container contentPane) {
        pelialusta = new Pelialusta(ruudunKoko, ohjain);
        contentPane.add(pelialusta);
        
    }
    
}
