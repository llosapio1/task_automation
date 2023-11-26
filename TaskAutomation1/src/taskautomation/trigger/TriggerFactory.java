/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskautomation.trigger;

import java.io.IOException;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author alessandro
 */

public class TriggerFactory{

    public static Trigger create(String triggerType) {
        
        Trigger trigger = new BasicTrigger();

        if ("TimeOfDay".equals(triggerType)) {
            String time;
            do {
                time = JOptionPane.showInputDialog("Inserisci l'orario nel formato hh:mm");

            if (!isValidTimeFormat(time)) {
                JOptionPane.showMessageDialog(null, "Formato dell'orario non valido. Riprova.");
            }
            } while (!isValidTimeFormat(time));
            LocalTime selectedTime = LocalTime.parse(time);
            //LocalTime selectedTime = getTimeFromDialog();
            trigger = new TimeOfDayDecorator(trigger, selectedTime);
        }
        
        return trigger;
    }
    /*
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
            return null;
        }
    }
    */
    private static boolean isValidTimeFormat(String time) {
        // Definisco il pattern della regex per l'orario nel formato hh:mm
        String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(time);
        
        return matcher.matches();
    }

}
