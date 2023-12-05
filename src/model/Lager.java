package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Lager implements Serializable {
    private String adresse;
    private int kapacitet;
    private String navn;
    private List<Række> rækker = new ArrayList<>();

    public Lager(String adresse, int kapacitet, String navn) {
        this.adresse = adresse;
        this.kapacitet = kapacitet;
        this.navn = navn;
    }

    public Lager(String adresse, int kapacitet, String navn, List<Række> rækker) {
        this.adresse = adresse;
        this.kapacitet = kapacitet;
        this.navn = navn;
        this.rækker = rækker;
    }

    //---------------------------------------------------------------------

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
    public List<Række> getRækker() {
        return rækker;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
