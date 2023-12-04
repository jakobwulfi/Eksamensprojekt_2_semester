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
    public static Lager opretLager(int rækker, int hylder, String adresse, int kapacitet, String navn) {
        Lager l = new Lager(rækker, hylder, adresse, kapacitet, navn);
        storage.storeLager(l);
        return l;
    }

    /**
     * Update Lager.
     * Pre:
     */
    public static void updateLager(Lager lager, int rækker, int hylder, String adresse, int kapacitet, String navn) {
        lager.setRækker(rækker);
        lager.setHylder(hylder);
        lager.setAdresse(adresse);
        lager.setKapacitet(kapacitet);
        lager.setNavn(navn);
    }

    public static void addFadTilLager(Fad fad, Lager lager) {
        lager.addFad(fad);
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
    public static Påfyldning opretPåfyldning(Destillat destillat, Fad fad, LocalDate startDato, String medarbejder, double mængdeLiter, double alkoholProcent, LocalDate slutDato) {
        Påfyldning p = new Påfyldning(destillat, fad, startDato, medarbejder, mængdeLiter, alkoholProcent, slutDato);
        storage.storePåfyldning(p);
        return p;
    }

    /**
     * Update Påfyldning.
     * Pre:
     */
    public static void updatePåfyldning(Påfyldning påfyldning, Destillat destillat, Fad fad, LocalDate startDato,
                                        String medarbejder, double antalLiter, double alkoholProcent, LocalDate slutDato) {
        påfyldning.setDestillat(destillat);
        //påfyldning.setFad(fad);
        påfyldning.setStartDato(startDato);
        påfyldning.setMedarbejder(medarbejder);
        //påfyldning.setAntalLiter(antalLiter);
        påfyldning.setAlkoholProcent(alkoholProcent);
        påfyldning.setSlutDato(slutDato);
    }

    public static List<Påfyldning> getPåfyldninger() {
        return storage.getPåfyldninger();
    }

    //---------------------------------------------------------------------
}
