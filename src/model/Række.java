package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Række implements Serializable {
    private int rækkeNr;
    private boolean ledig;
    private final List<Hylde> hylder = new ArrayList<>();

    public Række(int rækkeNr, Lager lager) {
        this.rækkeNr = rækkeNr;
        this.ledig = true;
    }

    //---------------------------------------------------------------------

    public int getRækkeNr() {
        return rækkeNr;
    }

    public List<Hylde> getHylder() {
        return hylder;
    }
    public void addHylde(Hylde h) {
        hylder.add(h);
    }

    public boolean isLedig() {
        return ledig;
    }

    public void setRækkeNr(int rækkeNr) {
        this.rækkeNr = rækkeNr;
    }

    public void setLedig(boolean ledig) {
        this.ledig = ledig;
    }

    //---------------------------------------------------------------------

    /**
     * Returnere true hvis rækken er fyldt, ud fra hylde
     * Returnere false hvis det er mere plads
     */
    public boolean ErRækkeFyldt(Hylde hylde) {
        if (hylder.size() == hylde.getMaxKapacitet()) {
            return true;
        } else {
            return false;
        }
    }

}
