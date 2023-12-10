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
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import taskautomation.azioni.Action;
import taskautomation.azioni.ActionFactory;
import taskautomation.azioni.BasicAction;
import taskautomation.rule.Rule;
import taskautomation.trigger.Trigger;
import taskautomation.trigger.TriggerComposite;
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
    private Button buttonCreateTrigger;
    @FXML
    private ListView<String> triggerView;
    @FXML
    private ListView<String> actionView;
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
        
    private ObservableList<String> triggerList;
    private ObservableList<String> actionList;

    ObservableList<String> triggerListChoiceBox = FXCollections.observableArrayList("TimeOfDay", "DayOfWeek", "DayOfMonth", "Date", "FileExists", "FileSizeIsGreater", "ReturnCodeIsEqual", "CounterIsEqualToValue", "CounterIsGreaterThanValue", "CounterIsLessThanValue", "CounterIsEqualToCounter", "CounterIsGreaterThanCounter", "CounterIsLessThanCounter");
    ObservableList<String> actionListChoiceBox = FXCollections.observableArrayList("DisplayMessage","PlayAudio", "AppendStringToFile", "MoveFileToDir", "CopyFileToDir", "DeleteFile", "ExecuteProgram", "AssignValueToCounter", "AddValueToCounter", "AddCounterToCounter");
    
    private final TriggerFactory triggerFactory = new TriggerFactory();
    private final ActionFactory actionFactory = new ActionFactory();
   
    private Action action = new BasicAction();
    private Trigger trigger = null;
    
    private Rule newRule;
    @FXML
    private ScrollPane triggersCreateList;
    @FXML
    private VBox vBoxTriggersCreate;
    

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
        
        //triggerChoiceBox.setItems(triggerListChoiceBox);
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
            newRule = new Rule(textFieldName.getText(), trigger, action, checkActive.isSelected(), false, sleepingPeriod);

        }
        
        else{
            newRule = new Rule(textFieldName.getText(), trigger, action, checkActive.isSelected(), !CooldownSelected.isSelected());
        }
        Stage stage = (Stage) createRuleButton.getScene().getWindow();
        stage.close();
        
            
    } 

    
    @FXML
    private void createTrigger(ActionEvent event) {
        triggerList.setAll(trigger.toString().split("\n"));
        triggerView.setItems(triggerList);
        
        changeSceneToFrom(contentBase, triggerSelect);
        controlTriggerAndAction();
    }

    @FXML
    private void createAction(ActionEvent event) {
        action = actionFactory.create(actionChoiceBox.getValue(), action);
        
        actionList.setAll(action.toString().split("\n"));
        actionView.setItems(actionList);
            
        changeSceneToFrom(contentBase, ActionSelect);
        controlTriggerAndAction();
    }

    @FXML
    private void changeStatusTimeSelector(ActionEvent event) {
        timeSelector.setDisable(!timeSelector.disableProperty().get());
    }

    @FXML
    private void controlTriggerAndAction() {
        if(trigger != null & action != null & !textFieldName.getText().isEmpty()){
            createRuleButton.setDisable(false);
        }
    }
    
    private void changeSceneToFrom(VBox to, VBox from){
        to.setVisible(true);
        to.setDisable(false);
        
        from.setVisible(false);
        from.setDisable(true);
    }
    
    @FXML
    private void addTrigger(ActionEvent event) throws IOException {
        changeSceneToFrom(triggerSelect, contentBase);
    }

    @FXML
    private void addAction(ActionEvent event) {
        changeSceneToFrom(ActionSelect, contentBase);
    }

    @FXML
    private void addComplexTrigger(ActionEvent event) {
        HBox parametriTriggerComplesso = new HBox(10);
        HBox parametriOperazione = new HBox(10);
        
        parametriTriggerComplesso.setPrefHeight(50);
        parametriTriggerComplesso.setAlignment(Pos.CENTER);

        Label label1 = new Label("Trigger 1: "); 
        label1.setFont(new Font(14));
        
        ChoiceBox<String> boolean1 = new ChoiceBox<>();
        boolean1.getItems().addAll("Defaul", "Not");
        boolean1.setMaxWidth(70);
        ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
        choiceBox1.setItems(triggerListChoiceBox);
        choiceBox1.setMaxWidth(120);
        
        Label label2 = new Label("Operazione: ");
        label2.setFont(new Font(14));
        
        ChoiceBox<String> choiceBox2 = new ChoiceBox<>();
        choiceBox2.getItems().addAll("OR", "AND");
        choiceBox2.setMaxWidth(60);
        
        Label label3 = new Label("Trigger 2: ");
        label3.setFont(new Font(14));
        
        ChoiceBox<String> boolean2 = new ChoiceBox<>();
        boolean2.getItems().addAll("Defaul", "Not");
        boolean2.setMaxWidth(70);
        ChoiceBox<String> choiceBox3 = new ChoiceBox<>();
        choiceBox3.setItems(triggerListChoiceBox);
        choiceBox3.setMaxWidth(120);
        
        Button button = new Button("Add");
        Button buttonDelete = new Button("Delete");
        EventHandler<ActionEvent> buttonDeleteClickHandler = (ActionEvent event1) -> {
            vBoxTriggersCreate.getChildren().remove(parametriTriggerComplesso);
            vBoxTriggersCreate.getChildren().remove(parametriOperazione);
            triggersCreateList.setContent(vBoxTriggersCreate);
        };
        buttonDelete.setOnAction(buttonDeleteClickHandler);

        
        if(!vBoxTriggersCreate.getChildren().isEmpty()){
            parametriOperazione.setAlignment(Pos.CENTER);
            
            Label label4 = new Label("Operazione tra triggers: ");
            label4.setFont(new Font(14));
            
            ChoiceBox<String> choiceBox4 = new ChoiceBox<>();
            choiceBox4.getItems().addAll("OR", "AND");
            choiceBox4.setMaxWidth(60);
            
            parametriOperazione.getChildren().addAll(label4, choiceBox4);
            vBoxTriggersCreate.getChildren().add(parametriOperazione);
            
            EventHandler<ActionEvent> buttonClickHandler = (ActionEvent event1) -> {
                boolean var = aggiungeTrigger(boolean1.getValue(), choiceBox1.getValue(), boolean2.getValue(), choiceBox3.getValue(), choiceBox2.getValue(), choiceBox4.getValue());
                if(var){
                    parametriTriggerComplesso.setStyle("-fx-background-color: lightblue;");
                    button.setDisable(var);
                    buttonDelete.setDisable(var);
                    buttonCreateTrigger.setDisable(false);
                }
            };
            button.setOnAction(buttonClickHandler);
            
        } else {
            EventHandler<ActionEvent> buttonClickHandler = (ActionEvent event1) -> {
                boolean var = aggiungeTrigger(boolean1.getValue(), choiceBox1.getValue(), boolean2.getValue(), choiceBox3.getValue(), choiceBox2.getValue(), null);
                if(var){
                    parametriTriggerComplesso.setStyle("-fx-background-color: lightblue;");
                    button.setDisable(var);
                    buttonDelete.setDisable(var);
                    buttonCreateTrigger.setDisable(false);
                }
            };
            
            button.setOnAction(buttonClickHandler);
        }

        parametriTriggerComplesso.getChildren().addAll(label1, boolean1, choiceBox1, label2, choiceBox2, label3, boolean2, choiceBox3, button, buttonDelete);
        vBoxTriggersCreate.getChildren().add(parametriTriggerComplesso);
        triggersCreateList.setContent(vBoxTriggersCreate);
    }

    @FXML
    private void addSimpleTrigger(ActionEvent event) {
        HBox parametriTriggerSimple = new HBox(10);
        parametriTriggerSimple.setPrefHeight(50);
        parametriTriggerSimple.setAlignment(Pos.CENTER);
        
        HBox parametriOperazione = new HBox(10);

        Label label1 = new Label("Trigger:   "); 
        label1.setFont(new Font(16));
        
        ChoiceBox<String> boolean1 = new ChoiceBox<>();
        boolean1.getItems().addAll("Defaul", "Not");
        boolean1.setMaxWidth(70);
        ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
        choiceBox1.setItems(triggerListChoiceBox);
        choiceBox1.setMaxWidth(120);
        
        Button button = new Button("Add");
        Button buttonDelete = new Button("Delete");
        EventHandler<ActionEvent> buttonDeleteClickHandler = (ActionEvent event1) -> {
            vBoxTriggersCreate.getChildren().remove(parametriTriggerSimple);
            vBoxTriggersCreate.getChildren().remove(parametriOperazione);
            triggersCreateList.setContent(vBoxTriggersCreate);
        };
        buttonDelete.setOnAction(buttonDeleteClickHandler);
        
        if(!vBoxTriggersCreate.getChildren().isEmpty()){
            parametriOperazione.setAlignment(Pos.CENTER);
            
            Label label4 = new Label("Operazione tra triggers: ");
            label4.setFont(new Font(14));
            
            ChoiceBox<String> choiceBox4 = new ChoiceBox<>();
            choiceBox4.getItems().addAll("OR", "AND");
            choiceBox4.setMaxWidth(60);
            
            parametriOperazione.getChildren().addAll(label4, choiceBox4);
            vBoxTriggersCreate.getChildren().add(parametriOperazione);
            
            EventHandler<ActionEvent> buttonClickHandler = (ActionEvent event1) -> { 
                boolean var = aggiungeSimpleTrigger(boolean1.getValue(), choiceBox1.getValue(), choiceBox4.getValue());
                if(var){
                    parametriTriggerSimple.setStyle("-fx-background-color: lightblue;");
                    button.setDisable(var);
                    buttonDelete.setDisable(var);
                    buttonCreateTrigger.setDisable(false);
                    
                }
                
            };
            button.setOnAction(buttonClickHandler);
            
        } else {
            EventHandler<ActionEvent> buttonClickHandler = (ActionEvent event1) -> {
                boolean var = aggiungeSimpleTrigger(boolean1.getValue(), choiceBox1.getValue(), null);
                if(var){
                    parametriTriggerSimple.setStyle("-fx-background-color: lightblue;");
                    button.setDisable(var);
                    buttonDelete.setDisable(var);
                    buttonCreateTrigger.setDisable(false);
                }
            };
            
            button.setOnAction(buttonClickHandler);
        }

        parametriTriggerSimple.getChildren().addAll(label1, boolean1, choiceBox1, button);
        vBoxTriggersCreate.getChildren().add(parametriTriggerSimple);
        triggersCreateList.setContent(vBoxTriggersCreate);
    }
    

    private boolean aggiungeTrigger(String boleanTrigger1, String typeTrigger1, String boleanTrigger2, String typeTrigger2, String typeOP, String typeOP2) {
        TriggerComposite triggerTemp = (TriggerComposite)triggerFactory.create(typeOP);
           
        Trigger triggerComponent1 = triggerFactory.create(typeTrigger1);
        
        if(boleanTrigger1.equalsIgnoreCase("NOT")){
            TriggerComposite triggerNOT = (TriggerComposite)triggerFactory.create("NOT");
            triggerNOT.add(triggerComponent1);
            triggerComponent1 = triggerNOT;
        }
        
        Trigger triggerComponent2 = triggerFactory.create(typeTrigger2);
        
        if(boleanTrigger2.equalsIgnoreCase("NOT")){
            TriggerComposite triggerNOT = (TriggerComposite)triggerFactory.create("NOT");
            triggerNOT.add(triggerComponent2);
            triggerComponent2 = triggerNOT;
        }
        
        triggerTemp.add(triggerComponent1);
        triggerTemp.add(triggerComponent2);
        
        if(typeOP2 != null){
           TriggerComposite triggerTemp2 = (TriggerComposite)triggerFactory.create(typeOP2);
           triggerTemp2.add(trigger);
           triggerTemp2.add(triggerTemp);
           trigger = triggerTemp2;
        }
        else{
           trigger = triggerTemp;
        }
        
        return trigger != null;
    }

    private boolean aggiungeSimpleTrigger(String boleanTrigger, String typeTrigger, String typeOP2){
        Trigger triggerComponent = triggerFactory.create(typeTrigger);
        
        if(boleanTrigger.equalsIgnoreCase("NOT")){
            TriggerComposite triggerNOT = (TriggerComposite)triggerFactory.create("NOT");
            triggerNOT.add(triggerComponent);
            triggerComponent = triggerNOT;
        }
        
        if(typeOP2 != null){
            TriggerComposite triggerTemp = (TriggerComposite)triggerFactory.create(typeOP2);
            triggerTemp.add(trigger);
            triggerTemp.add(triggerComponent);
            trigger = triggerTemp;
        }
        else{
            trigger = triggerComponent;
        }
        
        return trigger != null;
    }
}
