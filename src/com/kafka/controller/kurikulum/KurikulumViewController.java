package com.kafka.controller.kurikulum;

import com.kafka.controller.main.MainMenuViewController;
import com.kafka.dao.KurikulumDaoImpl;
import com.kafka.entity.Kurikulum;
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
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kafka (1772012)
 */
public class KurikulumViewController implements Initializable {

    @FXML
    private Label namaKurikulumLabel;
    @FXML
    private Button updateButton;
    @FXML
    private Button addButton;
    @FXML
    private TextField namaKurikulumTextField;
    @FXML
    private CheckBox statusAktifCB;
    @FXML
    private TableView<Kurikulum> kurikulumTableView;
    @FXML
    private TableColumn<Kurikulum, String> namaKurikulumCol;
    @FXML
    private TableColumn<Kurikulum, String> statusAktifCol;

    private ObservableList<Kurikulum> kurikulums;

    private KurikulumDaoImpl kurikulumDaoImpl;

    private Kurikulum selectedKurikulum;

    private MainMenuViewController mainController;
    @FXML
    private BorderPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        kurikulums = FXCollections.observableArrayList();

        kurikulumDaoImpl = new KurikulumDaoImpl();

        kurikulums.addAll(kurikulumDaoImpl.getAllData());

        kurikulumTableView.setItems(kurikulums);

        namaKurikulumCol.setCellValueFactory(data -> {
            Kurikulum kurikulum = data.getValue();
            return new SimpleStringProperty(kurikulum.getNamaKurikulum());
        });

        statusAktifCol.setCellValueFactory(data -> {
            Kurikulum kurikulum = data.getValue();
            return new SimpleStringProperty(String.valueOf(kurikulum.
                    getStatusAktifKurikulum()));
        });

    }

    @FXML
    private void updateClick(ActionEvent event) {
        selectedKurikulum = kurikulumTableView.getSelectionModel().
                getSelectedItem();
        selectedKurikulum.setNamaKurikulum(namaKurikulumTextField.getText());
        selectedKurikulum.setStatusAktifKurikulum(statusAktifCB.isSelected());
        kurikulumDaoImpl.updateData(selectedKurikulum);
        kurikulums.clear();
        kurikulums.addAll(kurikulumDaoImpl.getAllData());
        updateButton.setDisable(true);

    }

    @FXML
    private void addClick(ActionEvent event) {
        Kurikulum setKurikulum = new Kurikulum();
        setKurikulum.setNamaKurikulum(namaKurikulumTextField.getText());
        setKurikulum.setStatusAktifKurikulum(statusAktifCB.isSelected());

        kurikulumDaoImpl.addData(setKurikulum);
        kurikulums.clear();
        kurikulums.addAll(kurikulumDaoImpl.getAllData());
    }

    @FXML
    private void tableClick(MouseEvent event) {
        updateButton.setDisable(false);
        selectedKurikulum = kurikulumTableView.getSelectionModel().
                getSelectedItem();
        namaKurikulumTextField.setText(selectedKurikulum.getNamaKurikulum());
        statusAktifCB.setSelected(Boolean.parseBoolean(String.valueOf(
                selectedKurikulum.getStatusAktifKurikulum())));
    }

    @FXML
    private void closeClick(ActionEvent event) {
        ((Stage) this.mainController.getRoot().getScene().getWindow()).show();
        ((Stage) root.getScene().getWindow()).close();
    }

    public void setMainController(MainMenuViewController mainController) {
        this.mainController = mainController;
    }
}
