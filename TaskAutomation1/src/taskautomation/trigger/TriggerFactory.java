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
import taskautomation.Factory;

/**
 *
 * @author alessandro
 */

public class TriggerFactory implements Factory<Trigger>{

    @Override
    public Trigger create(String triggerType, Trigger trigger) {
        Trigger decoratedTrigger = new BasicTrigger();
        if ("TimeOfDay".equals(triggerType)) {
            LocalTime time = getTimeFromDialog();
            decoratedTrigger = new TimeOfDayDecorator(trigger, time);
        }
        return decoratedTrigger;
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
            return null;
        }
    }


}
