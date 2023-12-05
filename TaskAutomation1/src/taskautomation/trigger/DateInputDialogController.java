/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package taskautomation.trigger;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alessandro
 */
public class DateInputDialogController{

    @FXML
    private Label label;
    @FXML
    private Button okButton;
    @FXML
    private DatePicker datePicker;
    
    private Stage stage;

    /**
     * Initializes the controller class.
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public LocalDate showDialog() {
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Select the date");
        
        okButton.setOnAction(e -> { stage.close(); });

        stage.showAndWait();
        
        return datePicker.getValue();
    }  
    
}
