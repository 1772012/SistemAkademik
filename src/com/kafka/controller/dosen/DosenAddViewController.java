package com.kafka.controller.dosen;

import com.kafka.entity.Dosen;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kafka Febianto Agiharta (1772012)
 */
public class DosenAddViewController implements Initializable {

    @FXML
    private TextField nikTextField;
    @FXML
    private TextField nidnTextField;
    @FXML
    private TextField gelarDepanTextField;
    @FXML
    private TextField gelarBelakangTextField;
    @FXML
    private Label nikLabel;
    @FXML
    private Label nidnLabel;
    @FXML
    private Label namaDepanLabel;
    @FXML
    private Label namaBelakangLabel;
    @FXML
    private Label gelarDepanLabel;
    @FXML
    private Label gelarBelakangLabel;
    @FXML
    private TextField namaDepanTextField;
    @FXML
    private TextField namaBelakangTextField;
    @FXML
    private Button saveButton;
    @FXML
    private Button uploadButton;
    @FXML
    private TextField fileChooserTextField;

    private DosenViewController mainController;
    @FXML
    private VBox root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void saveClick(ActionEvent event) {
        Dosen inputDosen = new Dosen();
        inputDosen.setNikdosen(nikTextField.getText());
        inputDosen.setNidndosen(nidnTextField.getText());
        inputDosen.setNamaDepanDosen(namaDepanTextField.getText());
        inputDosen.setNamaBelakangDosen(namaBelakangTextField.getText());
        inputDosen.setGelarDepanDosen(gelarDepanTextField.getText());
        inputDosen.setGelarBelakangDosen(gelarBelakangTextField.getText());
        inputDosen.setImageDosen(fileChooserTextField.getText());
        this.mainController.getDosenDaoImpl().addData(inputDosen);
        this.mainController.getDosens().clear();
        this.mainController.getDosens().addAll(this.mainController.
                getDosenDaoImpl().getAllData());
        ((Stage) root.getScene().getWindow()).close();
    }

    @FXML
    private void uploadClick(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Upload image");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(
                "*.jpg", "*.jpg"));
        chooser.setInitialDirectory(new File("src/com/kafka/images"));
        File file = chooser.showOpenDialog(root.getScene().getWindow());

        fileChooserTextField.setText(file.getAbsolutePath());
        fileChooserTextField.setDisable(true);

    }

    public void setMainController(DosenViewController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void closeClick(ActionEvent event) {
        ((Stage) this.mainController.getRoot().getScene().getWindow()).show();
        ((Stage) root.getScene().getWindow()).close();
        this.mainController.getSaveDosenButton().setDisable(false);
    }

}
