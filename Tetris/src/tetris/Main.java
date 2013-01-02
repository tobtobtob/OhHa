
package tetris;

import javax.swing.SwingUtilities;

import tetris.gui.Kayttoliittyma;

public class Main {
 
    
    public static void main(String[] args) {
        Ohjain ohjain = new Ohjain(14, 20);

        Kayttoliittyma k = new Kayttoliittyma(14, 20, 20, ohjain);
        SwingUtilities.invokeLater(k);

        
    }

   
}
