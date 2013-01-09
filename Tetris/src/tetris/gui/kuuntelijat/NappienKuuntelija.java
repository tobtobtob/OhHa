
package tetris.gui.kuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tetris.Ohjain;

public class NappienKuuntelija implements ActionListener {
    
    private Ohjain ohjain;
    private JFrame frame;
    private JButton tauko, uusiPeli, tulokset;

    public NappienKuuntelija(JButton tauko,JButton uusiPeli, JButton tulokset, Ohjain ohjain, JFrame frame) {
        this.tauko = tauko;
        this.uusiPeli = uusiPeli;
        this.tulokset = tulokset;
        this.ohjain = ohjain;
        this.frame = frame;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton kutsuja = (JButton) e.getSource();
        boolean kaynnissa = ohjain.getKaynnissa();
        
        if (kutsuja == tauko){
            if(ohjain.onkoPeliOhi()){
                return;
            }
            ohjain.setKaynnissa(!ohjain.getKaynnissa());
        }
        else if(kutsuja == uusiPeli){
            ohjain.luoUusiPeli();
        }
        else if(kutsuja == tulokset){
            
            ohjain.setKaynnissa(false);
            
            JOptionPane.showMessageDialog(frame, ohjain.getTulokset(), "Ennätykset", JOptionPane.PLAIN_MESSAGE);
            
            if(!ohjain.onkoPeliOhi()){
                ohjain.setKaynnissa(true);
            }
        }
        
     
    }
    
    
}
