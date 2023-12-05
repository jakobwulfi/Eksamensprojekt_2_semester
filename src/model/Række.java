package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Række implements Serializable {
    int rækkeNr;
    boolean ledig;
    List<Hylde> hylder = new ArrayList<>();

    public Række(int rækkeNr) {
        this.rækkeNr = rækkeNr;
        this.ledig = true;
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
