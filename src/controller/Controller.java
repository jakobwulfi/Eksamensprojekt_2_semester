package controller;

import model.Destillat;
import model.Fad;

import java.time.LocalDate;
import java.util.List;

public abstract class Controller {
    private static Storage storage;
    public static void setStorage(Storage storage) {
        Controller.storage = storage;
    }

    //---------------------------------------------------------------------

    /**
     * Opret et nyt Destillat
     * Pre: startDato > Slutdato,
     */
    public static Destillat opretDestillat(String maltBatch, String kornsort, String medarbejder,  double alkoholProcent,
    String rygeMateriale, String kommentar, String newMakeNr, LocalDate startDato, LocalDate slutDato, double startVolume) {
    Destillat d = new Destillat(maltBatch, kornsort, medarbejder, alkoholProcent, rygeMateriale, kommentar, newMakeNr,
            startDato, slutDato, startVolume);
    storage.storeDestillat(d);
    return d;
    }

    /**
     * Update Destilat.
     */
    public static void updateDestillat(Destillat destillat, String maltBatch, String kornsort, String medarbejder, double mængdeLiter, double alkoholProcent,
                                       String rygeMateriale, String kommentar, String newMakeNr, LocalDate startDato, LocalDate slutDato, double startVolume) {
        destillat.setMaltBatch(maltBatch);
        destillat.setKornsort(kornsort);
        destillat.setMedarbejder(medarbejder);
        destillat.setMængdeLiter(mængdeLiter);
        destillat.setAlkoholProcent(alkoholProcent);
        destillat.setRygeMateriale(rygeMateriale);
        destillat.setKommentar(kommentar);
        destillat.setNewMakeNr(newMakeNr);
        destillat.setStartDato(startDato);
        destillat.setSlutDato(slutDato);
        destillat.setStartVolume(startVolume);
    }

    public static List<Destillat> getDestillater() {
        return storage.getDestillater();
    }

    //---------------------------------------------------------------------

    /**
     * Opret et nyt Fad
     * Pre:
     */
    public static Fad opretFad(String fadFra, String fadType, int fadNr, double fadStørrelse) {
        Fad f = new Fad(fadFra, fadType,  fadNr, fadStørrelse);
        storage.storeFad(f);
        return f;
    }

    /**
     * Update Fad.
     */
    public static void updateFad(Fad fad, String fadFra, String fadType, int fillNr, int fadNr, double fadStørrelse) {
        fad.setFadFra(fadFra);
        fad.setFadType(fadType);
        fad.setFillNr(fillNr);
        fad.setFadNr(fadNr);
        fad.setFadStørrelse(fadStørrelse);
    }

    public static List<Fad> getFade() {
        return storage.getFade();
    }

    //---------------------------------------------------------------------
}
