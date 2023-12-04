/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package taskautomation.trigger;

import java.net.URL;
import java.time.DayOfWeek;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alessandro
 */
public class DayOfWeekInputDialogController {

    @FXML
    private Label label;
    @FXML
    private ChoiceBox<DayOfWeek> dateBox;
    @FXML
    private Button okButton;
    
    private Stage stage;

    /**
     * Initializes the controller class.
     */
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public DayOfWeek showDialog() {
        
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Select the day of week");
        
        dateBox.setItems(FXCollections.observableArrayList(DayOfWeek.values()));
        

        okButton.setOnAction(e -> { stage.close(); });

        stage.showAndWait();
        
        return dateBox.getValue();
    } 
    
}
