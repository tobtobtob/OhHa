package tetris;

import tetris.logiikka.palikat.PalikkaT;
import tetris.logiikka.palikat.Suora;
import tetris.logiikka.palikat.PalikkaS;
import tetris.logiikka.palikat.PalikkaJ;
import tetris.logiikka.palikat.PalikkaZ;
import tetris.logiikka.palikat.Nelio;
import tetris.logiikka.palikat.PalikkaL;
import tetris.logiikka.Suunta;
import tetris.logiikka.Palikka;
import tetris.logiikka.Ruudukko;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tetris.gui.Paivitettava;
import tetris.tuloslista.Tuloslista;
/**
 * Ohjain hallitsee pelilogiikkaa ohjaamalla putoavaa palikkaa ja poistamalla
 * täydet rivit. Pelitilanteen muuttuessa ohjain päivittää käyttöliittymän.
 */
public class Ohjain {
    
    private Palikka aktiivinen;
    private Ruudukko ruudukko;
    private ArrayList<Palikka> palikat;
    private int leveys;
    private Pistelaskuri pistelaskuri;    
    private Kello kello;
    private List<Paivitettava> paivitettavat;
    private boolean kaynnissa;
    private Tuloslista tuloslista;
    private boolean pelinLoppu;
    private boolean peliOhi;

    public Ohjain(int leveys, int korkeus){
       
        palikat = new ArrayList<Palikka>();
        ruudukko = new Ruudukko(leveys, korkeus);
        pistelaskuri = new Pistelaskuri();
        this.leveys = leveys;
        kello = new Kello(this);
        kello.addActionListener(kello);
        paivitettavat = new ArrayList<Paivitettava>();
        tuloslista = new Tuloslista();
    }
    public void luoUusiPeli(){
        
        pistelaskuri.nollaa();
        palikat.clear();
        ruudukko.tyhjenna();        
        aktiivinen = luoSatunnainenPalikka();
        kaynnissa = true;
        peliOhi = false;
        paivitaKayttoliittyma();
        kello.start();
        pelinLoppu = false;

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
            kello.stop();
            aktiivinen = null;
            pelinLoppu = true;
            peliOhi = true;
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
        
        boolean[][] kaannos = aktiivinen.luoKaannos();
        if(ruudukko.voikoSiirtya(kaannos, aktiivinen.getX(), aktiivinen.getY())){
            aktiivinen.setRuudukko(kaannos);
            paivitaKayttoliittyma();
        }
    }
    
    private void tarkastaTaydetRivit() {
        
        int poistettavaRivi = ruudukko.palautaTaysiRivi();        
        
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
    
    public void setKaynnissa(boolean kaynnissa){
        
        this.kaynnissa = kaynnissa;
        
        if(!kaynnissa){
            kello.stop();            
        }
        else{
            kello.start();
        }
        paivitaKayttoliittyma();
    }

    public boolean getKaynnissa() {
        return kaynnissa;
    }

    public void tallennaPisteet(String nimimerkki) {
        if(nimimerkki.equals("")){
            nimimerkki = "anonymous";
        }
        tuloslista.kirjoitaTulos(nimimerkki, getPisteet());
    }

    public boolean getPelinLoppu() {
        return pelinLoppu;
    }
    public String getTulokset(){
        return tuloslista.getTulokset(10);
    }

    public void setPelinLoppu(boolean b) {
        pelinLoppu = false;
    }
    
    public boolean onkoPeliOhi() {
        return peliOhi;
    }

    
        
}
