package com.kafka.controller.main;

import com.kafka.MainApp;
import com.kafka.controller.dosen.DosenViewController;
import com.kafka.controller.kurikulum.KurikulumViewController;
import com.kafka.controller.matakuliah.MataKuliahViewController;
import com.kafka.entity.Account;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Kafka Febianto Agiharta (1772012)
 */
public class MainMenuViewController implements Initializable {

    //  ======================================================
    //  FXML Properties
    //  ======================================================
    @FXML
    private VBox root;
    @FXML
    private Button logoutButton;
    @FXML
    private Label namaDepanLabel;
    @FXML
    private Label namaBelakangLabel;

    //  ======================================================
    //  Properties
    //  ======================================================
    private Stage absensiStage, kelasStage, kurikulumStage, dosenStage, mahasiswaStage, jadwalStage, wisudaStage, accountStage, nilaiStage;

    private LoginViewController mainController;

    private Account account;

    //  ======================================================
    //  EventHandler Properties
    //  ======================================================
    private double accountX;
    private double accountY;

    private double matakuliahX;
    private double matakuliahY;

    private double kurikulumX;
    private double kurikulumY;

    private double dosenX;
    private double dosenY;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setMainController(LoginViewController mainController) {
        this.mainController = mainController;
        namaDepanLabel.setText(cekNamaDepan(this.mainController.getUsername(),
                this.mainController.getPassword()).toUpperCase());
        namaBelakangLabel.setText(cekNamaBelakang(this.mainController.
                getUsername(), this.mainController.getPassword()).toUpperCase());
        account = getAccountToThis(this.mainController.getUsername(),
                this.mainController.getPassword());
    }

