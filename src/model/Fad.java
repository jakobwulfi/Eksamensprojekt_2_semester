package model;

import controller.Controller;

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
    public Fad() {
    }

    //---------------------------------------------------------------------

    /**
     * Opdater volumen på et fad
     * @param volumen
     */
    public void updateVolumen(double volumen) {
        if (volumen > fadStørrelse){
            throw new IllegalArgumentException("Mængde er Størrer end fadet kan indenholde");
        } else {
            this.NuværendeMængdeLiter = volumen;
        }
    }

    //---------------------------------------------------------------------

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

    //---------------------------------------------------------------------

    @Override
    public String toString() {
        Double tilbage = fadStørrelse-NuværendeMængdeLiter;
        return String.format("Fad nr: %d, Fill nr: %d\nVolumen tilbage: %.2f, \nFad type: %s",fadNr,fillNr, tilbage, fadType);
    }

    public String toStringLong(){
        return String.format("Fad nr: %d \nOprindelses land: %s \nFad type: %s \nFadstørrelse i liter: %.2f \nFill nr: %d"
                ,fadNr,fadFra,fadType,fadStørrelse,fillNr);
                //Sat fadnr først
    }
}
