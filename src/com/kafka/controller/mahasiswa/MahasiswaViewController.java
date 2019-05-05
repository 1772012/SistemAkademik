package com.kafka.controller.mahasiswa;

import com.kafka.MainApp;
import com.kafka.controller.main.MainMenuViewController;
import com.kafka.dao.MahasiswaDaoImpl;
import com.kafka.entity.Mahasiswa;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Kafka 1772012
 */
public class MahasiswaViewController implements Initializable {

    @FXML
    private TableView<Mahasiswa> mahasiswaTableView;
    @FXML
    private TableColumn<Mahasiswa, String> nrpCol;
    @FXML
    private TableColumn<Mahasiswa, String> namaCol;
    @FXML
    private TableColumn<Mahasiswa, String> ipkCol;
    @FXML
    private TableColumn<Mahasiswa, String> dosenWaliCol;
    @FXML
    private Button editMahasiswaButton;
    @FXML
    private Button cetakDKBSButton;
    @FXML
    private BorderPane root;
    @FXML
    private TableColumn<Mahasiswa, String> namaDepanCol;
    @FXML
    private TableColumn<Mahasiswa, String> namaBelakangCol;
    @FXML
    private TableColumn<Mahasiswa, String> emailCol;

    private MainMenuViewController mainController;

    private ObservableList<Mahasiswa> mahasiswas;

    private MahasiswaDaoImpl mahasiswaDaoImpl;

    private Mahasiswa selectedMahasiswa;
    @FXML
    private TableColumn<Mahasiswa, String> jurusanCol;

    private Stage addStage, editStage;

    private double addX;
    private double addY;

    private double editX;
    private double editY;
    @FXML
    private Button saveButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mahasiswaDaoImpl = new MahasiswaDaoImpl();
        mahasiswas = FXCollections.observableArrayList();
        mahasiswas.addAll(mahasiswaDaoImpl.getAllData());
        mahasiswaTableView.setItems(mahasiswas);

        dosenWaliCol.setCellValueFactory(data -> {
            Mahasiswa mhs = data.getValue();
            String nama = mhs.getDosen().getGelarDepanDosen() + " " + mhs.
                    getDosen().getNamaDepanDosen() + " " + mhs.getDosen().
                            getNamaBelakangDosen() + " " + mhs.getDosen().
                            getGelarBelakangDosen();
            return new SimpleStringProperty(nama.trim());
        });

        emailCol.setCellValueFactory(data -> {
            Mahasiswa mhs = data.getValue();
            return new SimpleStringProperty(mhs.getEmailMahasiswa());
        });

        ipkCol.setCellValueFactory(data -> {
            Mahasiswa mhs = data.getValue();
            return new SimpleStringProperty(String.valueOf(mhs.getIpk()));
        });

        namaBelakangCol.setCellValueFactory(data -> {
            Mahasiswa mhs = data.getValue();
            return new SimpleStringProperty(mhs.getNamaBelakang());
        });

        namaDepanCol.setCellValueFactory(data -> {
            Mahasiswa mhs = data.getValue();
            return new SimpleStringProperty(mhs.getNamaDepanMahasiswa());
        });

        nrpCol.setCellValueFactory(data -> {
            Mahasiswa mhs = data.getValue();
            return new SimpleStringProperty(mhs.getNrpmahasiswa());
        });

        namaCol.setCellValueFactory(data -> {
            Mahasiswa mhs = data.getValue();
            String nama = mhs.getNamaDepanMahasiswa() + " " + mhs.
                    getNamaBelakang();
            return new SimpleStringProperty(nama);
        });

        jurusanCol.setCellValueFactory(data -> {
            Mahasiswa mhs = data.getValue();
            return new SimpleStringProperty(mhs.getJurusan().getNamaJurusan());
        });
    }

    @FXML
    private void addMahasiswaClick(ActionEvent event) {
        try {
            addStage = new Stage();
            addStage.setTitle("Add Mahasiswa");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/mahasiswa/MahasiswaAddView.fxml"));
            VBox pane = loader.load();
            MahasiswaAddViewController controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(pane);
            addStage.setScene(scene);
            addStage.setResizable(false);
            addStage.
                    initOwner(root.getScene().getWindow());
            addStage.initModality(Modality.APPLICATION_MODAL);
            addStage.initStyle(StageStyle.UNDECORATED);

            pane.setOnMousePressed((MouseEvent event1) -> {
                addX = addStage.getX() - event1.getScreenX();
                addY = addStage.getY() - event1.getScreenY();
            });

            pane.setOnMouseDragged((MouseEvent event1) -> {
                addStage.setX(event1.getScreenX() + addX);
                addStage.setY(event1.getScreenY() + addY);
            });

            if (!addStage.isShowing()) {
                addStage.show();
            } else {
                addStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(MahasiswaViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void editMahasiswaClick(ActionEvent event) {
        try {
            editStage = new Stage();
            editStage.setTitle("Edit Mahasiswa");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/mahasiswa/MahasiswaEditView.fxml"));
            VBox pane = loader.load();
            MahasiswaEditViewController controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(pane);
            editStage.setScene(scene);
            editStage.setResizable(false);
            editStage.
                    initOwner(root.getScene().getWindow());
            editStage.initModality(Modality.APPLICATION_MODAL);
            editStage.initStyle(StageStyle.UNDECORATED);

            pane.setOnMousePressed((MouseEvent event1) -> {
                editX = editStage.getX() - event1.getScreenX();
                editY = editStage.getY() - event1.getScreenY();
            });

            pane.setOnMouseDragged((MouseEvent event1) -> {
                editStage.setX(event1.getScreenX() + editX);
                editStage.setY(event1.getScreenY() + editY);
            });

            if (!editStage.isShowing()) {
                editStage.show();
            } else {
                editStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(MahasiswaViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void cetakDKBSClick(ActionEvent event) {
    }

    @FXML
    private void saveToExcelClick(ActionEvent event) {
    }

    @FXML
    private void mahasiswaTableClick(MouseEvent event) {
        selectedMahasiswa = mahasiswaTableView.getSelectionModel().
                getSelectedItem();
        cetakDKBSButton.setDisable(false);
        editMahasiswaButton.setDisable(false);
    }

    @FXML
    private void loadFromExcelClick(ActionEvent event) {
    }

    @FXML
    private void closeClick(ActionEvent event) {
        ((Stage) this.mainController.getRoot().getScene().getWindow()).show();
        ((Stage) root.getScene().getWindow()).close();
    }

    public void setMainController(MainMenuViewController mainController) {
        this.mainController = mainController;

    }

    public BorderPane getRoot() {
        return root;
    }

    public ObservableList<Mahasiswa> getMahasiswas() {
        return mahasiswas;
    }

    public MahasiswaDaoImpl getMahasiswaDaoImpl() {
        return mahasiswaDaoImpl;
    }

    public Mahasiswa getSelectedMahasiswa() {
        return selectedMahasiswa;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public TableView<Mahasiswa> getMahasiswaTableView() {
        return mahasiswaTableView;
    }

}
