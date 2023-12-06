package gui;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class MainGuiController {

    @FXML
    private ImageView imgSall;
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
    private ImageView imgLogo;

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
    private ListView<Destillat> lvwDestillatPå;

    @FXML
    private ListView<Fad> lvwFade;


    @FXML
    private ListView<Fad> lvwFadeLager;

    @FXML
    private ListView<Destillat> lvwDestillater;

    @FXML
    private ListView<DestillatTilPåfyldning> lvwDestillaterTilPåfyldning;

    @FXML
    private ListView<?> lvwDestillaterWhisky;

    @FXML
    private ListView<Fad> lvwFadPå;

    @FXML
    private ListView<Fad> lvwFadeWhisky;

    @FXML
    private ListView<Lager> lvwLagre;

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
    private TextField txfHylde;

    @FXML
    private TextField txfHyldeNr;

    @FXML
    private TextField txfHylder;

    @FXML
    private TextField txfKommentar;

    @FXML
    private TextField txfKornsort;

    @FXML
    private TextField txfMaltBatch;

    @FXML
    private TextField txfMedarbejder;

    @FXML
    private TextField txfMedarbejderPå;

    @FXML
    private TextField txfNavn;

    @FXML
    private TextField txfNewMakeNr;

    @FXML
    private TextField txfRygeMateriale;

    @FXML
    private TextField txfRækkeNr;

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
                Destillat d = Controller.opretDestillat(txfMaltBatch.getText(), txfKornsort.getText(), txfMedarbejder.getText(),
                        Double.valueOf(txfAlkoholProcent.getText()), txfRygeMateriale.getText(), txfKommentar.getText(),
                        txfNewMakeNr.getText(), LocalDate.parse(txfStartDato.getText()), LocalDate.parse(txfSlutDato.getText()),
                        Double.valueOf(txfStartVolume.getText()));
                lvwDestillater.getItems().add(d);
                lvwDestillatPå.getItems().add(d);
                txfMaltBatch.clear();
                txfKornsort.clear();
                txfMedarbejder.clear();
                txfAlkoholProcent.clear();
                txfRygeMateriale.clear();
                txfKommentar.clear();
                txfNewMakeNr.clear();
                txfStartDato.clear();
                txfSlutDato.clear();
                txfStartVolume.clear();



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
            Fad f = Controller.opretFad(txfFadOprindelse.getText(), txfFadType.getText(), fadNr, fadStørrelse);
            lvwFade.getItems().add(f);
            lvwFadPå.getItems().add(f);
            lvwFadeWhisky.getItems().add(f);
            lvwFadeLager.getItems().add(f);
            txfFadNr.clear();
            txfFadStørrelse.clear();
            txfFadOprindelse.clear();
            txfFadType.clear();

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
            int pladsHylde = Integer.valueOf(txfHylde.getText());

            String adresse = txfAdresse.getText();
            String navn = txfNavn.getText();
            if (adresse.equals(null) || navn.equals(null)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(guiStage.getScene().getWindow());
                alert.setTitle("Indtastnings Fejl");
                alert.setHeaderText("Indtast venlist en adresse og et navn");
                alert.show();
            } else {
                Lager l = Controller.opretLager(adresse, navn, rækker, hylder,pladsHylde);
                lvwLagre.getItems().add(l);
            }
        } catch (NullPointerException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(guiStage.getScene().getWindow());
            alert.setTitle("Format Error");
            alert.setHeaderText("Fejl i indtastning");
            alert.show();
        } catch (NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(guiStage.getScene().getWindow());
            alert.setTitle("Format Error");
            alert.setHeaderText("Fejl række, hylde  eller plads på hylden");
            alert.show();
        }
    }

    //---------------------------------------------------------------------

    @FXML
    void opretPåfyldningAction(ActionEvent event) {
        try {
            List<DestillatTilPåfyldning> destillat = lvwDestillaterTilPåfyldning.getItems();
            Fad fad = lvwFadPå.getSelectionModel().getSelectedItem(); // måske ikke korrekt
            LocalDate startDato = LocalDate.parse(txfStartDatoPåfyld.getText());
            String medarbejder = txfMedarbejder.getText();
            LocalDate slutDato = LocalDate.parse(txfSlutDatoPåfyld.getText());
            for (DestillatTilPåfyldning destillatTilPåfyldning : destillat){
                if (startDato.isBefore(destillatTilPåfyldning.getDestillat().getSlutDato())){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.initOwner(guiStage.getScene().getWindow());
                    alert.setTitle("Date Error");
                    alert.setHeaderText("Start dato skal efter detillatets slut dato");
                    alert.show();
                }
            }

            if (startDato.isAfter(slutDato))
            {
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
            alert.setHeaderText("Null pointer exception");
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
    void tilføjFadTilLagerAction(ActionEvent event) { // skal laves fra lager til hylde
        try {
            int hylde = Integer.valueOf(txfHyldeNr.getText());
            int række = Integer.valueOf(txfRækkeNr.getText());
            Lager lager = lvwLagre.getSelectionModel().getSelectedItem();

            Fad fad = (Fad) lvwFadeLager.getSelectionModel().getSelectedItem();
            Controller.addFadTilHylde(fad,hylde,række,lager);
        } catch (NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(guiStage.getScene().getWindow());
            alert.setTitle("Format Error");
            alert.setHeaderText("Fejl i række eller hylde nummer");
            alert.show();
        } catch (IndexOutOfBoundsException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(guiStage.getScene().getWindow());
            alert.setTitle("Format Error");
            alert.setHeaderText("Fejl række eller hylde nr existere ikke");
            alert.show();
        } catch (IllegalArgumentException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(guiStage.getScene().getWindow());
            alert.setTitle("Format Error");
            alert.setHeaderText(ex.getMessage());
            alert.show();
        }

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

    @FXML
    void showInfoDestillat(MouseEvent event) {
        txaInfoDestillat.clear();
       Destillat d = lvwDestillater.getSelectionModel().getSelectedItem();
       txaInfoDestillat.insertText(0,d.destillatInfo());
    }

    public void initialize() {

        lvwFade.getItems().addAll(Controller.getFade());
        lvwFadeLager.getItems().addAll(Controller.getFade());
        lvwFadPå.getItems().addAll(Controller.getFade());
        lvwFadeWhisky.getItems().addAll(Controller.getFade());

        lvwDestillater.getItems().addAll(Controller.getDestillater());
        lvwDestillatPå.getItems().addAll(Controller.getDestillater());

        lvwLagre.getItems().addAll(Controller.getLagere());
    }

}
