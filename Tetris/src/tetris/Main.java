
package tetris;

import javax.swing.SwingUtilities;
import tetris.domain.Palikka;
import tetris.domain.Ruudukko;

import tetris.domain.palikat.*;
import tetris.gui.Kayttoliittyma;

public class Main {
    //testikoodia.
    
    public static void main(String[] args) {
        Ohjain ohjain = new Ohjain(14, 20);
//        ohjain.lisaaPalikka(new Suora(4, 5));
//         ohjain.lisaaPalikka(new Nelio(0, 0));
        Kayttoliittyma k = new Kayttoliittyma(14, 20, 20, ohjain);
        SwingUtilities.invokeLater(k);
        
//        Ruudukko ruudukko = new Ruudukko(8, 10);
//        tulostaRuudukko(ruudukko.getRuudukko());
//        Palikka p = new PalikkaJ(3,3);
//        p.poistaRivi(4);
//        ruudukko.paivitaPalikka(p);
//        tulostaRuudukko(ruudukko.getRuudukko());
//        ruudukko.tyhjennaRuudukko();
//        p.setRuudukko(p.luoKaannos());
//        ruudukko.paivitaPalikka(p);
//        tulostaRuudukko(ruudukko.getRuudukko());


        
    }

    private static void tulostaRuudukko(boolean[][] ruudukko) {
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko.length-2; j++) {
                if (ruudukko[i][j]){
                    System.out.print("#");
                }
                else{
                    System.out.print(".");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
