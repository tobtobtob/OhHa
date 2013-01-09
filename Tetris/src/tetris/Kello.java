
package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
/**
 * Kello vastaa ohjaimen kelloKay() -metodin kutsumisesta joka kellonlyömällä.
 * 
 */
public class Kello extends Timer implements ActionListener {
    
    private Ohjain ohjain;
    
    /**
     * Luo kellon jolla on viite parametrina annettuun ohjaimeen.
     * 
     * @param ohjain 
     */
    public Kello(Ohjain ohjain) {
        super(1000, null);
        this.ohjain = ohjain;
        this.start();
    }
    /**
     * Kutsuu ohjaimen metodia kelloKay aina viiveen määrään aikamäärän välein.
     * @param ActionEvent ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        ohjain.kelloKay();
    }
    /**
     * Päivittää kellon viiveen vastaamaan nykyistä pelitilannetta. Mitä
     * korkeammalla tasolla pelaaja on, sitä pienempi viive kelloon päivittyy. 
     */
    public void paivita(){
        int viive = 1000 -(ohjain.getTaso()*100)+100;
        if (viive<100){
            viive= 100;
        }
       super.setDelay(viive);
    }
    
}
