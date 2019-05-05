package com.kafka.controller.dosen;

import com.kafka.MainApp;
import com.kafka.controller.main.MainMenuViewController;
import com.kafka.dao.DosenDaoImpl;
import com.kafka.entity.Dosen;
import com.kafka.entity.Kurikulum;
import com.kafka.entity.Matakuliah;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

    private double addX;
    private double addY;

    private double editX;
    private double editY;

    private double viewX;
    private double viewY;

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
            addDosenStage.initStyle(StageStyle.UNDECORATED);

            pane.setOnMousePressed((MouseEvent event1) -> {
                addX = addDosenStage.getX() - event1.getScreenX();
                addY = addDosenStage.getY() - event1.getScreenY();
            });

            pane.setOnMouseDragged((MouseEvent event1) -> {
                addDosenStage.setX(event1.getScreenX() + addX);
                addDosenStage.setY(event1.getScreenY() + addY);
            });

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
            editDosenStage.initStyle(StageStyle.UNDECORATED);

            pane.setOnMousePressed((MouseEvent event1) -> {
                editX = editDosenStage.getX() - event1.getScreenX();
                editY = editDosenStage.getY() - event1.getScreenY();
            });

            pane.setOnMouseDragged((MouseEvent event1) -> {
                editDosenStage.setX(event1.getScreenX() + editX);
                editDosenStage.setY(event1.getScreenY() + editY);
            });

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
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Export to Excel");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(
                        "*.xlsx", "*.xlsx"));
        File file = chooser.showSaveDialog(root.getScene().getWindow());

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("matakuliahXL");
        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{
            "NIK",
            "NIDN",
            "Nama Depan",
            "Nama Belakang",
            "Gelar Depan",
            "Gelar Belakang",});
        for (int i = 0; i < dosens.size(); i++) {
            data.put(String.valueOf(i + 2), new Object[]{
                dosens.get(i).getNikdosen(),
                dosens.get(i).getNidndosen(),
                dosens.get(i).getNamaDepanDosen(),
                dosens.get(i).getNamaBelakangDosen(),
                dosens.get(i).getGelarDepanDosen(),
                dosens.get(i).getGelarBelakangDosen(),});
        }
        Set<String> keyset = data.keySet();
        int rownum = 0;

        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                }
            }

            try {
                FileOutputStream out = new FileOutputStream(new File(
                        file.getAbsolutePath()));
                wb.write(out);
                out.close();

            } catch (IOException e) {
            }

        }

        saveDosenButton.setDisable(true);
    }

    @FXML
    private void loadDosenClick(ActionEvent event) throws FileNotFoundException,
            IOException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Import from Excel");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(
                "*.xlsx", "*.xlsx"));
        File file = chooser.showOpenDialog(root.getScene().getWindow());

        FileInputStream in = new FileInputStream(
                new File(file.getAbsolutePath()));
        XSSFWorkbook wb = new XSSFWorkbook(in);
        XSSFSheet sheet = wb.getSheetAt(0);
        Row row;

        ObservableList<Dosen> dSheet = FXCollections.
                observableArrayList();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            dSheet.add(new Dosen(
                    row.getCell(0).getStringCellValue(),
                    row.getCell(1).getStringCellValue(),
                    row.getCell(2).getStringCellValue(),
                    row.getCell(3).getStringCellValue(),
                    row.getCell(4).getStringCellValue(),
                    row.getCell(5).getStringCellValue()
            ));
        }

        for (int i = 0; i < dosens.size(); i++) {
            dosenDaoImpl.removeData(dosens.get(i));
        }

        for (int i = 0; i < dosens.size(); i++) {
            dosenDaoImpl.addData(dSheet.get(i));
        }

        dosens.clear();
        dosens.addAll(dosenDaoImpl.getAllData());
        dosenTableView.setItems(dosens);
    }

    @FXML
    private void printDosenClick(ActionEvent event) {
    }

    @FXML
    private void viewDosenClick(ActionEvent event) {
        try {
            viewDosenStage = new Stage();
            viewDosenStage.setTitle("View Dosen");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/dosen/DosenViewView.fxml"));
            VBox pane = loader.load();
            DosenViewView controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(pane);
            viewDosenStage.setScene(scene);
            viewDosenStage.setResizable(false);
            viewDosenStage.initOwner(root.getScene().getWindow());
            viewDosenStage.initModality(Modality.APPLICATION_MODAL);
            viewDosenStage.initStyle(StageStyle.UNDECORATED);

            pane.setOnMousePressed((MouseEvent event1) -> {
                viewX = viewDosenStage.getX() - event1.getScreenX();
                viewY = viewDosenStage.getY() - event1.getScreenY();
            });

            pane.setOnMouseDragged((MouseEvent event1) -> {
                viewDosenStage.setX(event1.getScreenX() + viewX);
                viewDosenStage.setY(event1.getScreenY() + viewY);
            });

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
        viewDosenButton.setDisable(false);
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

    public BorderPane getRoot() {
        return root;
    }

    public Button getSaveDosenButton() {
        return saveDosenButton;
    }

}
