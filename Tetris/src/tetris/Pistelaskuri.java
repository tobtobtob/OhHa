
package tetris;

/**
 * Pistelaskuri pitää kirjaa pisteistä ja pelin sen hetkisestä tasosta.
 */
public class Pistelaskuri {
    
    private int pisteet;
    private int taso;
    
    /**
     * Konstruktori luo pistelaskurin jonka pisteet ovat 0 ja taso 1.
     */
    public Pistelaskuri() {
        pisteet = 0;
        taso = 1;
    }
    /**
     * Metodi kasvattaa pisteitä riippuen poistettujen rivien määrästä ja tasosta.
     * Pistelisäys kasvaa eksponentaalisesti poistettujen rivien määrän
     * kasvaessa
     * 
     * @param samalla kerralla poistettujen rivien määrä 
     */
    public void kasvataPisteita(int rivejaPoistettu){
        if(rivejaPoistettu <= 0){
            return;
        }
        pisteet += 50*taso*Math.pow(rivejaPoistettu, 2);
        tarkistaTaso();
    }
    /**
     * Metodi kasvattaa tasoa, jos pistemäärä kasvaa riittävän suureksi.
     */

    private void tarkistaTaso() {
        if(pisteet-taso*(taso+1)*1000>=0){
            taso++;
        }
    }
    /**
     * Palauttaa kerätyt pisteen
     * @return pisteet
     */
    public int getPisteet() {
        return pisteet;
    }
    /**
     * Palauttaa tason  
     * @return taso
     */
    public int getTaso() {
        return taso;
    }
    /**
     * Metodi nollaa pistetilanteen.
     */
    public void nollaa() {
        pisteet = 0;
        taso = 0;
    }
    
    
}
