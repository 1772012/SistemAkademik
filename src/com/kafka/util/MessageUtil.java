package com.kafka.util;

import javafx.scene.control.Alert;

/**
 *
 * @author Kafka Febianto Agiharta 1772012
 */
public class MessageUtil {

    public static void showConfirmationAlertBox(String header, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.show();
    }

}
