package com.kafka;

import com.kafka.util.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Kafka 1772012
 */
public class MainApp extends Application {

    private double xOffset;
    private double yOffset;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.
                setLocation(MainApp.class.
                        getResource("view/main/LoginView.fxml"));
        VBox pane = loader.load();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Login");
        primaryStage.initStyle(StageStyle.UNDECORATED);

        pane.setOnMousePressed((MouseEvent event) -> {
            xOffset = primaryStage.getX() - event.getScreenX();
            yOffset = primaryStage.getY() - event.getScreenY();
        });

        pane.setOnMouseDragged((MouseEvent event) -> {
            primaryStage.setX(event.getScreenX() + xOffset);
            primaryStage.setY(event.getScreenY() + yOffset);
        });

        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        HibernateUtil.getSessionFactory().close();
    }

}
