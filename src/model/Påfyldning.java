package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Påfyldning implements Serializable {
    private List<DestillatTilPåfyldning> destillater = new ArrayList<>();
    private LocalDate startDato;
    private String medarbejder;
    private double alkoholProcentStart;
    private double alkoholProcentNu;

    public Påfyldning(List<DestillatTilPåfyldning> destillater,  LocalDate startDato, String medarbejder) {
        this.destillater.addAll(destillater);
        this.startDato = startDato;
        this.medarbejder = medarbejder;
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

    @Override
    public String toString() {
        return super.toString();
    }
}
