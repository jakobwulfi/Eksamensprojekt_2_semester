package model;

import java.time.LocalDate;

public class Destillat {
    private String maltBatch;
    private String kornsort;
    private String medarbejder;
    private double mængdeLiter;
    private double alkoholProcent;
    private String rygeMateriale;
    private String kommentar;
    private String newMakeNr;
    private LocalDate startDato;
    private LocalDate slutDato;
    private double startVolume;

    public Destillat(String maltBatch, String kornsort, String medarbejder, double mængdeLiter, double alkoholProcent,
        String rygeMateriale, String kommentar, String newMakeNr, LocalDate startDato, LocalDate slutDato, double startVolume) {
        this.maltBatch = maltBatch;
        this.kornsort = kornsort;
        this.medarbejder = medarbejder;
        this.mængdeLiter = mængdeLiter;
        this.alkoholProcent = alkoholProcent;
        this.rygeMateriale = rygeMateriale;
        this.kommentar = kommentar;
        this.newMakeNr = newMakeNr;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.startVolume = startVolume;
    }
    // metoder

    // get og set
    public String getMaltBatch() {
        return maltBatch;
    }
    public void setMaltBatch(String maltBatch) {
        this.maltBatch = maltBatch;
    }
    public String getKornsort() {
        return kornsort;
    }
    public void setKornsort(String kornsort) {
        this.kornsort = kornsort;
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
    public String getRygeMateriale() {
        return rygeMateriale;
    }
    public void setRygeMateriale(String rygeMateriale) {
        this.rygeMateriale = rygeMateriale;
    }
    public String getKommentar() {
        return kommentar;
    }
    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
    public String getNewMakeNr() {
        return newMakeNr;
    }
    public void setNewMakeNr(String newMakeNr) {
        this.newMakeNr = newMakeNr;
    }
    public LocalDate getStartDato() {
        return startDato;
    }
    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }
    public LocalDate getSlutDato() {
        return slutDato;
    }
    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }
    public double getStartVolume() {
        return startVolume;
    }
    public void setStartVolume(double startVolume) {
        this.startVolume = startVolume;
    }
}
