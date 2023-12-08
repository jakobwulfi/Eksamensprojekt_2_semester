package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Destillat implements Serializable {
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

    public Destillat(String maltBatch, String kornsort, String medarbejder, double alkoholProcent,
        String rygeMateriale, String kommentar, String newMakeNr, LocalDate startDato, LocalDate slutDato, double startVolume) {
        this.maltBatch = maltBatch;
        this.kornsort = kornsort;
        this.medarbejder = medarbejder;
        this.alkoholProcent = alkoholProcent;
        this.rygeMateriale = rygeMateriale;
        this.kommentar = kommentar;
        this.newMakeNr = newMakeNr;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.startVolume = startVolume;
        this.mængdeLiter = startVolume;
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
    public String setKasper() {
        return "hej";
    }

    @Override
    public String toString() {
        return String.format("New make nr: %s. Alkohol procent: %f. Kornsort: %s",newMakeNr,alkoholProcent,kornsort );
    }

    public String destillatInfo(){
        return String.format("Maltbatch: %s. Kornsort: %s. Medarbejder: %s.  Mængde i liter: %f. Alkohol procent: %f."
                        + " Ryge materiale: %s.  Kommentar: %s. New make nr: %s. Start dato: " + startDato.toString()
                + ". Slut dato: " + slutDato.toString() + ". Start volume: %f", maltBatch,kornsort,medarbejder,
                mængdeLiter, alkoholProcent, rygeMateriale, kommentar,newMakeNr, startVolume);
    }


}
