/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

import java.io.IOException;
import java.time.LocalTime;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author alessandro
 */
// Questa classe non può implementare l'interfacci factory perché il metodo 
// create deve essere statico e un'interfaccia non può contenere metodi statici
public class TriggerFactory{

    public static Trigger create(String triggerType) {
        
        Trigger trigger = new BasicTrigger();

        if ("TimeOfDay".equals(triggerType)) {
            LocalTime selectedTime = getTimeFromDialog();
            trigger = new TimeOfDayDecorator(trigger, selectedTime);
        }
        
        return trigger;
    }
    
    private static LocalTime getTimeFromDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(TriggerFactory.class.getResource("TimeInputDialog.fxml"));
        try {
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            TimeInputDialogController controller = fxmlLoader.getController();
            controller.setStage(stage);

            return controller.showDialog();
        } catch (IOException e) {
            e.printStackTrace();
            return null; // o gestisci l'errore in modo appropriato per il tuo caso
        }
    }
    
    public int selected() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}