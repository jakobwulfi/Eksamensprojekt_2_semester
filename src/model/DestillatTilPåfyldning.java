package model;

import java.io.Serializable;

public class DestillatTilPåfyldning implements Serializable {
    private Destillat destillat;
    private double mængdeLiter;
    private double alkoholProcent;


    public DestillatTilPåfyldning(Destillat destillat, double mængdeLiter, double alkoholProcent){
        this.alkoholProcent=alkoholProcent;
        this.destillat = destillat;
        this.mængdeLiter = mængdeLiter;

    }


    public double getAlkoholProcent() {
        return alkoholProcent;
    }

    public double getMængdeLiter() {
        return mængdeLiter;
    }
}
