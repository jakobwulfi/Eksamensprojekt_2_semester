package model;

import java.util.ArrayList;
import java.util.List;

public class Lager {
    private int rækker;
    private int hylder;
    private String adresse;
    private int kapacitet;
    private String navn;
    private List<Fad> fade = new ArrayList<>();

    public Lager(int rækker, int hylder, String adresse, int kapacitet, String navn) {
        this.rækker = rækker;
        this.hylder = hylder;
        this.adresse = adresse;
        this.kapacitet = kapacitet;
        this.navn = navn;
    }
    // metoder
    /**
     * Tilføjer et fad til lager
     */
    public void addFad(Fad fad) {
        fade.add(fad);
    }

    // get og set
    public int getRækker() {
        return rækker;
    }
    public void setRækker(int rækker) {
        this.rækker = rækker;
    }
    public int getHylder() {
        return hylder;
    }
    public void setHylder(int hylder) {
        this.hylder = hylder;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public int getKapacitet() {
        return kapacitet;
    }
    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }
    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public List<Fad> getFade() {
        return fade;
    }
}
