/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package taskautomation.trigger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalTime;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author alessandro
 */

public class TimeInputDialogController {

    @FXML
    private Label label;
    @FXML
    private TextField textField;
    @FXML
    private Button okButton;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public LocalTime showDialog() {
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Inserisci Orario");

        okButton.setOnAction(e -> {
            if (validate()) {
                stage.close();
            }
        });

        stage.showAndWait();

        String inputTime = textField.getText();
        String[] timeParts = inputTime.split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);

        return LocalTime.of(hour, minute);
    }

    private boolean validate() {
        try {
            String[] timeParts = textField.getText().split(":");
            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1]);

            if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
                showAlert("Errore", "Inserisci un'ora valida (0-23) e un minuto valido (0-59).");
                return false;
            }

            return true;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            showAlert("Errore", "Formato dell'orario non valido. Inserisci l'orario nel formato hh:mm.");
            return false;
        }
    }

    private static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

