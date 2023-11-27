package model;

import java.time.LocalDate;

public class Påfyldning {
    private Destillat destillat;
    private Fad fad;
    private LocalDate startDato;
    private String medarbejder;
    private double antalLiter;
    private double alkoholProcent;
    private LocalDate slutDato;

    public Påfyldning(Destillat destillat, Fad fad, LocalDate startDato, String medarbejder, double antalLiter, double alkoholProcent, LocalDate slutDato) {
        this.destillat = destillat;
        this.fad = fad;
        this.startDato = startDato;
        this.medarbejder = medarbejder;
        this.antalLiter = antalLiter;
        this.alkoholProcent = alkoholProcent;
        this.slutDato = slutDato;
    }
}
