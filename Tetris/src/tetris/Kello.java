
package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Kello extends Timer implements ActionListener {
    
    private Ohjain ohjain;
    

    public Kello(Ohjain ohjain) {
        super(1000, null);
        this.ohjain = ohjain;
        this.setInitialDelay(2000);
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
        this.setDelay(2000-ohjain.getTaso()*100);
    }
    
}
