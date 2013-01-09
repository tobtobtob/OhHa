package tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tetris.gui.Paivitettava;
import tetris.logiikka.*;
import tetris.logiikka.palikat.*;
import tetris.tuloslista.Tuloslista;
/**
 * Ohjain hallitsee pelilogiikkaa ohjaamalla putoavaa palikkaa ja poistamalla
 * täydet rivit. Pelitilanteen muuttuessa ohjain päivittää käyttöliittymän.
 */
public class Ohjain {
    /**
     * tippuva palikka, jota pelaaja ohjaa nuolinäppäimillä
     */
    private Palikka aktiivinen;
    /**
     * Siirtojen mahdollisuudet tarkastava ruudukko
     */
    private Ruudukko ruudukko;
    /**
     * Lista jo tippuneista palikoista
     */
    private ArrayList<Palikka> palikat;
    /**
     * pelialueen leveys ruuduissa
     */
    private int leveys;
    /**
     * pelin pistelaskuri
     */
    private Pistelaskuri pistelaskuri;    
    /**
     * Kello, joka kutsuu ohjainta tiputtamaan aktiivista palikkaa
     */
    private Kello kello;
    /**
     * Lista päivitettävistä käyttöliittymäkomponenteista
     */
    private List<Paivitettava> paivitettavat;
    /**
     * jos true, peli on käynnissä, jos false, peli on loppunut tai tauolla
     */
    private boolean kaynnissa;
    /**
     * tuloslistaan tallennetaan ja sieltä luetaan ennätykset
     */
    private Tuloslista tuloslista;
    /**
     * pelinLoppu on hetkellinen tila, joka on käyttöliittymälle merkki tulosten
     * kirjaamis -ikkunan avaamisesta.
     */
    private boolean pelinLoppu;
    /**
     * peliOhi on tila, josta peli voi mennä takaisin käyntiin vain uuden pelin alkaessa.
     */
    private boolean peliOhi;
    /**
     * Luo ohjaimen, joka luo pelilogiikan annteun kokoiselle pelialueelle.
     * 
     * @param ruudukon leveys
     * @param ruudukon korkeus 
     */
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
    /**
     * luo uuden pelin alustaen uuden tippuvan palikan, nollaten pistelaskurin ja
     * tallessa olevat palikat, sekä asettaen pelin tilasta kirjaa pitävät boolean 
     * -muuttujat oikein.
     */
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
    /**
     * Palauttaa listan pelissä olevista, eli jo tippuneista palikoista.
     * @return 
     */
    public ArrayList<Palikka> getPalikat() {
        return palikat;
    }
    /**
     * Metodi vaihtaa aktiivisen palikan uuteen, lisäten vanhan aktiivisen palikan
     * palikat sisältävään listaan. Metodi myös lopettaa pelin, jos uusi aktiivinen 
     * palikka ei mahdu pelialueelle.
     */
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
            kaynnissa = false;
            paivitaKayttoliittyma();
            return;
        }
        paivitaKayttoliittyma();
        kello.paivita();
    }
    /**
     * Lisää parametrina annetun palikan listaan palikoista. 
     * @param palikka 
     */
    void lisaaPalikka(Palikka palikka) {
        palikat.add(palikka);
    }
    /**
     *Tarkistaa, voiko aktiivinen palikka siirtyä parametrina annettuun 
     * suuntaan. Jos voi, metodi siirtää palikkaa annettuun suuntaan.
     * 
     * @param suunta
     * @return true, jos siirto toteutettiin, false jos siirtoa ei toteutettu
     */
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
    
    /**
     * Siirtää palikkaa jokaisella kellonlyömällä yhden pykälän alaspäin.
     * Jos siirto ei toteudu, metodi kutsuu uuden aktiivisen palikan luovaa metodia.
     */
    public void kelloKay() {
        
        if(!siirraPalikkaa(Suunta.ALAS)){
            vaihdaAktiivinenPalikka();
        }  
    }
    /**
     * palauttaa aktiivisen palikan
     * @return aktiivinen palikka
     */
    public Palikka getAktiivinen() {
        return aktiivinen;
    }
    
    /**
     * Palauttaa uuden palikan, joka on yksi seitsemästä mahdollisesta eri 
     * palikkatyypistä.
     * 
     * @return satunnainen palikka
     */
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
    /**
     * Metodi tarkastaa voiko aktiivinen palikka kääntyä myötäpäivään. Jos 
     * mahdollista, palikka käännetään yhden käännöksen verran.
     */
    public void kaannaPalikka() {
        
        boolean[][] kaannos = aktiivinen.luoKaannos();
        if(ruudukko.voikoSiirtya(kaannos, aktiivinen.getX(), aktiivinen.getY())){
            aktiivinen.setRuudukko(kaannos);
            paivitaKayttoliittyma();
        }
    }
    /**
     * Metodi tarkastaa ruudukkoa apuna käyttäen täydet rivit poistaen ne. 
     * Tämän jälkeen poistetaan tyhjät palikat listasta ja päivitetään pistetilanne.
     */
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
    /**
     * Päivittää päivitettävä -rajapinnan toteuttavat käyttöliittymäkomponentit
     */
    public void paivitaKayttoliittyma(){
        for (Paivitettava paivitettava : paivitettavat) {
            paivitettava.paivita();
        }
    }
    /**
     * lisää päivitettävä -rajapinnan toteuttavan olion päivitettäviin
     * @param p 
     */
    public void lisaaPaivitettava(Paivitettava p){
        paivitettavat.add(p);
    }
    /**
     * Asettaa aktiiviseksi palikaksi uduen satunnaisen palikan
     */
    public void luoAktiivinenPalikka() {
         aktiivinen = luoSatunnainenPalikka();
    }
    /**
     * Palauttaa pistelaskurilta saatavan pistetilanteen
     * @return pisteet
     */
    public int getPisteet() {
        return pistelaskuri.getPisteet();
    }

    /**
     * Poistaa palikat -listasta tyhjät palikat käyttäen palikan onkoTyhja() -metodia
     */
    public void poistaTyhjatPalikat() {
        for (int i = 0; i < palikat.size(); i++) {
            
            if (palikat.get(i).onkoTyhja()){
                palikat.remove(i);
                
            }
        }
    }
    /**
     * Paluttaa pelin tason
     * @return taso
     */
    public int getTaso() {
        return pistelaskuri.getTaso();
    }
    /**
     * asettaa käynnissä -muuttujan parametrina annettuun arvoon. jos uusi arvo
     * on false, pysäyttää kellon, jos true, käynnistää kellon.
     * @param boolean kaynnissa 
     */
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
    /**
     * 
     * @return kaynnissa
     */
    public boolean getKaynnissa() {
        return kaynnissa;
    }
    /**
     * Kutsuu tuloslistaa tallentamaan pistetilanteen parametrina annetulle
     * nimimerkille
     * 
     * @param nimimerkki 
     */
    public void tallennaPisteet(String nimimerkki) {
        if(nimimerkki.equals("")){
            nimimerkki = "anonymous";
        }
        tuloslista.kirjoitaTulos(nimimerkki, getPisteet());
    }
    /**
     * 
     * @return pelinLoppu
     */
    public boolean getPelinLoppu() {
        return pelinLoppu;
    }
    /**
     * Palauttaa kymmenen parasta tulosta merkkijonomuodossa.
     * @return String tulokset
     */
    public String getTulokset(){
        return tuloslista.getTulokset(10);
    }
    /**
     * Asettaa pelinLoppu -muuttujan parametrina annettuun arvoon. 
     * @param boolean b
     */
    public void setPelinLoppu(boolean b) {
        pelinLoppu = b;
    }
    /**
     * palauttaa peliOhi -muuttujan arvon
     * @return boolean peliOhi
     */
    public boolean onkoPeliOhi() {
        return peliOhi;
    }  
}
