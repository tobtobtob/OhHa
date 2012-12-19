
package tetris.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import tetris.Ohjain;


public class Kayttoliittyma implements Runnable {
    
    private JFrame frame;
    private int leveys;
    private int korkeus;
    private int ruudunKoko;
    private Ohjain ohjain;
    private Pelialusta pelialusta;
    private JButton uusiPeli, tauko;
    private JLabel pisteet;
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
        int todellinenKorkeus = korkeus*ruudunKoko+ (int) (ruudunKoko*1.5)+30;
        frame.setPreferredSize(new Dimension(todellinenLeveys, todellinenKorkeus));
 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
        luoKomponentit(frame.getContentPane());
 
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
        pelialusta = new Pelialusta(ruudunKoko, ohjain);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        paneeli = luoPaneeli();
        container.add(paneeli);
        container.add(pelialusta);
        
        
        ohjain.setPelialusta(pelialusta);
        ohjain.addActionListener(ohjain);
        ohjain.luoAktiivinenPalikka();
        container.add(pelialusta);
        frame.addKeyListener(new NappaimistonKuuntelija(ohjain));
        frame.setFocusable(true);
    }

    private JPanel luoPaneeli() {
        
        paneeli =new JPanel();
        paneeli.setLayout(new BoxLayout(paneeli, BoxLayout.X_AXIS));
        uusiPeli = new JButton("uusi peli");
        tauko = new JButton("tauko");
        pisteet = new JLabel("0");
        paneeli.add(uusiPeli);
        paneeli.add(tauko);
        paneeli.add(pisteet);
        paneeli.setBorder(new EtchedBorder());
        return paneeli;
    }
    
}
