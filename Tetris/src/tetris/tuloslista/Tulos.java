
package tetris.tuloslista;

/**
 * Tulos kuvaa yhtä tuloslistan oliota, jossa on nimimerkki ja nimimerkin 
 * saamat pisteet.
 * 
 * @author topi
 */
public class Tulos implements Comparable<Tulos> {
    private int pisteet;
    private String nimi;

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
    @Override
    public String toString(){
        return nimi +", "+pisteet+" pistettä";
    }
}
