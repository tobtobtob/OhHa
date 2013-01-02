
package tetris.domain;


public enum Suunta {
    OIKEA(1), VASEN(-1), ALAS(1);
    
    private int siirto;
    
    private Suunta(int siirto){
        this.siirto = siirto;
    }
    public int getSiirto(){
        return siirto;
    }
    
}
