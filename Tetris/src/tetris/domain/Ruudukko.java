
package tetris.domain;

public class Ruudukko {
    
    private boolean[][] ruudukko;

    public Ruudukko(int leveys, int korkeus) {
        
        ruudukko = new boolean[leveys][korkeus];
    }
    
    public boolean voikoSiirtya(Palikka siirrettava){
        return false;
    }
    
    
}
