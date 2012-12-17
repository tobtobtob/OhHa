
package tetris;

import tetris.domain.Palikka;

import tetris.domain.palikat.*;

public class Main {
    //testikoodia.
    
    public static void main(String[] args) {
        Palikka palikka = new Nelio(0, 0);
        tulostaRuudukko(palikka.getRuudukko());
        palikka.setRuudukko(palikka.luoKaannos());
        tulostaRuudukko(palikka.getRuudukko());
        palikka.setRuudukko(palikka.luoKaannos());
        tulostaRuudukko(palikka.getRuudukko());
        palikka.setRuudukko(palikka.luoKaannos());
        tulostaRuudukko(palikka.getRuudukko());
        palikka.setRuudukko(palikka.luoKaannos());
        tulostaRuudukko(palikka.getRuudukko());
        
    }

    private static void tulostaRuudukko(boolean[][] ruudukko) {
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko.length; j++) {
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
