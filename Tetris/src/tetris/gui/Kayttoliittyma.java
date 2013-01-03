
package tetris.gui;

import tetris.gui.kuuntelijat.NappaimistonKuuntelija;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import tetris.Ohjain;
import tetris.gui.kuuntelijat.TaukoKuuntelija;
import tetris.gui.kuuntelijat.UusiPeliKuuntelija;


public class Kayttoliittyma implements Runnable {
    
    private JFrame frame;
    private int leveys;
    private int korkeus;
    private int ruudunKoko;
    private Ohjain ohjain;
    private Pelialusta pelialusta;
    private JButton uusiPeli, tauko;
    private JLabel pisteet;
    private JPanel valikko;
    private JLabel taso;
    private JPanel paneeli;

    public Kayttoliittyma(int leveys, int korkeus, int ruudunKoko, Ohjain ohjain) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudunKoko = ruudunKoko;
        this.ohjain = ohjain;
    }
    
    
    
    @Override
    public void run() {
        frame = new JFrame("Tetris");
        
        int todellinenLeveys = leveys*ruudunKoko+ (int) (ruudunKoko*0.5);
        int todellinenKorkeus = korkeus*ruudunKoko+ (int) (ruudunKoko*1.5)+29;
        frame.setPreferredSize(new Dimension(todellinenLeveys, todellinenKorkeus));
 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
        luoKomponentit(frame.getContentPane());
 
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
        pelialusta = new Pelialusta(ruudunKoko, ohjain);
        pelialusta.setBorder(BorderFactory.createEtchedBorder());
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        valikko = luoValikko();
        
        container.add(valikko);
        container.add(pelialusta);
        
        
        ohjain.lisaaPaivitettava(pelialusta);
        
        container.add(pelialusta);
        frame.addKeyListener(new NappaimistonKuuntelija(ohjain));
        frame.setFocusable(true);
    }

    private JPanel luoValikko() {
        
        valikko =new JPanel();
        valikko.setLayout(new BoxLayout(valikko, BoxLayout.X_AXIS));
        uusiPeli = new JButton("Uusi peli");
        uusiPeli.addActionListener(new UusiPeliKuuntelija(ohjain, frame));
        tauko = new JButton("Tauko");
        tauko.addActionListener(new TaukoKuuntelija(tauko, ohjain, frame));
        pisteet = new Pistenaytto(String.format("%010d", 0), ohjain);
        ohjain.lisaaPaivitettava((Paivitettava) pisteet);
        valikko.add(uusiPeli);
        valikko.add(tauko);
        valikko.add(pisteet);
        
        return valikko;
    }
    
}
