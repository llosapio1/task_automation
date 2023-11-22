/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package taskautomation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;

/**
 *
 * @author Leonardo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label title;
    @FXML
    private ListView<?> ruleListView;
    @FXML
    private Button addRuleButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        addRuleButton.setTooltip(new Tooltip("add new rule"));
    }    

    @FXML
    private void addRuleButtonAction(ActionEvent event) {
    }
    
}
