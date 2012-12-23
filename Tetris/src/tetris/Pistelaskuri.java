
package tetris;


public class Pistelaskuri {
    
    private int pisteet;
    private int taso;

    public Pistelaskuri() {
        pisteet = 0;
        taso = 1;
    }
    /**
     * Metodi kasvattaa pisteitä riippuen poistettujen rivien määrästä ja tasosta.
     * Pistelisäys kasvaa eksponentaalisesti poistettujen rivien määrän
     * kasvaessa
     * 
     * @param samalla kerralla tuhottujen rivien määrä 
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

    public int getPisteet() {
        return pisteet;
    }

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
