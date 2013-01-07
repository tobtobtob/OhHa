
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
    

    public Kello(Ohjain ohjain) {
        super(1000, null);
        this.ohjain = ohjain;
        this.start();
    }

    public void pysayta(){
        this.stop();
    }
    public void kaynnista(){
        this.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        ohjain.kelloKay();
    }
    public void paivita(){
        int viive = 1000 -(ohjain.getTaso()*100)+100;
        if (viive<100){
            viive= 100;
        }
       super.setDelay(viive);
    }
    
}
