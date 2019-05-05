package com.kafka.controller.dosen;

import com.kafka.MainApp;
import com.kafka.controller.main.MainMenuViewController;
import com.kafka.dao.DosenDaoImpl;
import com.kafka.entity.Dosen;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kafka Febianto Agiharta (1772012)
 */
public class DosenViewController implements Initializable {

    @FXML
    private Button editDosenButton;
    @FXML
    private Button saveDosenButton;
    @FXML
    private TableView<Dosen> dosenTableView;
    @FXML
    private TableColumn<Dosen, String> nikDosenCol;
    @FXML
    private TableColumn<Dosen, String> nidnDosenCol;
    @FXML
    private TableColumn<Dosen, String> gelarDepanCol;
    @FXML
    private TableColumn<Dosen, String> gelarBelakangCol;
    @FXML
    private TableColumn<Dosen, String> namaDepanCol;
    @FXML
    private TableColumn<Dosen, String> namaBelakangCol;
    @FXML
    private TableColumn<Dosen, String> namaDosenFullCol;
    @FXML
    private Label aboutLabel;
    @FXML
    private Button addDosenButton;
    @FXML
    private Button viewDosenButton;
    @FXML
    private Button loadDosenButton;
    @FXML
    private Button printDosenButton;
    @FXML
    private BorderPane root;

    private DosenDaoImpl dosenDaoImpl;

    private ObservableList<Dosen> dosens;

    private Stage addDosenStage, editDosenStage, viewDosenStage;

    private Dosen selectedDosen;

    private MainMenuViewController mainController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dosenDaoImpl = new DosenDaoImpl();

        dosens = FXCollections.observableArrayList();

        dosens.addAll(dosenDaoImpl.getAllData());

        dosenTableView.setItems(dosens);

        nikDosenCol.setCellValueFactory(data -> {
            Dosen dosen = data.getValue();
            return new SimpleStringProperty(dosen.getNikdosen());
        });

        nidnDosenCol.setCellValueFactory(data -> {
            Dosen dosen = data.getValue();
            return new SimpleStringProperty(dosen.getNidndosen());
        });

        namaDepanCol.setCellValueFactory(data -> {
            Dosen dosen = data.getValue();
            return new SimpleStringProperty(dosen.getNamaDepanDosen());
        });

        namaBelakangCol.setCellValueFactory(data -> {
            Dosen dosen = data.getValue();
            return new SimpleStringProperty(dosen.getNamaBelakangDosen());
        });

        gelarDepanCol.setCellValueFactory(data -> {
            Dosen dosen = data.getValue();
            return new SimpleStringProperty(dosen.getGelarDepanDosen());
        });

        gelarBelakangCol.setCellValueFactory(data -> {
            Dosen dosen = data.getValue();
            return new SimpleStringProperty(dosen.getGelarBelakangDosen());
        });

        namaDosenFullCol.setCellValueFactory(data -> {
            Dosen dosen = data.getValue();
            return new SimpleStringProperty((dosen.getGelarDepanDosen() + " "
                    + dosen.getNamaDepanDosen() + " "
                    + dosen.getNamaBelakangDosen() + " " + dosen.
                    getGelarBelakangDosen()).trim());
        });
    }

    @FXML
    private void closeClick(ActionEvent event) {
        ((Stage) this.mainController.getRoot().getScene().getWindow()).show();
        ((Stage) root.getScene().getWindow()).close();
    }

    @FXML
    private void addDosenClick(ActionEvent event) {
        try {
            addDosenStage = new Stage();
            addDosenStage.setTitle("Add Dosen");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/dosen/DosenAddView.fxml"));
            VBox pane = loader.load();
            DosenAddViewController controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(pane);
            addDosenStage.setScene(scene);
            addDosenStage.setResizable(false);
            addDosenStage.initOwner(root.getScene().getWindow());
            addDosenStage.initModality(Modality.APPLICATION_MODAL);
            if (!addDosenStage.isShowing()) {
                addDosenStage.show();
            } else {
                addDosenStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(DosenViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void editDosenClick(ActionEvent event) {
        try {
            editDosenStage = new Stage();
            editDosenStage.setTitle("Edit Dosen");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/dosen/DosenEditView.fxml"));
            VBox pane = loader.load();
            DosenEditViewController controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(pane);
            editDosenStage.setScene(scene);
            editDosenStage.setResizable(false);
            editDosenStage.initOwner(root.getScene().getWindow());
            editDosenStage.initModality(Modality.APPLICATION_MODAL);
            if (!editDosenStage.isShowing()) {
                editDosenStage.show();
            } else {
                editDosenStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(DosenViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void saveDosenClick(ActionEvent event) {
    }

    @FXML
    private void loadDosenClick(ActionEvent event) {
    }

    @FXML
    private void printDosenClick(ActionEvent event) {
    }

    @FXML
    private void viewDosenClick(ActionEvent event) {
        try {
            if (viewDosenStage == null) {
                viewDosenStage = new Stage();
                viewDosenStage.setTitle("View Dosen");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/dosen/DosenViewView.fxml"));
                VBox pane = loader.load();
                DosenAddViewController controller = loader.getController();
                //
                Scene scene = new Scene(pane);
                viewDosenStage.setScene(scene);
                viewDosenStage.setResizable(false);
                viewDosenStage.initOwner(root.getScene().getWindow());
                viewDosenStage.initModality(Modality.APPLICATION_MODAL);
            }
            if (!viewDosenStage.isShowing()) {
                viewDosenStage.show();
            } else {
                viewDosenStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(DosenViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void dosenTableViewClick(MouseEvent event) {
        editDosenButton.setDisable(false);
        selectedDosen = dosenTableView.getSelectionModel().getSelectedItem();
    }

    public DosenDaoImpl getDosenDaoImpl() {
        if (dosenDaoImpl == null) {
            dosenDaoImpl = new DosenDaoImpl();
        }
        return dosenDaoImpl;
    }

    public ObservableList<Dosen> getDosens() {
        if (dosens == null) {
            dosens = FXCollections.observableArrayList();
        }
        return dosens;
    }

    public Dosen getSelectedDosen() {
        return selectedDosen;
    }

    public TableView<Dosen> getTableDosen() {
        return dosenTableView;
    }

    public void setMainController(MainMenuViewController mainController) {
        this.mainController = mainController;
    }

}
