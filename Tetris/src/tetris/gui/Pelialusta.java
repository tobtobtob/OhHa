
package tetris.gui;

import java.awt.Graphics;
import javax.swing.JPanel;
import tetris.Ohjain;
import tetris.domain.Palikka;

public class Pelialusta extends JPanel implements Paivitettava {
    private int ruudunKoko;
    private Ohjain ohjain;

    public Pelialusta(int ruudunKoko, Ohjain ohjain) {
        this.ruudunKoko = ruudunKoko;
        this.ohjain = ohjain;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Palikka piirrettava : ohjain.getPalikat()) {
            piirraPalikka(piirrettava, g);
        }
        piirraPalikka(ohjain.getAktiivinen(),g );
        
    }

    public void paivita() {
        super.repaint();
    }

    private void piirraPalikka(Palikka piirrettava, Graphics g) {
        boolean[][] ruudukko = piirrettava.getRuudukko();
        g.setColor(piirrettava.getVari());
        
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko.length; j++) {
                if(ruudukko[i][j]){
                    g.fill3DRect((piirrettava.getX()+j)*ruudunKoko, (piirrettava.getY()+i)*ruudunKoko, ruudunKoko, ruudunKoko, true);
                }
            }
        }
    }
    
    
}
