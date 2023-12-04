package gui;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class MainGuiController {
    @FXML
    private Button btnOpretDestillat;

    @FXML
    private Button btnOpretFad;

    @FXML
    private Button btnOpretLager;

    @FXML
    private Button btnOpretPåfyldning;

    @FXML
    private Button btnTilføjDestillat;

    @FXML
    private Button btnTilføjFadTilLager;

    @FXML
    private Button btnTilføjWhisky;

    @FXML
    private TabPane guiStage;

    @FXML
    private Label lblAdresse;

    @FXML
    private Label lblAlkoholProcent;

    @FXML
    private Label lblDestillatPå;

    @FXML
    private Label lblDestillater;

    @FXML
    private Label lblDestillaterTilPåfyldning;

    @FXML
    private Label lblDestillaterWhisky;

    @FXML
    private Label lblFadInfo;

    @FXML
    private Label lblFadNr;

    @FXML
    private Label lblFadOprindelse;

    @FXML
    private Label lblFadPå;

    @FXML
    private Label lblFadStørrelse;

    @FXML
    private Label lblFadType;

    @FXML
    private Label lblFade;

    @FXML
    private Label lblFadeWhisky;

    @FXML
    private Label lblHylder;

    @FXML
    private Label lblInfoDestillat;

    @FXML
    private Label lblInfoFad;

    @FXML
    private Label lblKapacitet;

    @FXML
    private Label lblKommentar;

    @FXML
    private Label lblKornsort;

    @FXML
    private Label lblLager;

    @FXML
    private Label lblLagre;

    @FXML
    private Label lblMaltBatch;

    @FXML
    private Label lblMedarbejder;

    @FXML
    private Label lblNavn;

    @FXML
    private Label lblNewMakeNr;

    @FXML
    private Label lblRygeMateriale;

    @FXML
    private Label lblRækker;

    @FXML
    private Label lblSlutDato;

    @FXML
    private Label lblStartDato;

    @FXML
    private Label lblStartVolume;

    @FXML
    private Label lblWhiskyer;

    @FXML
    private ComboBox<?> lstLager;

    @FXML
    private ListView<?> lvwDestillatPå;

    @FXML
    private ListView<Destillat> lvwDestillater;

    @FXML
    private ListView<DestillatTilPåfyldning> lvwDestillaterTilPåfyldning;

    @FXML
    private ListView<?> lvwDestillaterWhisky;

    @FXML
    private ListView<Fad> lvwFadPå;

    @FXML
    private ListView<?> lvwFade;

    @FXML
    private ListView<?> lvwFadeWhisky;

    @FXML
    private ListView<?> lvwLagre;

    @FXML
    private ListView<?> lvwWhiskyer;

    @FXML
    private AnchorPane pnDestillater;

    @FXML
    private AnchorPane pnFade;

    @FXML
    private AnchorPane pnLager;

    @FXML
    private AnchorPane pnPåfyldning;

    @FXML
    private AnchorPane pnWhisky;

    @FXML
    private Tab tabDestilleringer;

    @FXML
    private Tab tabFade;

    @FXML
    private Tab tabLager;

    @FXML
    private Tab tabPåfyldning;

    @FXML
    private Tab tabWhisky;

    @FXML
    private TextArea txaFadInfo;

    @FXML
    private TextArea txaInfoDestillat;

    @FXML
    private TextArea txaInfoFad;

    @FXML
    private TextField txfAdresse;

    @FXML
    private TextField txfAlkoholProcent;

    @FXML
    private TextField txfFadNr;

    @FXML
    private TextField txfFadOprindelse;

    @FXML
    private TextField txfFadStørrelse;

    @FXML
    private TextField txfFadType;

    @FXML
    private TextField txfHylder;

    @FXML
    private TextField txfKapacitet;

    @FXML
    private TextField txfKommentar;

    @FXML
    private TextField txfKornsort;

    @FXML
    private TextField txfMaltBatch;

    @FXML
    private TextField txfMedarbejder;

    @FXML
    private TextField txfNavn;

    @FXML
    private TextField txfNewMakeNr;

    @FXML
    private TextField txfRygeMateriale;

    @FXML
    private TextField txfRækker;

    @FXML
    private TextField txfSlutDato;

    @FXML
    private TextField txfSlutDatoPåfyld;

    @FXML
    private TextField txfStartDato;

    @FXML
    private TextField txfStartDatoPåfyld;

    @FXML
    private TextField txfStartVolume;

    @FXML
    private TextField txfVolumen;


    @FXML
    void opretDestillatAction(ActionEvent event) {
        try {
            double alkoholProcent = Double.valueOf(txfAlkoholProcent.getText());
            double startVolume = Double.valueOf(txfStartVolume.getText());
            LocalDate start = LocalDate.parse(txfStartDato.getText());
            LocalDate slut = LocalDate.parse(txfSlutDato.getText());
            if (alkoholProcent > 100 || alkoholProcent < 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(guiStage.getScene().getWindow());
                alert.setTitle("Procent Error");
                alert.setHeaderText("Alkohol procent skal være mellem 0 og 100.");
                alert.show();
            } else if (start.isAfter(slut)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(guiStage.getScene().getWindow());
                alert.setTitle("Date Error");
                alert.setHeaderText("Start dato skal være før slut dato.");
                alert.show();
            } else {
                Controller.opretDestillat(txfMaltBatch.getText(), txfKornsort.getText(), txfMedarbejder.getText(),
                        Double.valueOf(txfAlkoholProcent.getText()), txfRygeMateriale.getText(), txfKommentar.getText(),
                        txfNewMakeNr.getText(), LocalDate.parse(txfStartDato.getText()), LocalDate.parse(txfSlutDato.getText()),
                        Double.valueOf(txfStartVolume.getText()));
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(guiStage.getScene().getWindow());
            alert.setTitle("Format Error");
            alert.setHeaderText("Fejl i alkohol procent ellser start volume.");
            alert.show();
        } catch (DateTimeParseException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(guiStage.getScene().getWindow());
            alert.setTitle("Format Error");
            alert.setHeaderText("fejl i dato.");
            alert.show();
        }

        //---------------------------------------------------------------------

    }

    @FXML
    void opretFadAction(ActionEvent event) {
        try {
            int fadNr = Integer.valueOf(txfFadNr.getText());
            double fadStørrelse = Double.valueOf(txfFadStørrelse.getText());
            Controller.opretFad(txfFadOprindelse.getText(), txfFadType.getText(), fadNr, fadStørrelse);

        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(guiStage.getScene().getWindow());
            alert.setTitle("Format Error");
            alert.setHeaderText("Fejl i Fad nr eller størrelse");
            alert.show();
        }
    }

    //---------------------------------------------------------------------

    @FXML
    void opretLagerAction(ActionEvent event) {
        try {
            int rækker = Integer.valueOf(txfRækker.getText());
            int hylder = Integer.valueOf(txfHylder.getText());

            String adresse = txfAdresse.getText();
            int kapacitet = Integer.valueOf(txfKapacitet.getText());
            String navn = txfNavn.getText();
            if (adresse.equals(null) || navn.equals(null)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(guiStage.getScene().getWindow());
                alert.setTitle("Indtastnings Fejl");
                alert.setHeaderText("Indtast venlist en adresse");
                alert.show();
            } else {
                Controller.opretLager(rækker, hylder, adresse, kapacitet, navn);
            }
        } catch (NullPointerException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(guiStage.getScene().getWindow());
            alert.setTitle("Format Error");
            alert.setHeaderText("Fejl i indtastning");
            alert.show();
        }
    }

    //---------------------------------------------------------------------

    @FXML
    void opretPåfyldningAction(ActionEvent event) {
        try {
            List<DestillatTilPåfyldning> destillat = lvwDestillaterTilPåfyldning.getItems();
            Fad fad = lvwFadPå.getSelectionModel().getSelectedItem(); // måske ikke korrekt
            LocalDate startDato = LocalDate.parse(txfStartDato.getText());
            String medarbejder = txfMedarbejder.getText();
            LocalDate slutDato = LocalDate.parse(txfSlutDato.getText());

            if (startDato.isAfter(slutDato)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(guiStage.getScene().getWindow());
                alert.setTitle("Date Error");
                alert.setHeaderText("Start dato skal være før slut dato.");
                alert.show();
            } else if (medarbejder.equals(null)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(guiStage.getScene().getWindow());
                alert.setTitle("Indtastnings Fejl");
                alert.setHeaderText("Indtast venlist en medarbejder");
                alert.show();
            } else {
                Controller.opretPåfyldning(destillat, fad, startDato, medarbejder, slutDato);
            }
        } catch (NullPointerException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(guiStage.getScene().getWindow());
            alert.setTitle("Format Error");
            alert.setHeaderText("Fejl i indtastning");
            alert.show();
        } catch (DateTimeParseException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(guiStage.getScene().getWindow());
            alert.setTitle("Format Error");
            alert.setHeaderText("Fejl i Dato indtastning");
            alert.show();
        } catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(guiStage.getScene().getWindow());
            alert.setTitle("Format Error");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    //---------------------------------------------------------------------

    @FXML
    void tilføjFadTilLagerAction(ActionEvent event) {
        Lager lager = (Lager) lstLager.getValue();
        Fad fad = (Fad) lvwFade.getSelectionModel().getSelectedItem(); // muuuuh
        Controller.addFadTilLager(fad, lager);
    }

    //---------------------------------------------------------------------

    @FXML
    void tilføjWhiskyAction(ActionEvent event) {
        Whisky whisky = (Whisky) lvwWhiskyer.getSelectionModel().getSelectedItem();
        // mangler whisky add metode?
    }

    //---------------------------------------------------------------------

    @FXML
    void opretDestillatTilPåfyldningAction(ActionEvent event) {
        try {
            Destillat destillat = lvwDestillater.getSelectionModel().getSelectedItem();
            double mængdeLiter = Double.valueOf(txfVolumen.getText());
            DestillatTilPåfyldning d = Controller.opretDestillatTilPåfyldning(destillat,mængdeLiter);
            lvwDestillaterTilPåfyldning.getItems().add(d);
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(guiStage.getScene().getWindow());
            alert.setTitle("Format Error");
            alert.setHeaderText("Fejl i Volumen");
            alert.show();
        } catch (IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(guiStage.getScene().getWindow());
            alert.setTitle("Format Error");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }


    }
}
