package taskautomation;





/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class FXMLDocumentAddRuleController implements Initializable {

    @FXML
    private Button createRuleButton;
    @FXML
    private ChoiceBox<String> triggerChoiceBox;
    @FXML
    private ChoiceBox<String> actionChoiceBox;
    
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
    }
    
    /*
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocumentAddRule.fxml"));
        
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("addRuleWindow");
        stage.setScene(new Scene(root));
        
        stage.showAndWait();
    */
    
}
