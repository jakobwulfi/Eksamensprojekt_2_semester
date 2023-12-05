package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Række implements Serializable {
    int rækkeNr;
    boolean ledig;
    List<Hylde> hylder = new ArrayList<>();

    public Række(int rækkeNr, boolean ledig) {
        this.rækkeNr = rækkeNr;
        this.ledig = ledig;
    }

    public int getRækkeNr() {
        return rækkeNr;
    }
    public List<Hylde> getHylder() {
        return hylder;
    }
    public boolean isLedig() {
        return ledig;
    }
}
