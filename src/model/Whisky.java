package model;

import java.util.ArrayList;
import java.util.List;

public class Whisky {
    private String whiskyType;
    private int nummer;
    private List<Destillat> destillater = new ArrayList<>();
    private List<Fad> fade = new ArrayList<>();

    public Whisky(String whiskyType, int nummer) {
        this.whiskyType = whiskyType;
        this.nummer = nummer;
    }
    // metoder

    // get og set
    public String getWhiskyType() {
        return whiskyType;
    }
    public void setWhiskyType(String whiskyType) {
        this.whiskyType = whiskyType;
    }
    public int getNummer() {
        return nummer;
    }
    public void setNummer(int nummer) {
        this.nummer = nummer;
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
}
