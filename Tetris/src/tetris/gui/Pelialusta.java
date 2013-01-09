
package tetris.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.io.PrintStream;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import tetris.Ohjain;
import tetris.logiikka.Palikka;

/**
 * Grafiikkakomponentti, joka piirtää pelissä olevat palikat sekä pistetilanteen.
 */
public class Pelialusta extends JPanel implements Paivitettava {
    private int ruudunKoko;
    private Ohjain ohjain;
    private JLabel pisteet;
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
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        luoPisteet();
        
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
        pisteet.setText(ohjain.getPisteet()+"");
        
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
    /**
     * Luo JLabelin pisteet, johon päivitetään pelin pistetilanne.
     */
    private void luoPisteet() {
        pisteet = new JLabel(ohjain.getPisteet()+"");
        this.add(pisteet);
    }
    
    
}
