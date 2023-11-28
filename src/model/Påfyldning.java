package model;

import java.time.LocalDate;

public class Påfyldning {
    private Destillat destillat;
    private LocalDate startDato;
    private String medarbejder;
    private double mængdeLiter;
    private double alkoholProcent;
    private LocalDate slutDato;

    public Påfyldning(Destillat destillat, Fad fad, LocalDate startDato, String medarbejder, double antalLiter, double alkoholProcent, LocalDate slutDato) {
        this.destillat = destillat;
        this.startDato = startDato;
        this.medarbejder = medarbejder;
        this.mængdeLiter = antalLiter;
        this.alkoholProcent = alkoholProcent;
        this.slutDato = slutDato;
    }
    // metoder

    // get og set
    public Destillat getDestillat() {
        return destillat;
    }
    public void setDestillat(Destillat destillat) {
        this.destillat = destillat;
    }
    public LocalDate getStartDato() {
        return startDato;
    }
    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }
    public String getMedarbejder() {
        return medarbejder;
    }
    public void setMedarbejder(String medarbejder) {
        this.medarbejder = medarbejder;
    }
    public double getMængdeLiter() {
        return mængdeLiter;
    }
    public void setMængdeLiter(double mængdeLiter) {
        this.mængdeLiter = mængdeLiter;
    }
    public double getAlkoholProcent() {
        return alkoholProcent;
    }
    public void setAlkoholProcent(double alkoholProcent) {
        this.alkoholProcent = alkoholProcent;
    }
    public LocalDate getSlutDato() {
        return slutDato;
    }
    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }
}