    //  ======================================================
    //  Click Event
    //  ======================================================
    @FXML
    private void accountClick(MouseEvent event) {
        try {
            accountStage = new Stage();
            accountStage.setTitle("Dosen");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/main/AccountView.fxml"));
            HBox pane = loader.load();
            AccountViewController controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(pane);
            accountStage.setScene(scene);
            accountStage.setResizable(false);
            accountStage.initStyle(StageStyle.UNDECORATED);
            accountStage.initOwner(root.getScene().getWindow());
            accountStage.initModality(Modality.APPLICATION_MODAL);
            ((Stage) root.getScene().getWindow()).hide();

            pane.setOnMousePressed((MouseEvent event1) -> {
                accountX = accountStage.getX() - event1.getScreenX();
                accountY = accountStage.getY() - event1.getScreenY();
            });

            pane.setOnMouseDragged((MouseEvent event1) -> {
                accountStage.setX(event1.getScreenX() + accountX);
                accountStage.setY(event1.getScreenY() + accountY);
            });
            if (!accountStage.isShowing()) {
                accountStage.show();
            } else {
                accountStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(MainMenuViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void kelasClick(MouseEvent event) {
        try {
            kelasStage = new Stage();
            kelasStage.setTitle("Mata Kuliah");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/matakuliah/MataKuliahView.fxml"));
            BorderPane pane = loader.load();
            MataKuliahViewController controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(pane);
            kelasStage.setScene(scene);
            kelasStage.setResizable(false);
            kelasStage.initStyle(StageStyle.UNDECORATED);
            kelasStage.initOwner(root.getScene().getWindow());
            kelasStage.initModality(Modality.APPLICATION_MODAL);
            ((Stage) root.getScene().getWindow()).hide();

            pane.setOnMousePressed((MouseEvent event1) -> {
                matakuliahX = kelasStage.getX() - event1.getScreenX();
                matakuliahY = kelasStage.getY() - event1.getScreenY();
            });

            pane.setOnMouseDragged((MouseEvent event1) -> {
                kelasStage.setX(event1.getScreenX() + matakuliahX);
                kelasStage.setY(event1.getScreenY() + matakuliahY);
            });
            if (!kelasStage.isShowing()) {
                kelasStage.show();
            } else {
                kelasStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(MainMenuViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void kurikulumClick(MouseEvent event) {
        try {
            kurikulumStage = new Stage();
            kurikulumStage.setTitle("Kurikulum");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/kurikulum/KurikulumView.fxml"));
            BorderPane pane = loader.load();
            KurikulumViewController controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(pane);
            kurikulumStage.setScene(scene);
            kurikulumStage.setResizable(false);
            kurikulumStage.
                    initOwner(root.getScene().getWindow());
            kurikulumStage.initModality(Modality.APPLICATION_MODAL);
            kurikulumStage.initStyle(StageStyle.UNDECORATED);
            ((Stage) root.getScene().getWindow()).hide();

            pane.setOnMousePressed((MouseEvent event1) -> {
                kurikulumX = kurikulumStage.getX() - event1.getScreenX();
                kurikulumY = kurikulumStage.getY() - event1.getScreenY();
            });

            pane.setOnMouseDragged((MouseEvent event1) -> {
                kurikulumStage.setX(event1.getScreenX() + kurikulumX);
                kurikulumStage.setY(event1.getScreenY() + kurikulumY);
            });

            if (!kurikulumStage.isShowing()) {
                kurikulumStage.show();
            } else {
                kurikulumStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(MainMenuViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void dosenClick(MouseEvent event) {
        try {
            if (dosenStage == null) {
                dosenStage = new Stage();
                dosenStage.setTitle("Dosen");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/dosen/DosenView.fxml"));
                BorderPane pane = loader.load();
                DosenViewController controller = loader.getController();
                controller.setMainController(this);
                Scene scene = new Scene(pane);
                dosenStage.setScene(scene);
                dosenStage.setResizable(false);
                dosenStage.initOwner(root.getScene().getWindow());
                dosenStage.initModality(Modality.APPLICATION_MODAL);
                dosenStage.initStyle(StageStyle.UNDECORATED);
                ((Stage) root.getScene().getWindow()).hide();
                pane.setOnMousePressed((MouseEvent event1) -> {
                    dosenX = dosenStage.getX() - event1.getScreenX();
                    dosenY = dosenStage.getY() - event1.getScreenY();
                });

                pane.setOnMouseDragged((MouseEvent event1) -> {
                    dosenStage.setX(event1.getScreenX() + dosenX);
                    dosenStage.setY(event1.getScreenY() + dosenY);
                });

            }
            if (!dosenStage.isShowing()) {
                dosenStage.show();
            } else {
                dosenStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(MainMenuViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void mahasiswaClick(MouseEvent event) {
        try {
            if (mahasiswaStage == null) {
                mahasiswaStage = new Stage();
                mahasiswaStage.setTitle("Mahasiswa");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/mahasiswa/MahasiswaView.fxml"));
                BorderPane pane = loader.load();
                Scene scene = new Scene(pane);
                mahasiswaStage.setScene(scene);
                mahasiswaStage.setResizable(false);
                mahasiswaStage.
                        initOwner(root.getScene().getWindow());
                mahasiswaStage.initModality(Modality.APPLICATION_MODAL);
            }
            if (!mahasiswaStage.isShowing()) {
                mahasiswaStage.show();
            } else {
                mahasiswaStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(MainMenuViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void jadwalClick(MouseEvent event) {
        try {
            if (jadwalStage == null) {
                jadwalStage = new Stage();
                jadwalStage.setTitle("Jadwal");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/jadwal/JadwalView.fxml"));
                BorderPane pane = loader.load();
                Scene scene = new Scene(pane);
                jadwalStage.setScene(scene);
                jadwalStage.setResizable(false);
                jadwalStage.initOwner(root.getScene().getWindow());
                jadwalStage.initModality(Modality.APPLICATION_MODAL);
            }
            if (!jadwalStage.isShowing()) {
                jadwalStage.show();
            } else {
                jadwalStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(MainMenuViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void wisudaClick(MouseEvent event) {
        try {
            if (wisudaStage == null) {
                wisudaStage = new Stage();
                wisudaStage.setTitle("Wisuda");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource(
                        "view/wisuda/WisudaView.fxml"));
                BorderPane pane = loader.load();
                Scene scene = new Scene(pane);
                wisudaStage.setScene(scene);
                wisudaStage.setResizable(false);
                wisudaStage.initOwner(root.getScene().getWindow());
                wisudaStage.initModality(Modality.APPLICATION_MODAL);
            }
            if (!wisudaStage.isShowing()) {
                wisudaStage.show();
            } else {
                wisudaStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(MainMenuViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void absensiClick(MouseEvent event) {
        try {
            absensiStage = new Stage();
            absensiStage.setTitle("Absensi");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/absensi/AbsensiView.fxml"));
            BorderPane pane = loader.load();
            Scene scene = new Scene(pane);
            absensiStage.setScene(scene);
            absensiStage.setResizable(false);
            absensiStage.initOwner(root.getScene().getWindow());
            absensiStage.initModality(Modality.APPLICATION_MODAL);

            if (!absensiStage.isShowing()) {
                absensiStage.show();
            } else {
                absensiStage.toFront();
            }
        } catch (IOException e) {
            Logger.getLogger(MainMenuViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void nilaiClick(MouseEvent event) {
    }

    @FXML
    private void closeClick(MouseEvent event) {
        Platform.exit();
    }

    @FXML
    private void logoutClick(ActionEvent event) {
        ((Stage) this.mainController.getRoot().getScene().getWindow()).show();
        ((Stage) root.getScene().getWindow()).close();
    }

    //  ======================================================
    //  Methods
    //  ======================================================
    public String cekJabatan(String user, String pass) {
        String jabatan = "null";
        for (int i = 0; i < this.mainController.getAccounts().size(); i++) {
            if (user.equals(this.mainController.getAccounts().get(i).
                    getUsernameAccount()) && pass.equals(this.mainController.
                            getAccounts().get(i).getPassword())) {
                jabatan = this.mainController.getAccounts().get(i).getJabatan().
                        getNamaJabatan();
                break;
            }
        }
        return jabatan;
    }

    public String cekNamaDepan(String user, String pass) {
        String namaDepan = "null";
        for (int i = 0; i < this.mainController.getAccounts().size(); i++) {
            if (user.equals(this.mainController.getAccounts().get(i).
                    getUsernameAccount())
                    && pass.equals(this.mainController.getAccounts().get(i).
                            getPassword())) {
                namaDepan = this.mainController.getAccounts().get(i).
                        getNamaDepanAccount();
                break;
            }
        }
        return namaDepan;
    }

    public String cekNamaBelakang(String user, String pass) {
        String namaBelakang = "null";
        for (int i = 0; i < this.mainController.getAccounts().size(); i++) {
            if (user.equals(this.mainController.getAccounts().get(i).
                    getUsernameAccount())
                    && pass.equals(this.mainController.getAccounts().get(i).
                            getPassword())) {
                namaBelakang = this.mainController.getAccounts().get(i).
                        getNamaBelakangAccount();
                break;
            }
        }
        return namaBelakang;
    }

    //  ======================================================
    //  Getter / Setter
    //  ======================================================
    public Account getAccountToThis(String user, String pass) {
        for (int i = 0; i < this.mainController.getAccounts().size(); i++) {
            if (user.equals(this.mainController.getAccounts().get(i).
                    getUsernameAccount())
                    && pass.equals(this.mainController.getAccounts().get(i).
                            getPassword())) {
                account = this.mainController.getAccounts().get(i);
                break;
            }
        }
        return account;
    }

    public Account getAccount() {
        return account;
    }

    public VBox getRoot() {
        return root;
    }

}
