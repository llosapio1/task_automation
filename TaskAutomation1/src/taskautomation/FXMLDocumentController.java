/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package taskautomation;

import taskautomation.rule.Rule;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import taskautomation.counter.Counter;
import taskautomation.counter.CounterList;
import taskautomation.rule.RuleList;

/**
 *
 * @author Leonardo & Alejandro & Alessandro
 */
public class FXMLDocumentController implements Initializable, CountersTableObserver{
    
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
    @FXML
    private TableColumn<Rule, String> statusRuleColumn;
    @FXML
    private ObservableList<Rule> ruleListView;
    @FXML
    private Label title;
    private ListView<Counter> countersList;
    @FXML
    private HBox addCounterBox;
    @FXML
    private TextField counterName;
    @FXML
    private TextField counterValue;
    @FXML
    private TableView<Counter> countersTable;
    @FXML
    private TableColumn<Counter, String> counterNameColumn;
    @FXML
    private TableColumn<Counter, Integer> counterValueColumn;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button addCounterButton;
    @FXML
    private Label fillFieldsLabel;
    @FXML
    private Button closeButton;
    @FXML
    private Button confirmAddCounterButton;
    
    CounterList cl = CounterList.getCounterList();
    
    @Override
    public void onCountersTableUpdate() {
        countersTable.getItems().setAll(CounterList.getCounterList().get());
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Registra questa istanza come osservatore
        TaskAutomation.addObserver((CountersTableObserver) this);
        
        ruleListView = FXCollections.observableArrayList();
        
        nomeColumn.setCellValueFactory(new PropertyValueFactory("name"));
        triggerColumn.setCellValueFactory(new PropertyValueFactory("trigger"));
        azioneColumn.setCellValueFactory(new PropertyValueFactory("action"));
        statusRuleColumn.setCellValueFactory(new PropertyValueFactory("active"));
        tableView.setItems(ruleListView);
        counterNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        counterValueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        
        addCounterBox.setManaged(false);
        anchorPane.setMaxHeight(700);
        
        // All'avvio dell'applicazione aggiorna la ruleListView e la countersTableView
        aggiornaTableView();
        updateCountersTableView();
                
    }

    private void aggiornaTableView(){
        ruleListView.setAll(FXCollections.observableArrayList(RuleList.getRuleList().get()));
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
        aggiornaTableView();
    }

    @FXML
    private void closeAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void cancellaRegola(ActionEvent event) {
        //Prende la regola selezionata dall'utente
        Rule selecRule = tableView.getSelectionModel().getSelectedItem();
        
        //Cancella la regola e aggiorna la tabella
        RuleList.getRuleList().removeRule(selecRule);
        aggiornaTableView();
    }

    @FXML
    private void changeStatusRule(ActionEvent event) {
        //Prende la regola selezionata dal utente
        Rule selecRule = tableView.getSelectionModel().getSelectedItem();
        
        //Il metodo cambia lo stato della regola al suo complememento
        selecRule.toggleActive();
        aggiornaTableView();
    }
    
    private void updateCountersTableView() {
        // Collega la lista di contatori alla ListView
        countersTable.getItems().setAll(CounterList.getCounterList().get());
    }

    @FXML
    private void addCounterAction(ActionEvent event) {
        
        addCounterBox.setManaged(true);
        addCounterBox.setVisible(true);
        addCounterButton.setVisible(false);
        closeButton.setVisible(false);
        fillFieldsLabel.setVisible(true);
        anchorPane.requestFocus();
        
    }

    @FXML
    private void confirmAddCounterAction(ActionEvent event) {
        
        if (counterName.getText().isEmpty() || counterValue.getText().isEmpty()) {
            // Mostra una finestra di avviso
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Make sure to enter a name and a value for the counter.");
            alert.showAndWait();
            return;
        }
        
        Counter c = new Counter (counterName.getText(), Integer.parseInt(counterValue.getText()));
        
        if (!cl.addCounter(c)){
            // Mostra una finestra di avviso
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("A counter with this name already exists");
            alert.showAndWait();
            return;
        }
        
        // Aggiorna la ListView dei contatori
        updateCountersTableView();
        
        addCounterBox.setManaged(false);
        addCounterBox.setVisible(false);
        counterName.clear();
        counterValue.clear();
        fillFieldsLabel.setVisible(false);
        addCounterButton.setVisible(true);
        closeButton.setVisible(true);
        
    }

    @FXML
    private void updateCounterValue(ActionEvent event) {
        
        //Prende la regola selezionata dall'utente
        Counter selectedCounter = countersTable.getSelectionModel().getSelectedItem();
        
        //Aggiorna il counter e aggiorna la tabella
        if (selectedCounter != null) {
            // Apri una finestra di dialogo per inserire il nuovo valore
            TextInputDialog dialog = new TextInputDialog(String.valueOf(selectedCounter.getValue()));
            dialog.setTitle("Update Counter");
            dialog.setHeaderText("Enter the new value for the counter:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(newValue -> {
                try {
                    // Aggiorna il valore del contatore
                    int newCounterValue = Integer.parseInt(newValue);
                    CounterList.getCounterList().updateCounter(selectedCounter, newCounterValue);
                    updateCountersTableView();
                } catch (NumberFormatException e) {
                    // Mostra un messaggio di errore se l'input non è un numero
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter a valid number for the counter value.");
                    alert.showAndWait();
                }
            });
        }
    }
     
}
