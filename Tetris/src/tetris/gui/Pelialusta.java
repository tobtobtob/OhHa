
package tetris.gui;

import java.awt.Graphics;
import javax.swing.JPanel;
import tetris.Ohjain;
import tetris.domain.Palikka;

/**
 * Grafiikkakomponentti, joka piirtää pelissä olevat palikat päivitettäessä.
 * 
 */
public class Pelialusta extends JPanel implements Paivitettava {
    private int ruudunKoko;
    private Ohjain ohjain;
    /**
     * Määrittää yhden palan koon pelialustalla parametriksi annetun arvon 
     * mukaiseksi.
     * 
     * @param yhden ruudun koko
     * @param ohjain 
     */
    public Pelialusta(int ruudunKoko, Ohjain ohjain) {
        this.ruudunKoko = ruudunKoko;
        this.ohjain = ohjain;
    }
    /**
     * Piirtää yksitellen jokaisen palikan kutsumalla "piirräPalikka" -metodia.
     * 
     * @param Graphics g
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Palikka piirrettava : ohjain.getPalikat()) {
            piirraPalikka(piirrettava, g);
        }
        if(ohjain.getAktiivinen() != null){
            piirraPalikka(ohjain.getAktiivinen(),g );
        }
        
    }
    /**
     * Päivitettäessä piirtää kaikki pelissä olevat palikat.
     */
    @Override
    public void paivita() {
        super.repaint();
    }
    /**
     * Piirtää parametrina annetun palikan palikan värillä.
     * 
     * @param piirrettava palikka 
     * @param Graphics g
     */
    private void piirraPalikka(Palikka piirrettava, Graphics g) {
        boolean[][] ruudukko = piirrettava.getRuudukko();
        g.setColor(piirrettava.getVari());
        
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko.length; j++) {
                if(ruudukko[i][j]){
                    g.fill3DRect((piirrettava.getX()+j)*ruudunKoko, (piirrettava.getY()+i)*ruudunKoko, ruudunKoko, ruudunKoko,true);
                }
            }
        }
    }
    
    
}
