/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package taskautomation;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import taskautomation.rule.RuleList;

/**
 *
 * @author Leonardo
 */
public class TaskAutomation extends Application {
    private Thread thread;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> {
            // Interrompi il thread quando la finestra viene chiusa
            if (thread != null) {
                thread.interrupt();
            }
        });
        stage.show();
        
        // Creazione e avvio del thread
        
        thread = new Thread(() -> {
            while (true) {
                // Chiamare il metodo per controllare le regole
                Platform.runLater(() -> RuleList.getRuleList().checkRules());
                // Attendi 5 secondi
                try {
                    Thread.sleep(5000);    
                } catch (InterruptedException e) {
                }
            }
        });
        
        // Avvio del thread
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
