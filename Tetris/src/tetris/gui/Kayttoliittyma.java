
package tetris.gui;

import tetris.gui.kuuntelijat.NappaimistonKuuntelija;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import tetris.Ohjain;
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
        
        
        ohjain.setPelialusta(pelialusta);
        ohjain.addActionListener(ohjain);
        ohjain.luoAktiivinenPalikka();
        container.add(pelialusta);
        frame.addKeyListener(new NappaimistonKuuntelija(ohjain));
        frame.setFocusable(true);
    }

    private JPanel luoValikko() {
        
        valikko =new JPanel();
        valikko.setLayout(new BoxLayout(valikko, BoxLayout.X_AXIS));
        uusiPeli = new JButton("uusi peli");
        uusiPeli.addActionListener(new UusiPeliKuuntelija(ohjain, frame));
        tauko = new JButton("tauko");
        pisteet = new Pistenaytto("0", ohjain);
        ohjain.setPistenaytto((Paivitettava) pisteet);
        valikko.add(uusiPeli);
        valikko.add(tauko);
        valikko.add(pisteet);
        valikko.setBorder(new EtchedBorder());
        return valikko;
    }
    
}
