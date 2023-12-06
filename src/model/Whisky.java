package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Whisky implements Serializable {
    private String whiskyType;
    private double antalFlasker;
    private double alkoholProcent;
    private List<Destillat> destillater = new ArrayList<>();
    private List<Fad> fade = new ArrayList<>();

    public Whisky(List<Fad> fade) {
        this.whiskyType = whiskyType;
        if (fade.size() > 1) {
            this.whiskyType = "Single Malt";
        } else {
            this.whiskyType = "Single Cask";
        }
        for (Fad f : fade) {
            for (DestillatTilPåfyldning dtp : f.getPåfyldning().getDestillat()) {
                destillater.add(dtp.getDestillat());
            }
        }
        updateAntalFlasker();
        updateAlkoholProcent();
    }
    // metoder
    public String getWhiskyType() {
        return whiskyType;
    }
    public void setWhiskyType(String whiskyType) {
        this.whiskyType = whiskyType;
    }
    public double getAntalFlasker() {
        return antalFlasker;
    }
    public void updateAntalFlasker() {
        double sum = 0;
        for (Fad f : fade) {
            sum += f.getNuværendeMængdeLiter();
        }
        this.antalFlasker = sum/0.7;
    }
    private void updateAlkoholProcent() {
        double alkoholVolume = 0;
        double volume = 0;
        for (Fad f : fade) {
            alkoholVolume += (f.getNuværendeMængdeLiter() * (f.getPåfyldning().getAlkoholProcent()));
            volume += f.getNuværendeMængdeLiter();
        }
        this.alkoholProcent = (alkoholVolume/volume)* 100;
    }
    public List<Destillat> getDestillater() {
        return destillater;
    }
    public void setDestillater(List<Destillat> destillater) {
        this.destillater = destillater;
    }
    public List<Fad> getFade() {
        return fade;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
