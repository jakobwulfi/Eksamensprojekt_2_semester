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


    /**
     * Tilføjer et fad til lager
     */
    private void addFad(Fad fad) {
        fade.add(fad);
    }
}
