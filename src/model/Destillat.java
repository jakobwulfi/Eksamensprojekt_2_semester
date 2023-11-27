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

    public Destillat(String maltBatch, String kornsort, String medarbejder, double mængdeLiter, double alkoholProcent, String rygeMateriale, String kommentar, String newMakeNr, LocalDate startDato, LocalDate slutDato, double startVolume) {
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
}
