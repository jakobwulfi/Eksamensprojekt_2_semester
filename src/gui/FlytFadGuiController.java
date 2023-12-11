package gui;
import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Fad;
import model.Hylde;
import model.Lager;
import model.Række;

public class FlytFadGuiController {
    @FXML
    private Button btnFlytFad;

    @FXML
    private Label lblHylde;

    @FXML
    private Label lblLager;

    @FXML
    private Label lblRække;

    @FXML
    private Label lblFade;
    @FXML
    private Pane pnFlytFad;

    @FXML
    private ListView<Lager> lvwLager;

    @FXML
    private ListView<Fad> lvwFade;
    @FXML
    private TextField txfHylde;

    @FXML
    private TextField txfRække;

    @FXML
    void flytFadAction(ActionEvent event) {
        Fad fad = lvwFade.getSelectionModel().getSelectedItem();
        Lager lager = lvwLager.getSelectionModel().getSelectedItem();
        for (Række række : lager.getRækker()){
            for (Hylde hyld : række.getHylder()){
                if (!hyld.getFade().isEmpty()){
                    for (Fad fade : hyld.getFade()){
                        if (fade.getFadNr() == fad.getFadNr() ){
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.initOwner(pnFlytFad.getScene().getWindow());
                            alert.setTitle("Dupelicate error");
                            alert.setHeaderText("fadet er allerede på lageret");alert.show();
                        }
                    }
                }
            }
        }
        try {
            int rækker = Integer.valueOf(txfRække.getText());
            int hylde = Integer.valueOf(txfHylde.getText());
            Controller.addFadTilHylde(fad,hylde,rækker,lager);

            for (Lager lag : lvwLager.getItems()){
                if (!lag.equals(lager)){
                    for (Række række : lag.getRækker()){
                        for (Hylde hyld : række.getHylder()){
                            if (!hyld.getFade().isEmpty()){
                                for (Fad fade : hyld.getFade()){
                                    if (fade.equals(fad)){
                                        hyld.removeFad(fad);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            txfRække.clear();
            txfHylde.clear();
            lvwLager.getSelectionModel().clearSelection();
            lvwFade.getSelectionModel().clearSelection();
            pnFlytFad.getScene().getWindow().hide();
        }catch (NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(pnFlytFad.getScene().getWindow());
            alert.setTitle("Format error");
            alert.setHeaderText("fejl i række eller hyde tekst felt");
            alert.show();
        }


    }

    public void initialize(){
        lvwFade.getItems().addAll(Controller.getFade());
        lvwLager.getItems().addAll(Controller.getLagere());
    }

}
