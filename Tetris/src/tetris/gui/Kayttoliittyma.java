
package tetris.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import tetris.Ohjain;
import tetris.gui.kuuntelijat.NappaimistonKuuntelija;
import tetris.gui.kuuntelijat.NappienKuuntelija;


public class Kayttoliittyma implements Runnable, Paivitettava {
    
    private JFrame frame;
    private int leveys;
    private int korkeus;
    private int ruudunKoko;
    private Ohjain ohjain;
    private Pelialusta pelialusta;
    private JButton uusiPeli, tauko;
    private JPanel valikko;
    private JButton tulokset;

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
        ohjain.lisaaPaivitettava(this);
        frame.pack();
        frame.setResizable(false);
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
        tulokset = new JButton("Tulokset");
        uusiPeli = new JButton("Uusi peli");
        tauko = new JButton("Tauko");       
        NappienKuuntelija kuuntelija = new NappienKuuntelija(tauko, uusiPeli, tulokset, ohjain, frame);
        uusiPeli.addActionListener(kuuntelija);
        tauko.addActionListener(kuuntelija);
        tulokset.addActionListener(kuuntelija);
        valikko.add(tulokset);
        valikko.add(uusiPeli);
        valikko.add(tauko);
        
        return valikko;
    }

    @Override
    public void paivita() {
        
        if(!ohjain.getKaynnissa()){
            frame.setFocusable(false);
            
        }
        else{
            frame.setFocusable(true);
            frame.requestFocusInWindow();
        }
        if(ohjain.getPelinLoppu()){
            tulosIkkuna();
        }
    }
    public void tulosIkkuna(){
        String nimimerkki = JOptionPane.showInputDialog("Sait "+ohjain.getPisteet()+" pistettä, "
                + "anna nimesi:");
        ohjain.tallennaPisteet(nimimerkki);
        JOptionPane.showMessageDialog(frame, ohjain.getTulokset(), "Ennätykset", JOptionPane.PLAIN_MESSAGE);
        ohjain.setPelinLoppu(false);
    }
    
}
