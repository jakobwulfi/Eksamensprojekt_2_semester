package controller;

import model.*;

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
     * Pre:
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
     * Pre:
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

    /**
     * Opret et nyt Lager
     * Pre:
     */
    public static Lager opretLager(String adresse, int kapacitet, String navn) {
        Lager l = new Lager(adresse, kapacitet, navn);
        storage.storeLager(l);
        return l;
    }

    /**
     * Update Lager.
     * Pre:
     */
    public static void updateLager(Lager lager, String adresse, int kapacitet, String navn) {
        lager.setAdresse(adresse);
        lager.setKapacitet(kapacitet);
        lager.setNavn(navn);
    }

    public static void addFadTilHylde(Fad fad, Hylde hylde) {
        hylde.addFad(fad);
    }

    public static List<Lager> getLagere() {
        return storage.getLagere();
    }

    //---------------------------------------------------------------------

    /**
     * Opret en nyt Whisky
     * Pre:
     */
    public static Whisky opretWhisky(String whiskyType, int nummer) {
        Whisky w = new Whisky(whiskyType, nummer);
        storage.storeWhisky(w);
        return w;
    }

    /**
     * Update Whisky.
     * Pre:
     */
    public static void updateWhisky(Whisky whisky, String whiskyType, int nummer) {
        whisky.setWhiskyType(whiskyType);
        whisky.setNummer(nummer);
    }

    public static List<Whisky> getWhisker() {
        return storage.getWhiskyer();
    }

    //---------------------------------------------------------------------

    /**
     * Opret en nyt Påfyldning
     * Pre:
     */
    public static Påfyldning opretPåfyldning(List<DestillatTilPåfyldning> destillater, Fad fad, LocalDate startDato,
                                             String medarbejder,  LocalDate slutDato) {
        double volumen = 0;
        for (DestillatTilPåfyldning destillatTilPåfyldning : destillater){
            volumen+= destillatTilPåfyldning.getMængdeLiter();
        }
        if (volumen > fad.getFadStørrelse()){
            throw new IllegalArgumentException("Påfyldning for stor til fad");
        } else {
            Påfyldning p = new Påfyldning(destillater, startDato, medarbejder, slutDato);
            fad.setPåfyldning(p);
            return p;
        }
    }

    /**
     * Opret er DestillatTilPåfyldning
     */

    public static DestillatTilPåfyldning opretDestillatTilPåfyldning(Destillat destillat, double mængdeLiter){
        if (destillat.getMængdeLiter() - mængdeLiter < 0) {
           throw new IllegalArgumentException("Mængden af væske til påfyldning er større end mængden der er tilbage af destillatet");
        }
        DestillatTilPåfyldning d = new DestillatTilPåfyldning(destillat, mængdeLiter,destillat.getAlkoholProcent());
        destillat.setMængdeLiter(destillat.getMængdeLiter() - mængdeLiter);
        return d;
    }

    /**
     * Update Påfyldning.
     * Pre:
     */
    /*public static void updatePåfyldning(Påfyldning påfyldning, Destillat destillat, Fad fad, LocalDate startDato,
                                        String medarbejder, double antalLiter, double alkoholProcent, LocalDate slutDato) {
        //påfyldning.setFad(fad);
        påfyldning.setStartDato(startDato);
        påfyldning.setMedarbejder(medarbejder);
        //påfyldning.setAntalLiter(antalLiter);
        påfyldning.setAlkoholProcent(alkoholProcent);
        påfyldning.setSlutDato(slutDato);
    }*/


    //---------------------------------------------------------------------
}
