
package tetris.domain;

public class Ruudukko {
    
    private boolean[][] ruudukko;
    private int leveys, korkeus;

    public Ruudukko(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        ruudukko = new boolean[korkeus][leveys];
    }
    public void tyhjennaRuudukko(){
        ruudukko = new boolean[korkeus][leveys];
    }
    
    public void paivitaPalikka(Palikka paivitettava){
        boolean[][] palikanRuudukko = paivitettava.getRuudukko();
        
        for (int i = 0; i < palikanRuudukko.length; i++) {
            for (int j = 0; j < palikanRuudukko.length; j++) {
                if(palikanRuudukko[i][j] == true){
                    ruudukko[paivitettava.getY()+i][paivitettava.getX()+j] = true;
                }
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
                if(palikanRuudukko[i][j]&&ruudukko[y+i][x+j]){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean onkoRuudukonSisalla(Palikka siirrettava, int x, int y) {
        
        boolean[][] palikanRuudukko = siirrettava.getRuudukko();
        
        for (int i = 0; i < palikanRuudukko.length; i++) {
            for (int j = 0; j < palikanRuudukko.length; j++) {
                if(palikanRuudukko[i][j]){
                    if((x+j <0)||(x+j>=leveys)){
                        return false;
                    }
                    if((y+i<0)||(y+i>=korkeus)){
                        return false;
                    }
                }
            }
        }
        return true;
        
    }

    public boolean[][] getRuudukko() {
        return ruudukko;
    }
    
    
}
