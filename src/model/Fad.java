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
    // metoder
    public double udregnVolumen() {

        return 0;
    }

    // get og set
    public String getFadFra() {
        return fadFra;
    }
    public void setFadFra(String fadFra) {
        this.fadFra = fadFra;
    }
    public String getFadType() {
        return fadType;
    }
    public void setFadType(String fadType) {
        this.fadType = fadType;
    }
    public int getFillNr() {
        return fillNr;
    }
    public void setFillNr(int fillNr) {
        this.fillNr = fillNr;
    }
    public int getFadNr() {
        return fadNr;
    }
    public void setFadNr(int fadNr) {
        this.fadNr = fadNr;
    }
    public double getFadStørrelse() {
        return fadStørrelse;
    }
    public void setFadStørrelse(double fadStørrelse) {
        this.fadStørrelse = fadStørrelse;
    }
    public List<Påfyldning> getPåfyldninger() {
        return påfyldninger;
    }
}
