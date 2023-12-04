package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Påfyldning implements Serializable {
    private List<DestillatTilPåfyldning> destillater;
    private LocalDate startDato;
    private String medarbejder;
    private double alkoholProcentStart;
    private double alkoholProcentNu;
    private LocalDate slutDato;

    public Påfyldning(List<DestillatTilPåfyldning> destillater,  LocalDate startDato, String medarbejder,  LocalDate slutDato) {
        this.destillater = destillater;
        this.startDato = startDato;
        this.medarbejder = medarbejder;
        this.slutDato = slutDato;
        beregnStartProcent();
    }
    // metoder

    // get og set
    public List<DestillatTilPåfyldning> getDestillat() {
        return destillater;
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

    /*public double getMængdeLiter() {
        return ;
    }*/

    public void beregnStartProcent(){
        double alkoholVolume = 0;
        double volume = 0;
        for (DestillatTilPåfyldning destillatTilPåfyldning : destillater){
            alkoholVolume += (destillatTilPåfyldning.getMængdeLiter() * (destillatTilPåfyldning.getAlkoholProcent()/100));
            volume += destillatTilPåfyldning.getMængdeLiter();
        }
        this.alkoholProcentStart = (alkoholVolume/volume)* 100;
        this.alkoholProcentNu = alkoholProcentStart;
    }

    public double getAlkoholProcent() {
        return alkoholProcentNu;
    }
    public void setAlkoholProcent(double alkoholProcent) {
        this.alkoholProcentNu = alkoholProcent;
    }
    public LocalDate getSlutDato() {
        return slutDato;
    }
    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
