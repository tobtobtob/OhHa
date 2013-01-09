
package tetris.tuloslista;

/**
 * Tulos kuvaa yhtä tuloslistan oliota, jossa on nimimerkki ja nimimerkin 
 * saamat pisteet.
 * 
 * @author topi
 */
public class Tulos implements Comparable<Tulos> {
    /**
     * tuloksen pisteet
     */
    private int pisteet;
    /**
     * tuloksen tekijän nimimerkki
     */
    private String nimi;
    /**
     * Konstruktori luo tuloksen annetuilla pisteillä annetulle nimimerkille.
     * 
     * @param pisteet
     * @param pelaajan nimimerkki tuloslistalla.  
     */
    public Tulos(int pisteet, String nimi) {
        this.pisteet = pisteet;
        this.nimi = nimi;
    }

    public int getPisteet() {
        return pisteet;
    }

    public String getNimi() {
        return nimi;
    }
    
    @Override
    public int compareTo(Tulos verrattava) {
        return verrattava.pisteet- this.pisteet;
    }
    /**
     * Palauttaa tekstimuotoisen esityksen tuloksesta-
     * 
     * @return tulos merkkijonona 
     */
    @Override
    public String toString(){
        return nimi +", "+pisteet+" pistettä";
    }
}
