package taskautomation;





/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import taskautomation.rule.Rule;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class FXMLDocumentAddRuleController implements Initializable {

    @FXML
    private Button createRuleButton;
    @FXML
    private TextField textFielName;
    @FXML
    private ChoiceBox<String> actionChoiceBox;
    @FXML
    private ChoiceBox<String> triggerChoiceBox;
    
    ObservableList<String> triggerListChoiceBox = FXCollections.observableArrayList("TimeOfDay");
    ObservableList<String> actionListChoiceBox = FXCollections.observableArrayList("DisplayMessage","PlayAudio");
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        triggerChoiceBox.setItems(triggerListChoiceBox);
        actionChoiceBox.setItems(actionListChoiceBox);
        
    }
    
    @FXML
    private void createRuleButtonAction(ActionEvent event) {
                Rule newRule = new Rule(textFielName.getText(), triggerChoiceBox.getValue(), actionChoiceBox.getValue());
                Stage stage = (Stage) createRuleButton.getScene().getWindow();
                stage.close();
                
                
    } 
}
