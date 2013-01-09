
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

/**
 * Käyttöliittymä luo kaikki pelin käyttöliittymäkomponentit.
 * 
 * 
 */
public class Kayttoliittyma implements Runnable, Paivitettava {
    /**
     * Pelin pääikkuna
     */
    private JFrame frame;
    /**
     * Pelialueen leveys ruuduissa
     */
    private int leveys;
    /**
     * Pelialueen korkeus ruuduissa
     */
    private int korkeus;
    /**
     * yhden pelialueen ruudun koko
     */
    private int ruudunKoko;
    /**
     * pelin ohjain
     */
    private Ohjain ohjain;
    /**
     * Pelialusta, johon palikat piirretään
     */
    private Pelialusta pelialusta;

    /**
     * Luo käyttöliittymän antaen parametrina koot, jotka käyttöliittymä  
     * välittää grafiikka- ja logiikkakomponenteille
     * 
     * @param leveys
     * @param korkeus
     * @param yhden tetris-palan koko
     * @param ohjain 
     */
    public Kayttoliittyma(int leveys, int korkeus, int ruudunKoko, Ohjain ohjain) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.ruudunKoko = ruudunKoko;
        this.ohjain = ohjain;
    }
    
    
    /**
     * Luo pelin pääikkunan, ja sen sisälle komponentit kutsumalla luoKomponentit() -metodia.
     */
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
    /**
     * Metodi luo pelialusta, sekä valikon kutsumalla luoValikko() -metodia.
     * @param container 
     */
    private void luoKomponentit(Container container) {
        
        pelialusta = new Pelialusta(ruudunKoko, ohjain);
        pelialusta.setBorder(BorderFactory.createEtchedBorder());
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
//        valikko = luoValikko();
        
        container.add(luoValikko());
        container.add(pelialusta);
        
        
        ohjain.lisaaPaivitettava(pelialusta);
        
        container.add(pelialusta);
        frame.addKeyListener(new NappaimistonKuuntelija(ohjain));
        frame.setFocusable(true);
        
    }
    /**
     * metodi luo valikon napit, ja asettaa niille kuuntelijan.
     * 
     * @return 
     */
    private JPanel luoValikko() {
        
        JPanel valikko =new JPanel();
        valikko.setLayout(new BoxLayout(valikko, BoxLayout.X_AXIS));
        JButton tulokset = new JButton("Tulokset");
        JButton uusiPeli = new JButton("Uusi peli");
        JButton tauko = new JButton("Tauko");       
        NappienKuuntelija kuuntelija = new NappienKuuntelija(tauko, uusiPeli, tulokset, ohjain, frame);
        uusiPeli.addActionListener(kuuntelija);
        tauko.addActionListener(kuuntelija);
        tulokset.addActionListener(kuuntelija);
        valikko.add(tulokset);
        valikko.add(uusiPeli);
        valikko.add(tauko);
        
        return valikko;
    }
    /**
     * päivitettäessä käyttöliittymä asettaa näppäinten kuuntelun päälle/pois päältä
     * jos peli on käynnissä/ ei käynnissä.
     * Kun peli on ohi, metodi luo JDialog -ruudun pisteiden kirjaamista varten.
     */
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
    /**
     * Metodi luo JDialog -ikkunan pisteiden kirjaamista varten, ja näyttää sen jälkeen
     * tuloslistan kokonaisuudessaan.
     */
    public void tulosIkkuna(){
        String nimimerkki = JOptionPane.showInputDialog("Sait "+ohjain.getPisteet()+" pistettä, "
                + "anna nimesi:");
        if (nimimerkki == null){
            nimimerkki = "";
        }
        ohjain.tallennaPisteet(nimimerkki);
        JOptionPane.showMessageDialog(frame, ohjain.getTulokset(), "Ennätykset", JOptionPane.PLAIN_MESSAGE);
        ohjain.setPelinLoppu(false);
    }
    
}
