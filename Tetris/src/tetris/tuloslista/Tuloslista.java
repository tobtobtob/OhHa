
package tetris.tuloslista;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Tuloslista kirjoittaa annetut tulokset tiedostoon, ja kutsuttaessa 
 * palauttaa ne pistearvon mukaan järjestettynä merkkijonolistana.
 * 
 */
public class Tuloslista {
    /**
     * tiedosto, johon tulokset kirjoitetaan, ja josta tulokset luetaan.
     */
    private File tiedosto;
    /**
     * Scanner -olio, jonka avulla luetaan tulokset.
     */
    private Scanner lukija;
    /**
     * Luo tuloslistan ja alustaa tiedoston oikeaksi tiedostoksi. 
     */
    public Tuloslista() {
        tiedosto = new File("tuloslista.txt");
        
    }
    /**
     * Metodi kirjoittaa tuloslista.txt tiedostoon annetun pistesaldon 
     * ja nimimerkin omalle rivilleen.
     * 
     * @param nimimerkki
     * @param pisteet 
     */
    public void kirjoitaTulos(String nimimerkki, int pisteet){
        try {
            FileWriter kirjoittaja = new FileWriter(tiedosto, true);
            kirjoittaja.append(pisteet+":"+nimimerkki +"\n");
            kirjoittaja.close();
        } catch (IOException ex) {           
        }        
    }
    /**
     * Metodi luo tuloslista.txt -tiedoston sisältämistä riveistä tulos 
     * -olioita, ja palauttaa ne ArrayListinä
     * @return lista tulos-olioista.
     */
    public ArrayList<Tulos> luoTuloslista(){
        ArrayList<Tulos> tulokset;
        try {
            tulokset = new ArrayList<Tulos>();
            lukija = new Scanner(tiedosto);
            while (lukija.hasNextLine()){
                String tulos = lukija.nextLine();
                String[] osat = tulos.split(":");
                tulokset.add(new Tulos(Integer.parseInt(osat[0]), osat[1]));
            }
        } catch (FileNotFoundException ex) {
            return null;
        }
        return tulokset;
    }
    /**
     * Palauttaa tulokset merkkijonomuodossa järjestettynä riveittäin 
     * suurimmasta pieninpään.
     * 
     * @param kuinka monta tulosta merkkijonoon sisällytetään.
     * @return merkkijono tuloksista.
     */
    public String getTulokset(int kuinkaMonta){
        ArrayList<Tulos> tulokset = luoTuloslista();
       String palautus = "";
        if(tulokset.isEmpty()){
            return "<ei tuloksia>";
        }
        Collections.sort(tulokset);
        for (int i = 0; i <= Math.min(kuinkaMonta, tulokset.size()-1); i++) {
            palautus += tulokset.get(i).toString() +"\n";
        }
        return palautus;
    }
    /**
     * tyhjentää tuloslista.txt -tiedoston, eli tuloslistan tallentamat ennätykset.
     */
    public void tyhjenna(){
        try {
            FileWriter kirjoittaja = new FileWriter(tiedosto);
            kirjoittaja.write("");
            kirjoittaja.close();
        } catch (IOException ex) {           
        }    
    }
    
    
}
