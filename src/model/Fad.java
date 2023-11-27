package model;

import java.util.ArrayList;
import java.util.List;

public class Fad {
    private String fadFra;
    private String fadType;
    private int fillNr;
    private int fadNr;
    private double fadStørrelse;
    private List<Påfyldning> påfyldninger = new ArrayList<>();

    public Fad(String fadFra, String fadType, int fillNr, int fadNr, double fadStørrelse) {
        this.fadFra = fadFra;
        this.fadType = fadType;
        this.fillNr = fillNr;
        this.fadNr = fadNr;
        this.fadStørrelse = fadStørrelse;
    }

    public double udregnVolumen() {
        //TODO
        return 0;
    }
}
