/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package taskautomation.trigger;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
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
public class DayOfMonthInputDialogController {

    @FXML
    private Label label;
    @FXML
    private ChoiceBox<Integer> dateBox;
    @FXML
    private Button okButton;
    
    private Stage stage;

    /**
     * Initializes the controller class.
     * @param stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int showDialog() {
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Inserisci Orario");
        
        dateBox.setItems(FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31));

        okButton.setOnAction(e -> { stage.close(); });

        stage.showAndWait();
        
        return dateBox.getValue();
    }  
    
}
