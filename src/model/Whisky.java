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
}
