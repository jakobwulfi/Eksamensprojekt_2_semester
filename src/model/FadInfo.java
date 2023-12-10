package model;

public class FadInfo extends Fad {
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
