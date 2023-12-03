package taskautomation;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import taskautomation.azioni.Action;
import taskautomation.azioni.ActionFactory;
import taskautomation.rule.Rule;
import taskautomation.trigger.Trigger;
import taskautomation.trigger.TriggerFactory;

/**
 * FXML Controller class
 *
 * @author Leonardo & Alejandro
 */
public class FXMLDocumentAddRuleController implements Initializable {

    @FXML
    private Button createRuleButton;
    @FXML
    private ListView<Trigger> triggerView;
    @FXML
    private ListView<Action> actionView;
    @FXML
    private TextField textFieldName;
    @FXML
    private CheckBox checkActive;
    @FXML
    private VBox contentBase;
    @FXML
    private VBox triggerSelect;
    @FXML
    private VBox ActionSelect;
    @FXML
    private ChoiceBox<String> triggerChoiceBox;
    @FXML
    private ChoiceBox<String> actionChoiceBox;
    @FXML
    private CheckBox CooldownSelected;
    @FXML
    private Spinner<Integer> selectDays;
    @FXML
    private Spinner<Integer> selectHours;
    @FXML
    private Spinner<Integer> selectMinutes;
    @FXML
    private HBox timeSelector;
        
    private ObservableList<Trigger> triggerList;
    private ObservableList<Action> actionList;
    
    ObservableList<String> triggerListChoiceBox = FXCollections.observableArrayList("TimeOfDay");
    ObservableList<String> actionListChoiceBox = FXCollections.observableArrayList("DisplayMessage","PlayAudio", "AppendStringToFile", "MoveFileToDir", "CopyFileToDir", "DeleteFile", "ExecuteProgram");
    
    private Trigger trigger = null;
    private Action action = null;
    private Rule newRule;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectDays.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 31, 0));
        selectHours.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0));
        selectMinutes.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0));
        
        triggerSelect.setVisible(false);
        triggerSelect.setDisable(true);
        
        triggerChoiceBox.setItems(triggerListChoiceBox);
        actionChoiceBox.setItems(actionListChoiceBox);
        
        triggerList = FXCollections.observableArrayList();
        actionList = FXCollections.observableArrayList();

       
        triggerView.setItems(triggerList);
        actionView.setItems(actionList);
    }
    
    @FXML
    private void createRuleButtonAction(ActionEvent event) {
        if(CooldownSelected.isSelected()){
            TemporalAmount sleepingPeriod = Duration.ofDays(selectDays.getValue()).plusHours(selectHours.getValue()).plusMinutes(selectMinutes.getValue());
            newRule = new Rule(textFieldName.getText(), trigger, action, checkActive.isSelected(), sleepingPeriod);
        }
        
        else{
            newRule = new Rule(textFieldName.getText(), trigger, action, checkActive.isSelected());
        }
        Stage stage = (Stage) createRuleButton.getScene().getWindow();
        stage.close();
        
            
    } 

    @FXML
    private void addTrigger(ActionEvent event) throws IOException {
        contentBase.setVisible(false);
        contentBase.setDisable(true);
        
        triggerSelect.setVisible(true);
        triggerSelect.setDisable(false);

        /*Stage stage = (Stage)createRuleButton.getScene().getWindow();
        stage.setHeight(300);
        stage.setWidth(400);*/
    }

    @FXML
    private void addAction(ActionEvent event) {
        contentBase.setVisible(false);
        contentBase.setDisable(true);
        
        ActionSelect.setVisible(true);
        ActionSelect.setDisable(false);

        /*Stage stage = (Stage)createRuleButton.getScene().getWindow();
        stage.setHeight(300);
        stage.setWidth(400);*/
    }

    @FXML
    private void createTrigger(ActionEvent event) {
        trigger = TriggerFactory.create(triggerChoiceBox.getValue());
        triggerList.add(trigger);
        triggerView.setItems(triggerList);
        
        contentBase.setVisible(true);
        contentBase.setDisable(false);
        
        triggerSelect.setVisible(false);
        triggerSelect.setDisable(true);
        
        controlTriggerAndAction();
        
        /*Stage stage = (Stage)createRuleButton.getScene().getWindow();
        stage.setHeight(560);
        stage.setWidth(750);*/
    }

    @FXML
    private void createAction(ActionEvent event) {
        action = ActionFactory.create(actionChoiceBox.getValue());
        actionList.add(action);
        actionView.setItems(actionList);
        
        contentBase.setVisible(true);
        contentBase.setDisable(false);
        
        ActionSelect.setVisible(false);
        ActionSelect.setDisable(true);
        
        controlTriggerAndAction();
        
        /*Stage stage = (Stage)createRuleButton.getScene().getWindow();
        stage.setHeight(560);
        stage.setWidth(750);*/
    }

    @FXML
    private void changeStatusTimeSelector(ActionEvent event) {
        timeSelector.setDisable(!timeSelector.disableProperty().get());
    }

    @FXML
    private void controlTriggerAndAction() {
        if(trigger != null & action != null){
            createRuleButton.setDisable(false);
        }
            
        
    }

}
