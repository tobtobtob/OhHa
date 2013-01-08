
package tetris.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import tetris.Ohjain;

public class TaukoKuuntelija implements ActionListener {
    
    private Ohjain ohjain;
    private JFrame frame;

    public TaukoKuuntelija(JButton taukoNappi, Ohjain ohjain, JFrame frame) {
        
        this.ohjain = ohjain;
        this.frame = frame;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        ohjain.setKaynnissa();
        
     
    }
    
    
}
