package com.kafka.controller.wisuda;

import com.kafka.controller.main.MainMenuViewController;
import com.kafka.dao.MahasiswaDaoImpl;
import com.kafka.dao.WisudaDaoImpl;
import com.kafka.entity.Mahasiswa;
import com.kafka.entity.Wisuda;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kafka 1772012
 */
public class WisudaViewController implements Initializable {

    @FXML
    private ComboBox<Mahasiswa> nrpComboBox;
    @FXML
    private Button editWisudaButton;
    @FXML
    private Button saveWisudaButton;
    @FXML
    private TableView<Wisuda> wisudaTableView;
    @FXML
    private TableColumn<Wisuda, String> periodeCol;
    @FXML
    private TableColumn<Wisuda, String> nrpCol;
    @FXML
    private TableColumn<Wisuda, String> judulTAInggrisCol;
    @FXML
    private TableColumn<Wisuda, String> judulTAIndoCol;
    @FXML
    private TableColumn<Wisuda, String> cekalCol;
    @FXML
    private BorderPane root;
    @FXML
    private TextField periodeTextField;
    @FXML
    private TextField taIngTextField;
    @FXML
    private TextField taIndTextField;
    @FXML
    private CheckBox cekalCb;

    private MainMenuViewController mainController;

    private MahasiswaDaoImpl mahasiswaDaoImpl;

    private WisudaDaoImpl wisudaDaoImpl;

    private ObservableList<Mahasiswa> mahasiswas;

    private ObservableList<Wisuda> wisudas;

    private Wisuda selectedWisuda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void closeClick(ActionEvent event) {
        ((Stage) this.mainController.getRoot().getScene().getWindow()).show();
        ((Stage) root.getScene().getWindow()).close();
    }

    @FXML
    private void addWisudaClick(ActionEvent event) {
    }

    @FXML
    private void editWisudaClick(ActionEvent event) {

    }

    @FXML
    private void saveWisudaClick(ActionEvent event) {
    }

    public void setMainController(MainMenuViewController mainController) {
        this.mainController = mainController;

        wisudas = FXCollections.observableArrayList();
        mahasiswas = FXCollections.observableArrayList();

        mahasiswaDaoImpl = new MahasiswaDaoImpl();
        wisudaDaoImpl = new WisudaDaoImpl();

        mahasiswas.addAll(mahasiswaDaoImpl.getAllData());
        nrpComboBox.setItems(mahasiswas);

        wisudas.addAll(wisudaDaoImpl.getAllData());
        wisudaTableView.setItems(wisudas);

        cekalCol.setCellValueFactory(data -> {
            Wisuda wisuda = data.getValue();
            return new SimpleStringProperty(String.valueOf(wisuda.
                    getStatusCekalWisuda()));
        });

        judulTAIndoCol.setCellValueFactory(data -> {
            Wisuda wisuda = data.getValue();
            return new SimpleStringProperty(wisuda.getJudulTaindonesiaWisuda());
        });

        judulTAInggrisCol.setCellValueFactory(data -> {
            Wisuda wisuda = data.getValue();
            return new SimpleStringProperty(wisuda.getJudulTainggrisWisuda());
        });

        nrpCol.setCellValueFactory(data -> {
            Wisuda wisuda = data.getValue();
            return new SimpleStringProperty(wisuda.getMahasiswa().
                    getNrpmahasiswa());
        });

        periodeCol.setCellValueFactory(data -> {
            Wisuda wisuda = data.getValue();
            return new SimpleStringProperty(wisuda.getId().getPeriodeWisuda());
        });

    }

    @FXML
    private void tableClick(MouseEvent event) {
        selectedWisuda = wisudaTableView.getSelectionModel().getSelectedItem();
        periodeTextField.setText(selectedWisuda.getId().getPeriodeWisuda());
        editWisudaButton.setDisable(true);
        taIndTextField.setText(selectedWisuda.getJudulTaindonesiaWisuda());
        taIngTextField.setText(selectedWisuda.getJudulTainggrisWisuda());
        nrpComboBox.setValue(selectedWisuda.getMahasiswa());
        cekalCb.setSelected(selectedWisuda.getStatusCekalWisuda());
    }

}
