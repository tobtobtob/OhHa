
package tetris.domain;

public class Ruudukko {
    
    private boolean[][] ruudukko;
    private int leveys, korkeus;

    public Ruudukko(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        ruudukko = new boolean[leveys][korkeus];
    }
    public void tyhjennaRuudukko(){
        ruudukko = new boolean[leveys][korkeus];
    }
    public void paivitaPalikka(Palikka paivitettava){
        boolean[][] palikanRuudukko = paivitettava.getRuudukko();
        for (int i = 0; i < palikanRuudukko.length; i++) {
            for (int j = 0; j < palikanRuudukko.length; j++) {
                
            }
        }
    }
    public boolean voikoSiirtya(Palikka siirrettava, int x, int y){
        if(!onkoRuudukonSisalla(siirrettava, x, y)){
            return false;
        }
        boolean[][] palikanRuudukko = siirrettava.getRuudukko();
        
        for (int i = 0; i < palikanRuudukko.length; i++) {
            for (int j = 0; j < palikanRuudukko.length; j++) {
                if(palikanRuudukko[i][j]&&ruudukko[x+i][y+i]){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean onkoRuudukonSisalla(Palikka siirrettava, int x, int y) {
        
        if((x<0)||(x+siirrettava.getRuudukko().length>leveys)){
            return false;
        }
        if((y<0)||(y+siirrettava.getRuudukko().length>korkeus)){
            return false;
        }
        return true;
    }
    
    
}
