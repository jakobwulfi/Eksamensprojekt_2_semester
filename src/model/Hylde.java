package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hylde implements Serializable {
    int hyldeNr;
    boolean ledig;
    int maxKapacitet;
    List<Fad> fade = new ArrayList<>();

    public Hylde(int hyldeNr, boolean ledig, int maxKapacitet) {
        this.hyldeNr = hyldeNr;
        this.ledig = ledig;
        this.maxKapacitet = maxKapacitet;
    }

    public int getHyldeNr() {
        return hyldeNr;
    }

    public boolean isLedig() {
        return ledig;
    }

    public int getMaxKapacitet() {
        return maxKapacitet;
    }

    public List<Fad> getFade() {
        return fade;
    }

    //---------------------------------------------------------------------

    /**
     * Tilføjer et fad til lager
     */
    public void addFad(Fad fad) {
        fade.add(fad);
    }
}
