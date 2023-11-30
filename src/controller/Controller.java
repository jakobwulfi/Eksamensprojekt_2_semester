package controller;

import model.Destillat;
import model.Fad;

import java.time.LocalDate;

public abstract class Controller {
    private static Storage storage;
    public static void setStorage(Storage storage) {
        Controller.storage = storage;
    }
    // Controller metoder for destillat
    public static Destillat opretDestillat(String maltBatch, String kornsort, String medarbejder,  double alkoholProcent,
    String rygeMateriale, String kommentar, String newMakeNr, LocalDate startDato, LocalDate slutDato, double startVolume) {
    Destillat d = new Destillat(maltBatch, kornsort, medarbejder, alkoholProcent, rygeMateriale, kommentar, newMakeNr,
            startDato, slutDato, startVolume);
    storage.storeDestillat(d);
    return d;
    }

    // Controller metoder for fad
    public static Fad opretFad(String fadFra, String fadType, int fadNr, double fadStørrelse) {
        Fad f = new Fad(fadFra, fadType,  fadNr, fadStørrelse);
        storage.storeFad(f);
        return f;
    }
}
