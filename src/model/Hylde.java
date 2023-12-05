package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hylde implements Serializable {
    int hyldeNr;
    boolean ledig;
    int maxKapacitet;
    private final List<Fad> fade = new ArrayList<>();

    public Hylde(int hyldeNr, int maxKapacitet) {
        this.hyldeNr = hyldeNr;
        this.ledig = true;
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
     * Tilføjer et fad til hylden.
     * Thrower en IllegalArgumentException, hvis size på Listen af fade er lig med maxKapacitet.
     */
    public void addFad(Fad fad) {
        if (fade.size() < maxKapacitet) {
            fade.add(fad);
        } else {
            throw new IllegalArgumentException("Hylden er fuld.");
        }

    }
}
