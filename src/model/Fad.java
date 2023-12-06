package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Fad implements Serializable {
    private String fadFra;
    private String fadType;
    private int fillNr;
    private int fadNr;
    private double fadStørrelse;
    private double NuværendeMængdeLiter = 0;
    private Påfyldning påfyldning;

    public Fad(String fadFra, String fadType, int fadNr, double fadStørrelse) {
        this.fadFra = fadFra;
        this.fadType = fadType;
        this.fillNr = 1;
        this.fadNr = fadNr;
        this.fadStørrelse = fadStørrelse;
    }
    // metoder
    public void updateVolumen(double volumen) {
        if (volumen > fadStørrelse){
            throw new IllegalArgumentException("Mængde er Størrer end fadet kan indenholde");
        } else {
            this.NuværendeMængdeLiter = volumen;
        }
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
    public Påfyldning getPåfyldning() {
        return påfyldning;
    }
    public double getNuværendeMængdeLiter() {
        return NuværendeMængdeLiter;
    }

    public void setPåfyldning(Påfyldning påfyldning) {
        this.påfyldning = påfyldning;
    }

    @Override
    public String toString() {
        return String.format("Oprindelses land: %s. Fad type: %s. Fadstørrelse i liter: %f. Fill nr: %d. Fad nr: %d"
                ,fadFra,fadType,fadStørrelse,fillNr, fadNr);
    }
}
