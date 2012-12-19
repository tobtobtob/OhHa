
package tetris;


public class Pistelaskuri {
    
    private int pisteet;
    private int taso;

    public Pistelaskuri() {
        pisteet = 0;
        taso = 1;
    }
    public void kasvataPisteita(int rivejaTuhottu){
        if(rivejaTuhottu == 0){
            return;
        }
        pisteet += 50*taso*Math.pow(rivejaTuhottu, 2);
        tarkistaTaso();
    }

    private void tarkistaTaso() {
        if(pisteet-taso*(taso+1)*1000>=0){
            taso++;
        }
    }

    public int getPisteet() {
        return pisteet;
    }

    public int getTaso() {
        return taso;
    }

    void nollaa() {
        pisteet = 0;
        taso = 0;
    }
    
    
}
