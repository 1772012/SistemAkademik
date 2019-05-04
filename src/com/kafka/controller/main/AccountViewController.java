package com.kafka.controller.main;

import com.kafka.entity.Account;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Radeon
 */
public class AccountViewController implements Initializable {

    @FXML
    private HBox root;
    @FXML
    private ImageView accountPics;
    @FXML
    private Label namaLengkapLabel;
    @FXML
    private Label jabatanLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label notelpLabel;
    @FXML
    private Button closeButton;

    private MainMenuViewController mainController;

    private Account account;

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

    public void setMainController(MainMenuViewController mainController) {
        this.mainController = mainController;
        account = this.mainController.getAccount();
        namaLengkapLabel.setText(account.getNamaDepanAccount().toUpperCase()
                + " " + account.
                        getNamaBelakangAccount().toUpperCase());
        jabatanLabel.
                setText(account.getJabatan().getNamaJabatan().toUpperCase());
        emailLabel.setText(account.getEmailAccount());
        notelpLabel.setText(account.getTelpAccount());
    }

}
