package tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import tetris.domain.*;
import tetris.domain.palikat.*;
import tetris.gui.Paivitettava;


public class Ohjain {
    
    private Palikka aktiivinen;
    private Ruudukko ruudukko;
    private ArrayList<Palikka> palikat;
    private int leveys;
    private Paivitettava pelialusta;
    private Pistelaskuri pistelaskuri;
    private Paivitettava pistenaytto;
    
    private Kello kello;
    
    public Ohjain(int leveys, int korkeus){
       
        palikat = new ArrayList<Palikka>();
        ruudukko = new Ruudukko(leveys, korkeus);
        pistelaskuri = new Pistelaskuri();
        this.leveys = leveys;
        kello = new Kello(this);
        kello.addActionListener(kello);
        
    }
    public void luoUusiPeli(){
        pistelaskuri.nollaa();
        palikat.clear();
        ruudukko.tyhjennaRuudukko();
        pistenaytto.paivita();
        aktiivinen = luoSatunnainenPalikka();
        pelialusta.paivita();
        kello.kaynnista();
        
   
    }

    public void setPistenaytto(Paivitettava pistenaytto) {
        this.pistenaytto = pistenaytto;
    }
    
    

    public void setPelialusta(Paivitettava pelialusta) {
        this.pelialusta = pelialusta;
    }
    

    public ArrayList<Palikka> getPalikat() {
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

    
    public void kelloKay() {
        
        if(ruudukko.voikoSiirtya(aktiivinen, aktiivinen.getX(), aktiivinen.getY()+1)){
            siirraPalikkaa(Suunta.ALAS);
       
        }
        else{
            palikat.add(aktiivinen);
            
            ruudukko.paivitaPalikat(palikat);
            tarkastaTaydetRivit();
            aktiivinen = luoSatunnainenPalikka();
            if(!ruudukko.voikoSiirtya(aktiivinen, aktiivinen.getX(), aktiivinen.getY())){
                kello.pysayta();
            }
            pelialusta.paivita();
            kello.paivita();
            
            
        }
        
    }

    public Palikka getAktiivinen() {
        return aktiivinen;
    }
    
   
    public Palikka luoSatunnainenPalikka(){
        int uusi = new Random().nextInt(7);
        int x = leveys/2-2;
        int y = 0;
        
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
        int poistettujaRiveja = 0;
        while(poistettavaRivi != -1){
            for (Palikka palikka : palikat) {
                palikka.poistaRivi(poistettavaRivi);
            }            
            ruudukko.tyhjennaRuudukko();
            ruudukko.paivitaPalikat(palikat);
            poistettujaRiveja++;
            poistettavaRivi = ruudukko.palautaTaysiRivi();
        }
        poistaTyhjatPalikat();
        pistelaskuri.kasvataPisteita(poistettujaRiveja);
        pistenaytto.paivita();
    }

    public void luoAktiivinenPalikka() {
         aktiivinen = luoSatunnainenPalikka();
    }

    public int getPisteet() {
        return pistelaskuri.getPisteet();
    }


    public void poistaTyhjatPalikat() {
        for (int i = 0; i < palikat.size(); i++) {
            boolean[][] palikanRuudukko = palikat.get(i).getRuudukko();
            boolean tyhja = true; 
            for (int rivi = 0; rivi < palikanRuudukko.length; rivi++) {
                for (int sarake = 0; sarake < palikanRuudukko.length; sarake++) {
                    if(palikanRuudukko[rivi][sarake]){
                        tyhja = false;
                        break;
                    }
                }
             
            }
            if (tyhja){
                palikat.remove(i);
            }
        }
    }

    public int getTaso() {
        return pistelaskuri.getTaso();
    }
    
    
}
