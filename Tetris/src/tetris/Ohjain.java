package tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tetris.domain.*;
import tetris.domain.palikat.*;
import tetris.gui.Paivitettava;

public class Ohjain {
    
    private Palikka aktiivinen;
    private Ruudukko ruudukko;
    private ArrayList<Palikka> palikat;
    private int leveys;
    private Pistelaskuri pistelaskuri;    
    private Kello kello;
    private List<Paivitettava> paivitettavat;
    private boolean kaynnissa;
    
    public Ohjain(int leveys, int korkeus){
       
        palikat = new ArrayList<Palikka>();
        ruudukko = new Ruudukko(leveys, korkeus);
        pistelaskuri = new Pistelaskuri();
        this.leveys = leveys;
        kello = new Kello(this);
        kello.addActionListener(kello);
        paivitettavat = new ArrayList<Paivitettava>();
        
    }
    public void luoUusiPeli(){
        
        pistelaskuri.nollaa();
        palikat.clear();
        ruudukko.tyhjenna();        
        aktiivinen = luoSatunnainenPalikka();
        kaynnissa = true;
        paivitaKayttoliittyma();
        kello.kaynnista();
        
 
    }

    public ArrayList<Palikka> getPalikat() {
        return palikat;
    }

    public void vaihdaAktiivinenPalikka() {
        palikat.add(aktiivinen);
        
        ruudukko.paivitaPalikat(palikat);
        tarkastaTaydetRivit();
        aktiivinen = luoSatunnainenPalikka();
        if(!ruudukko.voikoSiirtya(aktiivinen, aktiivinen.getX(), aktiivinen.getY())){
            kello.pysayta();
            paivitaKayttoliittyma();
            return;
        }
        paivitaKayttoliittyma();
        kello.paivita();
    }

    void lisaaPalikka(Palikka palikka) {
        palikat.add(palikka);
    }
    
    public boolean siirraPalikkaa(Suunta suunta){
        
        if(suunta == Suunta.ALAS){
            if(ruudukko.voikoSiirtya(aktiivinen, aktiivinen.getX(), aktiivinen.getY()+suunta.getSiirto())){
                aktiivinen.siirra(suunta);
                paivitaKayttoliittyma();
                return true;
            }
        }
        else{
            if(ruudukko.voikoSiirtya(aktiivinen, aktiivinen.getX()+suunta.getSiirto(), aktiivinen.getY())){
                aktiivinen.siirra(suunta);
                paivitaKayttoliittyma();
                return true;
                
            }
        }
        return false;
    }
    
    
    public void kelloKay() {
        
        if(!siirraPalikkaa(Suunta.ALAS)){
            vaihdaAktiivinenPalikka();
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
            paivitaKayttoliittyma();
        }
    }
    
    private void tarkastaTaydetRivit() {
        
        int poistettavaRivi = ruudukko.palautaTaysiRivi();        
        if(poistettavaRivi == -1){
            return;
        }
        int poistettujaRiveja = 0;
        while(poistettavaRivi != -1){
            for (Palikka palikka : palikat) {
                palikka.poistaRivi(poistettavaRivi);
            }            
            ruudukko.tyhjenna();
            ruudukko.paivitaPalikat(palikat);
            poistettujaRiveja++;
            poistettavaRivi = ruudukko.palautaTaysiRivi();
        }
        poistaTyhjatPalikat();
        pistelaskuri.kasvataPisteita(poistettujaRiveja);
        paivitaKayttoliittyma();
    }
    
    public void paivitaKayttoliittyma(){
        for (Paivitettava paivitettava : paivitettavat) {
            paivitettava.paivita();
        }
    }
    public void lisaaPaivitettava(Paivitettava p){
        paivitettavat.add(p);
    }

    public void luoAktiivinenPalikka() {
         aktiivinen = luoSatunnainenPalikka();
    }

    public int getPisteet() {
        return pistelaskuri.getPisteet();
    }


    public void poistaTyhjatPalikat() {
        for (int i = 0; i < palikat.size(); i++) {
            
            if (palikat.get(i).onkoTyhja()){
                palikat.remove(i);
                
            }
        }
    }

    public int getTaso() {
        return pistelaskuri.getTaso();
    }
    
    public void setKaynnissa(){
        
        kaynnissa = !kaynnissa;
        
        if(!kaynnissa){
            kello.stop();            
        }
        else{
            kello.start();
        }
    }

    public boolean getKaynnissa() {
        return kaynnissa;
    }
    
        
}
