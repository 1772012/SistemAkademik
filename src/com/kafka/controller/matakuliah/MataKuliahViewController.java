package com.kafka.controller.matakuliah;

import com.kafka.MainApp;
import com.kafka.dao.KurikulumDaoImpl;
import com.kafka.dao.MatakuliahDaoImpl;
import com.kafka.entity.Kurikulum;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import com.kafka.entity.Matakuliah;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kafka 1772012
 */
public class MataKuliahViewController implements Initializable {

    @FXML
    private TextField namaMKTextField;
    @FXML
    private Button removeMKButton;
    @FXML
    private Button editMKButton;
    @FXML
    private Button saveToExcelClick;
    @FXML
    private Button viewMKButton;
    @FXML
    private TableView<Matakuliah> MKTableView;
    @FXML
    private TableColumn<Matakuliah, String> kodeMKCol;
    @FXML
    private TableColumn<Matakuliah, String> namaMKCol;
    @FXML
    private TableColumn<Matakuliah, String> sksTeoriCol;
    @FXML
    private TableColumn<Matakuliah, String> sksPraktikumCol;
    @FXML
    private TableColumn<Matakuliah, String> kurikulumCol;
    @FXML
    private TableColumn<Matakuliah, String> descriptionCol;
    @FXML
    private BorderPane root;

    private MatakuliahDaoImpl matakuliahDaoImpl;

    private ObservableList<Matakuliah> matakuliahs;

    private Matakuliah selectedMatakuliah;

    private Stage editMKStage, addMKStage, viewMKStage;

    private KurikulumDaoImpl kurikulumDaoImpl;

    private ObservableList<Kurikulum> kurikulums;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        matakuliahDaoImpl = new MatakuliahDaoImpl();
        matakuliahs = FXCollections.observableArrayList();
        matakuliahs.addAll(matakuliahDaoImpl.getAllData());

        kurikulumDaoImpl = new KurikulumDaoImpl();
        kurikulums = FXCollections.observableArrayList();
        kurikulums.addAll(kurikulumDaoImpl.getAllData());

        MKTableView.setItems(matakuliahs);

        kodeMKCol.setCellValueFactory(data -> {
            Matakuliah mk = data.getValue();
            return new SimpleStringProperty(mk.getKodeMataKuliah());
        });

        namaMKCol.setCellValueFactory(data -> {
            Matakuliah mk = data.getValue();
            return new SimpleStringProperty(mk.getNamaMataKuliah());
        });

        sksTeoriCol.setCellValueFactory(data -> {
            Matakuliah mk = data.getValue();
            return new SimpleStringProperty(String.valueOf(mk.
                    getSksteoriMataKuliah()));
        });

        sksPraktikumCol.setCellValueFactory(data -> {
            Matakuliah mk = data.getValue();
            return new SimpleStringProperty(String.valueOf(mk.
                    getSkspraktikumMataKuliah()));
        });

        descriptionCol.setCellValueFactory(data -> {
            Matakuliah mk = data.getValue();
            return new SimpleStringProperty(mk.getDeskripsiMataKuliah());
        });

        kurikulumCol.setCellValueFactory(data -> {
            Matakuliah mk = data.getValue();
            return new SimpleStringProperty(mk.getKurikulum().getNamaKurikulum());
        });

    }

    @FXML
    private void closeClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void aboutClick(ActionEvent event) {
    }

    @FXML
    private void addMKClick(ActionEvent event) {
        try {
            if (addMKStage == null) {
                addMKStage = new Stage();
                addMKStage.setTitle("Tambah Mata Kuliah");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/matakuliah/MataKuliahAddView.fxml"));
                VBox pane = loader.load();
                MataKuliahAddViewController controller = loader.getController();
                controller.setMainController(this);
                Scene scene = new Scene(pane);
                addMKStage.setScene(scene);
                addMKStage.setResizable(false);
                addMKStage.
                        initOwner(root.getScene().getWindow());
                addMKStage.initModality(Modality.APPLICATION_MODAL);
            }
            if (!addMKStage.isShowing()) {
                addMKStage.show();
            } else {
                addMKStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(MataKuliahViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void removeMKClick(ActionEvent event) {
        matakuliahDaoImpl.removeData(selectedMatakuliah);
        matakuliahs.clear();
        matakuliahs.addAll(matakuliahDaoImpl.getAllData());
        MKTableView.setItems(matakuliahs);
        removeMKButton.setDisable(true);
        editMKButton.setDisable(true);
        viewMKButton.setDisable(true);
    }

    @FXML
    private void editMKClick(ActionEvent event) {
        try {
            if (editMKStage == null) {
                editMKStage = new Stage();
                editMKStage.setTitle("Edit Mata Kuliah");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/matakuliah/MataKuliahEditView.fxml"));
                VBox pane = loader.load();
                MataKuliahEditViewController controller = loader.getController();
                controller.setMainController(this);
                Scene scene = new Scene(pane);
                editMKStage.setScene(scene);
                editMKStage.setResizable(false);
                editMKStage.
                        initOwner(root.getScene().getWindow());
                editMKStage.initModality(Modality.APPLICATION_MODAL);
            }
            if (!editMKStage.isShowing()) {
                editMKStage.show();
            } else {
                editMKStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(MataKuliahViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void loadFromExcelClick(ActionEvent event) {
    }

    @FXML
    private void saveToExcelClick(ActionEvent event) {
    }

    @FXML
    private void viewMKClick(ActionEvent event) {
    }

    @FXML
    private void tableMKClick(MouseEvent event) {
        editMKButton.setDisable(false);
        removeMKButton.setDisable(false);
        viewMKButton.setDisable(false);
        selectedMatakuliah = MKTableView.getSelectionModel().
                getSelectedItem();
    }

    public MatakuliahDaoImpl getMatakuliahDaoImpl() {
        if (matakuliahDaoImpl == null) {
            matakuliahDaoImpl = new MatakuliahDaoImpl();
        }
        return matakuliahDaoImpl;
    }

    public ObservableList<Matakuliah> getMatakuliahs() {
        if (matakuliahs == null) {
            matakuliahs = FXCollections.observableArrayList();
        }
        return matakuliahs;
    }

    public KurikulumDaoImpl getKurikulumDaoImpl() {
        if (kurikulumDaoImpl == null) {
            kurikulumDaoImpl = new KurikulumDaoImpl();
        }
        return kurikulumDaoImpl;
    }

    public ObservableList<Kurikulum> getKurikulums() {
        if (kurikulums == null) {
            kurikulums = FXCollections.observableArrayList();
        }
        return kurikulums;
    }

    public TableView<Matakuliah> getMKTableView() {
        return MKTableView;
    }

}
