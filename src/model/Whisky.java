package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Whisky implements Serializable {
    private String whiskyType;
    private double antalFlasker;
    private double alkoholProcent;
    //private LocalDate lagringsdDato;
    private LocalDate tapningsDato;
    private List<Destillat> destillater = new ArrayList<>();
    private List<Fad> fade = new ArrayList<>();

    public Whisky(List<Fad> fade) {
        this.whiskyType = whiskyType;
        if (fade.size() > 1) {
            this.whiskyType = "Single Malt";
        } else {
            this.whiskyType = "Single Cask";
        }
        for (Fad f : fade) {
            for (DestillatTilPåfyldning dtp : f.getPåfyldning().getDestillat()) {
                destillater.add(dtp.getDestillat());
            }
        }
        this.tapningsDato = LocalDate.now();
        updateAntalFlasker();
        updateAlkoholProcent();
    }
    // metoder
    public String getWhiskyType() {
        return whiskyType;
    }
    public void setWhiskyType(String whiskyType) {
        this.whiskyType = whiskyType;
    }
    public double getAntalFlasker() {
        return antalFlasker;
    }
    public void updateAntalFlasker() {
        double sum = 0;
        for (Fad f : fade) {
            sum += f.getNuværendeMængdeLiter();
        }
        this.antalFlasker = sum/0.7;
    }
    private void updateAlkoholProcent() {
        double alkoholVolume = 0;
        double volume = 0;
        for (Fad f : fade) {
            alkoholVolume += (f.getNuværendeMængdeLiter() * (f.getPåfyldning().getAlkoholProcent()));
            volume += f.getNuværendeMængdeLiter();
        }
        this.alkoholProcent = (alkoholVolume/volume)* 100;
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

    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Denne metode tager information fra alle fad og destillater tilknyttet til den pågældene whisky
     * og sætter dem sammmen i en enkelt String, der repræsenterer den etikette, der bliver printet på flasken.
     * @return etikette - en String med relevant information fra fadene og destillaterne
     */
    public String toEtikette() {
        String etikette = "";

        // Fade info
        String fadeFra = "Fade fra: ";
        String fadeType = "Fade fra: ";
        for (Fad f : fade) {
            if (!fadeFra.contains(f.getFadFra())) {
                fadeFra += f.getFadFra() + " ";
            }
            if (!fadeType.contains(f.getFadType())) {
                fadeType += f.getFadType() + " ";
            }
        }
        etikette += fadeFra + "\n" + fadeType + "\n";

        // destillat info
        String kornsort = "Kornsorte anvendt: ";
        String medarbejder = "Hvem har lavet whiskyen: ";
        String rygemateriale = "Rygemateriale anvendt: ";
        String maltBatch = "Malt anvendt: ";
        for (Destillat d : destillater) {
            if (!kornsort.contains(d.getKornsort())) {
                kornsort += d.getKornsort() + " ";
            }
            if (!medarbejder.contains(d.getMedarbejder())) {
                medarbejder += d.getMedarbejder() + " ";
            }
            if (!rygemateriale.contains(d.getRygeMateriale())) {
                rygemateriale += d.getRygeMateriale() + " ";
            }
            if (!maltBatch.contains(d.getMaltBatch())) {
                maltBatch += d.getMaltBatch() + " ";
            }
        }
        etikette += kornsort + "\n" + medarbejder + "\n" + rygemateriale + "\n" + maltBatch + "\n" +
                "Tapningsdato: " + this.tapningsDato + "\n" + "Alkoholprocent: " + this.alkoholProcent;
        return etikette;
    }
}
