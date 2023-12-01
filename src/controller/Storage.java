package controller;

import model.Destillat;
import model.Fad;

import java.util.List;

public interface Storage {

    List<Destillat> getDestillater();
    void storeDestillat(Destillat d);

    //---------------------------------------------------------------------

    List<Fad> getFade();
    void storeFad(Fad f);
}
