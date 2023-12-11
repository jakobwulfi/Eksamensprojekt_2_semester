package model;

import java.io.Serializable;

public class FadInfo extends Fad implements Serializable {
    Fad fad;
    String lokation;
    public FadInfo(Fad fad, String lokation) {
        super();
        this.fad = fad;
        this.lokation = lokation;
    }

    @Override
    public String toString() {
        return fad + ", "+ lokation;
    }
}
