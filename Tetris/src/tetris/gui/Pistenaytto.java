
package tetris.gui;

import javax.swing.JLabel;
import tetris.Ohjain;


public class Pistenaytto extends JLabel implements Paivitettava {
    
    private final Ohjain ohjain;

    public Pistenaytto(String text, Ohjain ohjain) {
        super(text);
        this.ohjain = ohjain;
    }

    @Override
    public void paivita() {
        super.setText( String.format("%010d", ohjain.getPisteet()));
    }
    
}
