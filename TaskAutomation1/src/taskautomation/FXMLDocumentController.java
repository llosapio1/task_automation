/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package taskautomation;

import taskautomation.rule.Rule;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import taskautomation.rule.RuleList;

/**
 *
 * @author Leonardo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button addRuleButton;
    @FXML
    private TableView<Rule> tableView;
    @FXML
    private TableColumn<Rule, String> nomeColumn;
    @FXML
    private TableColumn<Rule, String> triggerColumn;
    @FXML
    private TableColumn<Rule, String> azioneColumn;
    
    private ObservableList<Rule> ruleListView;
    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ruleListView = FXCollections.observableArrayList();
        
        nomeColumn.setCellValueFactory(new PropertyValueFactory("name"));
        triggerColumn.setCellValueFactory(new PropertyValueFactory("trigger"));
        azioneColumn.setCellValueFactory(new PropertyValueFactory("action"));
        tableView.setItems(ruleListView);
        
    }    

    @FXML
    private void addRuleButtonAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocumentAddRule.fxml"));
        
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("addRuleWindow");
        stage.setScene(new Scene(root));
        
        stage.showAndWait();
        
        // Dopo che la finestra di aggiunta regola è chiusa, aggiorna la ruleListView
        ruleListView.setAll(FXCollections.observableArrayList(RuleList.getRuleList().get()));
    }

    @FXML
    private void closeAction(ActionEvent event) {
        Platform.exit();
    }
     
}
