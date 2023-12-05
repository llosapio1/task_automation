/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package taskautomation.trigger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.time.LocalTime;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author alessandro
 */

public class TimeInputDialogController {

    @FXML
    private Label label;
    @FXML
    private Button okButton;

    private Stage stage;
    
    @FXML
    private ComboBox<Integer> hoursBox;
    @FXML
    private ComboBox<Integer> minutesBox;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public LocalTime showDialog() {
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Select the hour");
        
        hoursBox.setItems(FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23));
        minutesBox.setItems(FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59));

        okButton.setOnAction(e -> { stage.close(); });

        stage.showAndWait();

        int hour = hoursBox.getValue();
        int minute = minutesBox.getValue();
        
        return LocalTime.of(hour, minute);
    }
    
}

