package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import tetris.domain.*;
import tetris.domain.palikat.*;
import tetris.gui.Pelialusta;


public class Ohjain extends Timer implements ActionListener {
    
    private Palikka aktiivinen;
    private Ruudukko ruudukko;
    private ArrayList<Palikka> palikat;
    private int leveys;
    private Pelialusta pelialusta;
    
    public Ohjain(int leveys, int korkeus){
        super(1000, null);
        palikat = new ArrayList<Palikka>();
        ruudukko = new Ruudukko(leveys, korkeus);
        
        
        
        this.leveys = leveys;
        setInitialDelay(2000);

    }
    

    public void setPelialusta(Pelialusta pelialusta) {
        this.pelialusta = pelialusta;
    }
    

    public Iterable<Palikka> getPalikat() {
        return palikat;
    }
    
    
    

    void lisaaPalikka(Palikka palikka) {
        palikat.add(palikka);
    }
    public void siirraPalikkaa(Suunta suunta){
        
        int siirto;
        
        if((suunta == Suunta.OIKEA)||(suunta == Suunta.ALAS)){
            siirto = 1;
        }
        else{
            siirto = -1;
        }
        
        if(suunta == Suunta.ALAS){
            if(ruudukko.voikoSiirtya(aktiivinen, aktiivinen.getX(), aktiivinen.getY()+siirto)){
                aktiivinen.siirra(suunta);
                pelialusta.paivita();
            }
        }
        else{
            if(ruudukko.voikoSiirtya(aktiivinen, aktiivinen.getX()+siirto, aktiivinen.getY())){
                aktiivinen.siirra(suunta);
                pelialusta.paivita();
                
            }
        }
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(ruudukko.voikoSiirtya(aktiivinen, aktiivinen.getX(), aktiivinen.getY()+1)){
            aktiivinen.siirra(Suunta.ALAS);
            ruudukko.tyhjennaRuudukko();
            ruudukko.paivitaPalikat(palikat);
            pelialusta.paivita();
            
            
            
        }
        else{
            palikat.add(aktiivinen);
            
            ruudukko.paivitaPalikat(palikat);
            tarkastaTaydetRivit();
            aktiivinen = luoSatunnainenPalikka(leveys/2-2, 0);
            if(!ruudukko.voikoSiirtya(aktiivinen, aktiivinen.getX(), aktiivinen.getY())){
                this.stop();
            }
            pelialusta.paivita();
            
            
        }
        
    }

    public Palikka getAktiivinen() {
        return aktiivinen;
    }
    
   
    public Palikka luoSatunnainenPalikka(int x, int y){
        int uusi = new Random().nextInt(7);
        
       switch (uusi){
           case 0: return new Nelio(x, y);
           case 1: return new PalikkaJ(x, y);
           case 2: return new PalikkaL(x, y);
           case 3: return new PalikkaS(x, y);
           case 4: return new PalikkaT(x, y);
           case 5: return new PalikkaZ(x, y);
           case 6: return new Suora(x, y);    
       }
        return null;
           
    }

    public void kaannaPalikka() {
        if(ruudukko.voikoSiirtya(aktiivinen.luoKaannos(), aktiivinen.getX(), aktiivinen.getY())){
            aktiivinen.setRuudukko(aktiivinen.luoKaannos());
            pelialusta.paivita();
        }
    }

    private void tarkastaTaydetRivit() {
        int poistettavaRivi = ruudukko.palautaTaysiRivi();
        while(poistettavaRivi != -1){
            for (Palikka palikka : palikat) {
                palikka.poistaRivi(poistettavaRivi);
            }            
            ruudukko.tyhjennaRuudukko();
            ruudukko.paivitaPalikat(palikat);
            poistettavaRivi = ruudukko.palautaTaysiRivi();
        }
    }

    public void luoAktiivinenPalikka() {
         aktiivinen = luoSatunnainenPalikka(leveys/2-2, 0);
    }
    
    
}
