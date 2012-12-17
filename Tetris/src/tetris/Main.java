
package tetris;

import tetris.domain.Palikka;
import tetris.domain.Ruudukko;

import tetris.domain.palikat.*;

public class Main {
    //testikoodia.
    
    public static void main(String[] args) {
        Ruudukko ruudukko = new Ruudukko(8, 10);
        tulostaRuudukko(ruudukko.getRuudukko());
        Palikka p = new Suora(3,3);
        ruudukko.paivitaPalikka(p);
        tulostaRuudukko(ruudukko.getRuudukko());
        ruudukko.tyhjennaRuudukko();
        p.setRuudukko(p.luoKaannos());
        ruudukko.paivitaPalikka(p);
        tulostaRuudukko(ruudukko.getRuudukko());


        
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
