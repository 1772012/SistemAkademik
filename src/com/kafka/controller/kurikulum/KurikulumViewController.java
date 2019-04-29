package com.kafka.controller.kurikulum;

import java.net.URL;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author Kafka (1772012)
 */
public class KurikulumViewController implements Initializable {

    @FXML
    private Menu fileMenuLabel;
    @FXML
    private MenuItem closeMenuLabel;
    @FXML
    private Menu helpMenuLabel;
    @FXML
    private MenuItem aboutMenuLabel;
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
    private TableView<?> kurikulumTableView;
    @FXML
    private TableColumn<?, ?> namaKurikulumCol;
    @FXML
    private TableColumn<?, ?> statusAktifCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
