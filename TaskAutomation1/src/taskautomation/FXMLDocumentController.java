/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package taskautomation;

import taskautomation.rule.Rule;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

/**
 *
 * @author Leonardo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label title;
    @FXML
    private ListView<Rule> ruleListView;
    @FXML
    private Button addRuleButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        addRuleButton.setTooltip(new Tooltip("add new rule"));
    }    

    @FXML
    private void addRuleButtonAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocumentAddRule.fxml"));
        
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("addRuleWindow");
        stage.setScene(new Scene(root));
        
        stage.showAndWait();
    }
     
}
