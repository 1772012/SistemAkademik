package com.kafka.controller.matakuliah;

import com.kafka.MainApp;
import com.kafka.controller.main.MainMenuViewController;
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
import com.kafka.entity.Matakuliah;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
 * @author Kafka 1772012
 */
public class MataKuliahViewController implements Initializable {

    @FXML
    private Button editMKButton;
    @FXML
    private Button saveToExcelClick;
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

    private MainMenuViewController mainController;

    private double addX;
    private double addY;

    private double editX;
    private double editY;

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
        ((Stage) this.mainController.getRoot().getScene().getWindow()).show();
        ((Stage) root.getScene().getWindow()).hide();
    }

    @FXML
    private void addMKClick(ActionEvent event) {
        try {
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
            addMKStage.initStyle(StageStyle.UNDECORATED);

            pane.setOnMousePressed((MouseEvent event1) -> {
                addX = addMKStage.getX() - event1.getScreenX();
                addY = addMKStage.getY() - event1.getScreenY();
            });

            pane.setOnMouseDragged((MouseEvent event1) -> {
                addMKStage.setX(event1.getScreenX() + addX);
                addMKStage.setY(event1.getScreenY() + addY);
            });

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
    private void editMKClick(ActionEvent event) {
        try {
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
            editMKStage.initStyle(StageStyle.UNDECORATED);

            pane.setOnMousePressed((MouseEvent event1) -> {
                editX = editMKStage.getX() - event1.getScreenX();
                editY = editMKStage.getY() - event1.getScreenY();
            });

            pane.setOnMouseDragged((MouseEvent event1) -> {
                editMKStage.setX(event1.getScreenX() + editX);
                editMKStage.setY(event1.getScreenY() + editY);
            });

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
    private void loadFromExcelClick(ActionEvent event) throws
            FileNotFoundException, IOException {
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
//        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//
//        }

        ObservableList<Matakuliah> MKSheets = FXCollections.
                observableArrayList();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            row = sheet.getRow(i);
            MKSheets.add(new Matakuliah(
                    row.getCell(0).getStringCellValue(),
                    new Kurikulum(
                            (int) row.getCell(4).getNumericCellValue(),
                            row.getCell(5).getStringCellValue(),
                            row.getCell(6).getBooleanCellValue()),
                    row.getCell(1).getStringCellValue(),
                    (int) row.getCell(2).getNumericCellValue(),
                    (int) row.getCell(3).getNumericCellValue(),
                    row.getCell(7).getStringCellValue()
            ));
        }

        for (int i = 0; i < matakuliahs.size(); i++) {
            matakuliahDaoImpl.removeData(matakuliahs.get(i));
        }

        for (int i = 0; i < matakuliahs.size(); i++) {
            matakuliahDaoImpl.addData(MKSheets.get(i));
        }

        matakuliahs.clear();
        matakuliahs.addAll(matakuliahDaoImpl.getAllData());
        MKTableView.setItems(matakuliahs);

//        Map<String, Object[]> data = new TreeMap<>();
//        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
//            row = sheet.getRow(i);
//            data.put(String.valueOf(i + 1), new Object[]{
//                row.getCell(i).getStringCellValue(),
//                row.getCell(i).getStringCellValue(),
//                row.getCell(i).getStringCellValue(),
//                row.getCell(i).getStringCellValue(),
//                row.getCell(i).getStringCellValue(),
//                row.getCell(i).getStringCellValue()
//            });
//        }
    }

    @FXML
    private void saveToExcelClick(ActionEvent event
    ) {
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
            "Kode MK",
            "Nama MK",
            "SKS Teori",
            "SKS Praktikum",
            "ID Kurikulum",
            "Nama Kurikulum",
            "Status Aktif Kurikulum",
            "Deskripsi"
        });
        for (int i = 0; i < matakuliahs.size(); i++) {
            data.put(String.valueOf(i + 2), new Object[]{
                matakuliahs.get(i).getKodeMataKuliah(),
                matakuliahs.get(i).getNamaMataKuliah(),
                matakuliahs.get(i).getSksteoriMataKuliah(),
                matakuliahs.get(i).getSkspraktikumMataKuliah(),
                matakuliahs.get(i).getKurikulum().getIdkurikulum(),
                matakuliahs.get(i).getKurikulum().getNamaKurikulum(),
                matakuliahs.get(i).getKurikulum().getStatusAktifKurikulum(),
                matakuliahs.get(i).getDeskripsiMataKuliah()});
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
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                } else if (obj instanceof Boolean) {
                    cell.setCellValue((Boolean) obj);
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

        saveToExcelClick.setDisable(true);

    }

    @FXML
    private void tableMKClick(MouseEvent event
    ) {
        editMKButton.setDisable(false);
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

    public void setMainController(MainMenuViewController mainController) {
        this.mainController = mainController;
    }

    public BorderPane getRoot() {
        return root;
    }

    public Button getSaveToExcelClick() {
        return saveToExcelClick;
    }

}
